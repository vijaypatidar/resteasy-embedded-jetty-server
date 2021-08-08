package org.example.rest;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.Response;

public interface ResponseHelper {
    default void okReply(AsyncResponse asyncResponse, Object data) {
        asyncResponse.resume(Response.ok(data).build());
    }

    default Response okReply(Object data) {
        return Response.ok(data).build();
    }
}
