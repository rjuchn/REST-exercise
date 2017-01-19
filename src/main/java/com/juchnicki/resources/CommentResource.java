package com.juchnicki.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by Rafal on 2017-01-02.
 */
@Path("/")
public class CommentResource {

    @GET
    public String test(){
        return "subresource";
    }
}
