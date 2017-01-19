package com.juchnicki.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created by Rafal on 2017-01-02.
 */
@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(@MatrixParam("param") String param,
                                            @HeaderParam("headerParam") String headerParam,
                                            @CookieParam("JSESSIONID") String cookie) {
        return param + " | " + headerParam + " | " + cookie;
    }

    @GET
    @Path("context")
    public String getParamUsingContext(@Context UriInfo uriInfo,
                                       @Context HttpHeaders headers){
        String path = uriInfo.getAbsolutePath().toString();
        String cookies = headers.getCookies().toString();

        return path + "   " + cookies;
    }



}
