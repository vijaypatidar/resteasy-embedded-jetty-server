package org.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/user")
public class UserController {

    @GET
    public String getUser(){
        return "Vijay";
    }
}
