package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import dto.LoginDTO;
import dto.UserDTO;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;

import javax.inject.Inject;


public class UserController extends Controller {

    private final UserService userService;

    @Inject
    public UserController(UserService userService, FormFactory formFactory) {
        this.userService = userService;

    }

    public Result login() {
        JsonNode requestBody = request().body().asJson();
        if (requestBody == null) {
            return badRequest("Expecting JSON data");
        }

        // Convert JSON request body to LoginDTO object
        System.out.println(requestBody);
        LoginDTO logindto = Json.fromJson(requestBody, LoginDTO.class);

        return userService.authenticateUser(logindto)
                .map(loginDTO -> {
                    session("username", loginDTO.username);
                    return ok("Login successful");
                })
                .orElse(badRequest("Your username and password didn't match. Please try again."));
    }


    public Result logout() {
        session().clear();
        return ok("Logged out successfully");
    }


    public Result register() {
        JsonNode requestBody = request().body().asJson();
        if (requestBody == null) {
            return badRequest("Expecting JSON data");
        }

        // Convert JSON request body to UserDTO object
        System.out.println(requestBody);
        UserDTO userDTO = Json.fromJson(requestBody, UserDTO.class);

        return userService.saveUser(userDTO)
                .map(userdto -> ok("User registered successfully"))
                .orElse(badRequest("Registration failed"));
    }
}
