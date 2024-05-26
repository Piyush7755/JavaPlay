
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/piyush/Desktop/PostApp/conf/routes
// @DATE:Sun May 19 21:56:01 IST 2024

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:8
package controllers {

  // @LINE:26
  class ReversePostController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def deletePost(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "post/delete" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Long]].unbind("id", id)))))
    }
  
    // @LINE:26
    def getPost(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "post" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Long]].unbind("id", id)))))
    }
  
    // @LINE:30
    def createPost(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "post")
    }
  
  }

  // @LINE:37
  class ReverseCommentController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def createComment(postId:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "comment" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Long]].unbind("postId", postId)))))
    }
  
  }

  // @LINE:15
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def logout(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:21
    def register(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "register")
    }
  
    // @LINE:15
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:8
  class ReverseBlogController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def blog(page:Int = 1): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "blog" + play.core.routing.queryString(List(if(page == 1) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("page", page)))))
    }
  
    // @LINE:11
    def usersBlog(username:String, page:Int = 1): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "blog/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("username", username)) + play.core.routing.queryString(List(if(page == 1) None else Some(implicitly[play.api.mvc.QueryStringBindable[Int]].unbind("page", page)))))
    }
  
  }


}
