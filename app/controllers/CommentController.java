package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dto.CommentDTO;
import dto.PostDTO;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.CommentService;

import javax.inject.Inject;


public class CommentController extends Controller {

    private final CommentService commentService;

    @Inject
    public CommentController(CommentService commentService, FormFactory formFactory) {
        this.commentService = commentService;

    }


    public Result createComment(Long postId) {
        String uname = session().get("username");
        if (uname==null){
            return badRequest("please login");
        }
        JsonNode requestBody = request().body().asJson();
        if (requestBody == null) {
            return badRequest(Json.toJson("Invalid JSON data"));
        }
        System.out.println(requestBody);
        CommentDTO commentDTO= Json.fromJson(requestBody, CommentDTO.class);

        commentDTO.username = session("username");
        commentDTO.postId = postId;
        commentService.saveComment(commentDTO);

        return ok(Json.toJson(commentDTO));
        }

}
