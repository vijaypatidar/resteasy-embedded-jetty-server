package org.example.rest;

import org.example.models.User;
import org.example.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserController extends RestController {

    private final UserService userService = new UserService();

    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public void getUser(@Suspended AsyncResponse asyncResponse, @PathParam("email") String email) {
        asyncResponse.resume(userService.getUser(email).orElseThrow());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getUsers(@Suspended AsyncResponse asyncResponse) {
        asyncResponse.resume(userService.getUsers());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ping(User user) {
        userService.insertUser(user);
        return Response.ok("User created with " + user.getEmail()).build();
    }
}
