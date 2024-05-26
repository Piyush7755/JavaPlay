
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/piyush/Desktop/PostApp/conf/routes
// @DATE:Sun May 19 21:56:01 IST 2024


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
