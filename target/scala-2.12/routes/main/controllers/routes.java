
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/piyush/Desktop/PostApp/conf/routes
// @DATE:Sun May 19 21:56:01 IST 2024

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReversePostController PostController = new controllers.ReversePostController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCommentController CommentController = new controllers.ReverseCommentController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseBlogController BlogController = new controllers.ReverseBlogController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReversePostController PostController = new controllers.javascript.ReversePostController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCommentController CommentController = new controllers.javascript.ReverseCommentController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseBlogController BlogController = new controllers.javascript.ReverseBlogController(RoutesPrefix.byNamePrefix());
  }

}
