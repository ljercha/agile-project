package org.kainos.ea.resources;


import io.swagger.annotations.Api;
import org.kainos.ea.api.JobService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Api("Projects API")
@Path("/api")
public class JobController {
    private JobService jobService = new JobService();

    @GET
    @Path("/job-specification")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJob() {

        return Response.ok(jobService.getJobSpecification()).build();

    }
    }

