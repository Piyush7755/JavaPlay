
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/piyush/Desktop/PostApp/conf/routes
// @DATE:Sun May 19 21:56:01 IST 2024

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:8
  BlogController_2: controllers.BlogController,
  // @LINE:15
  UserController_1: controllers.UserController,
  // @LINE:26
  PostController_3: controllers.PostController,
  // @LINE:37
  CommentController_0: controllers.CommentController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    BlogController_2: controllers.BlogController,
    // @LINE:15
    UserController_1: controllers.UserController,
    // @LINE:26
    PostController_3: controllers.PostController,
    // @LINE:37
    CommentController_0: controllers.CommentController
  ) = this(errorHandler, BlogController_2, UserController_1, PostController_3, CommentController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, BlogController_2, UserController_1, PostController_3, CommentController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """blog""", """controllers.BlogController.blog(page:Int ?= 1)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """blog/""" + "$" + """username<[^/]+>""", """controllers.BlogController.usersBlog(username:String, page:Int ?= 1)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.UserController.login"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.UserController.logout"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.UserController.register"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post""", """controllers.PostController.getPost(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post""", """controllers.PostController.createPost"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post/delete""", """controllers.PostController.deletePost(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comment""", """controllers.CommentController.createComment(postId:Long)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:8
  private[this] lazy val controllers_BlogController_blog0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("blog")))
  )
  private[this] lazy val controllers_BlogController_blog0_invoker = createInvoker(
    BlogController_2.blog(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BlogController",
      "blog",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """blog""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:11
  private[this] lazy val controllers_BlogController_usersBlog1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("blog/"), DynamicPart("username", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BlogController_usersBlog1_invoker = createInvoker(
    BlogController_2.usersBlog(fakeValue[String], fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BlogController",
      "usersBlog",
      Seq(classOf[String], classOf[Int]),
      "GET",
      this.prefix + """blog/""" + "$" + """username<[^/]+>""",
      """ Blog page of user :username, showing blog posts from this users in reversed order of the date of publication""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:15
  private[this] lazy val controllers_UserController_login2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_UserController_login2_invoker = createInvoker(
    UserController_1.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "login",
      Nil,
      "POST",
      this.prefix + """login""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:17
  private[this] lazy val controllers_UserController_logout3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_UserController_logout3_invoker = createInvoker(
    UserController_1.logout,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout""",
      """ Logout user""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_UserController_register4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_UserController_register4_invoker = createInvoker(
    UserController_1.register,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "register",
      Nil,
      "POST",
      this.prefix + """register""",
      """ Create new user""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:26
  private[this] lazy val controllers_PostController_getPost5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post")))
  )
  private[this] lazy val controllers_PostController_getPost5_invoker = createInvoker(
    PostController_3.getPost(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "getPost",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """post""",
      """ Blog post page for id of :id""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:30
  private[this] lazy val controllers_PostController_createPost6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post")))
  )
  private[this] lazy val controllers_PostController_createPost6_invoker = createInvoker(
    PostController_3.createPost,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "createPost",
      Nil,
      "POST",
      this.prefix + """post""",
      """ Create new post""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:34
  private[this] lazy val controllers_PostController_deletePost7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post/delete")))
  )
  private[this] lazy val controllers_PostController_deletePost7_invoker = createInvoker(
    PostController_3.deletePost(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "deletePost",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """post/delete""",
      """ Deletes post with id of :id""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:37
  private[this] lazy val controllers_CommentController_createComment8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comment")))
  )
  private[this] lazy val controllers_CommentController_createComment8_invoker = createInvoker(
    CommentController_0.createComment(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CommentController",
      "createComment",
      Seq(classOf[Long]),
      "POST",
      this.prefix + """comment""",
      """""",
      Seq("""nocsrf""")
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:8
    case controllers_BlogController_blog0_route(params@_) =>
      call(params.fromQuery[Int]("page", Some(1))) { (page) =>
        controllers_BlogController_blog0_invoker.call(BlogController_2.blog(page))
      }
  
    // @LINE:11
    case controllers_BlogController_usersBlog1_route(params@_) =>
      call(params.fromPath[String]("username", None), params.fromQuery[Int]("page", Some(1))) { (username, page) =>
        controllers_BlogController_usersBlog1_invoker.call(BlogController_2.usersBlog(username, page))
      }
  
    // @LINE:15
    case controllers_UserController_login2_route(params@_) =>
      call { 
        controllers_UserController_login2_invoker.call(UserController_1.login)
      }
  
    // @LINE:17
    case controllers_UserController_logout3_route(params@_) =>
      call { 
        controllers_UserController_logout3_invoker.call(UserController_1.logout)
      }
  
    // @LINE:21
    case controllers_UserController_register4_route(params@_) =>
      call { 
        controllers_UserController_register4_invoker.call(UserController_1.register)
      }
  
    // @LINE:26
    case controllers_PostController_getPost5_route(params@_) =>
      call(params.fromQuery[Long]("id", None)) { (id) =>
        controllers_PostController_getPost5_invoker.call(PostController_3.getPost(id))
      }
  
    // @LINE:30
    case controllers_PostController_createPost6_route(params@_) =>
      call { 
        controllers_PostController_createPost6_invoker.call(PostController_3.createPost)
      }
  
    // @LINE:34
    case controllers_PostController_deletePost7_route(params@_) =>
      call(params.fromQuery[Long]("id", None)) { (id) =>
        controllers_PostController_deletePost7_invoker.call(PostController_3.deletePost(id))
      }
  
    // @LINE:37
    case controllers_CommentController_createComment8_route(params@_) =>
      call(params.fromQuery[Long]("postId", None)) { (postId) =>
        controllers_CommentController_createComment8_invoker.call(CommentController_0.createComment(postId))
      }
  }
}
