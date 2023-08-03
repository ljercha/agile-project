package org.kainos.ea.resources;
import org.eclipse.jetty.http.HttpStatus;
import org.kainos.ea.api.JobSpecificationService;


import org.kainos.ea.exception.DatabaseConnectionException;

import io.swagger.annotations.*;
import org.eclipse.jetty.http.HttpStatus;
import org.kainos.ea.exception.RoleNotExistException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;
@Path("/api")
public class JobSpecificationController {
    private JobSpecificationService jobSpecificationService = new JobSpecificationService();

    @GET
    @Path("/job-specification/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobSpecification(@PathParam("id") int role_id) {
        try {
            return Response.status(HttpStatus.OK_200).entity(jobSpecificationService.getJobSpecification(role_id)).build();
        } catch (DatabaseConnectionException | Exception | RoleNotExistException e) {
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500, e.getMessage()).build();
        }
    }
}

