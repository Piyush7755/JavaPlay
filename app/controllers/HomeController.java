package controllers;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;



public class HomeController extends Controller {


    public Result index() {

        return ok("Your new application is ready.");
    }

}
