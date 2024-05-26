package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import dto.CommentDTO;
import dto.LoginDTO;
import dto.PostDTO;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import services.CommentService;
import services.PostService;


import javax.inject.Inject;
import java.util.*;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class PostController extends Controller {

    private final PostService postService;
    private final CommentService commentService;


    @Inject
    public PostController(PostService postService, CommentService commentService, FormFactory formFactory) {
        this.postService = postService;
        this.commentService = commentService;

    }

    /**
     * GET Post page for post with id = postId.
     */
    public Result getPost(Long postId) {
        String uname = session().get("username");
        if (uname==null){
            return badRequest("please login");
        }
        Optional<List<CommentDTO>> commentsOpt = commentService.findCommentsForPost(postId);
        Map<String, Object> responseData = new HashMap<>();
        if (commentsOpt.isPresent()) {
            List<CommentDTO> commentDTOs = commentsOpt.get();
            responseData.put("comments", commentDTOs);
        }


        Optional<PostDTO> postOpt = postService.getPost(postId);
        if (!postOpt.isPresent()) {
            return Results.notFound();
        }

        PostDTO postDTO = postOpt.get();

        responseData.put("post", postDTO);


        return ok(Json.toJson(responseData));
    }


    public Result createPost() {
        String uname = session().get("username");
        if (uname==null){
            return badRequest("please login");
        }
        JsonNode requestBody = request().body().asJson();
        if (requestBody == null) {
            return badRequest(Json.toJson("Invalid JSON data"));
        }

        PostDTO postDTO= Json.fromJson(requestBody, PostDTO.class);


        // Add your validation logic here if needed
        System.out.println(requestBody);
        postDTO.username = session("username");
        postDTO = postService.savePost(postDTO);

        if (postDTO == null) {
            return internalServerError(Json.toJson("Failed to save post"));
        }

        return ok(Json.toJson(postDTO));
    }

    public Result deletePost(Long postId) {
        String username = session().get("username");
        if (username==null){
            return badRequest("please login");
        }
        Optional<PostDTO> optionalPost = postService.getPost(postId);
        if (!optionalPost.isPresent()) {
            return badRequest("Not found");
        }
        if (!optionalPost.get().username.equals(username)) {
            // User is not the owner of Post
            return badRequest("You are not allowed");
        }
        postService.delete(postId);
        return ok("Post Deleted successfully");
    }

}
