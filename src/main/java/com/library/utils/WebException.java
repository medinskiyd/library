package com.library.utils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by dmitry on 16.09.16.
 */
public class WebException extends WebApplicationException {

    private final int status;
    private final String errorMessage;

    public WebException(int httpStatus, String errorMessage) {
        this.status = httpStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public Response getResponse() {
        return Response.status(status).type(MediaType.APPLICATION_ATOM_XML_TYPE).entity(getErrorResponse()).build();
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }

    public MessageResponse getErrorResponse() {
        MessageResponse response = new MessageResponse();
        response.setCode(String.valueOf(status));
        response.setMessage(errorMessage);
        return response;
    }

}
