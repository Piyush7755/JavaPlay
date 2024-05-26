package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import services.PostService;
import services.UserService;
import util.PostsPager;

import models.Post;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;


public class BlogController extends Controller {

    private static final int N_OF_LATEST_POSTS = 20;
    private final PostService postService;
    private final UserService userService;

    @Inject
    public BlogController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }


    public Result blog(int page) {
        String uname = session().get("username");
        System.out.println("Blogs");
        if (uname==null){
            return badRequest("please login");
        }

        PostsPager posts = postService.findNLatestPosts(N_OF_LATEST_POSTS, page);
        return ok(Json.toJson(posts));
    }


    public Result usersBlog(String username , int page) {
        String uname = session().get("username");
        if (uname==null){
            return badRequest("please login");
        }
        if (!uname.equals(username)) {
            // User is not the owner of Post
            return badRequest("You are not allowed to delete this post");
        }

//        String username = session().get("username");
        System.out.println("User Blogs");
        Optional<PostsPager> posts = postService.findNLatestPostsForUsername(N_OF_LATEST_POSTS, page, username);
        return ok(Json.toJson(posts));
    }
}
