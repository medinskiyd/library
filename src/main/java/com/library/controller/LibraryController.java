package com.library.controller;

import com.library.model.Book;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Library Controller with path "/changeBook".
 * <p>
 * Created by dmitry on 16.09.16.
 */
@Component
@Path("/changeBook")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @POST
    public Response saveOrUpdateOrGetAll(Book book, @Context UriInfo uriInfo) {

        if (book == null) {
            return Response.ok(libraryService.getAll()).build();
        }

        int is = 0;

        if (libraryService.getById(book.getId()) != null) {
            is++;
        }

        if (is > 0) {
            libraryService.update(book);
            return Response.ok().build();
        } else if (is == 0) {
            libraryService.save(book);
            return Response.created(uriInfo.getAbsolutePath()).build();
        }

        return Response.status(500).build();
    }

}
