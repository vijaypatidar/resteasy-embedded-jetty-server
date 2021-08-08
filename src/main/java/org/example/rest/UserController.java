package org.example.rest;

import org.example.models.User;
import org.example.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/user")
public class UserController extends RestController {

    private final UserService userService = new UserService();
    private Logger logger = Logger.getLogger(getClass().getCanonicalName());

    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public void getUser(@Suspended AsyncResponse asyncResponse, @PathParam("email") String email) {
        okReply(asyncResponse, userService.getUser(email).orElseThrow());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getUsers(@Suspended AsyncResponse asyncResponse) {
        okReply(asyncResponse, userService.getUsers());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response ping(User user) {
        userService.insertUser(user);
        logger.info("USER CREATED " + user.getEmail());
        return okReply("User created with " + user.getEmail());
    }
}
