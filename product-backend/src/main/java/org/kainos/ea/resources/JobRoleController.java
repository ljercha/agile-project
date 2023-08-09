package org.kainos.ea.resources;
import io.swagger.annotations.Api;
import org.kainos.ea.api.JobRoleService;
import org.kainos.ea.client.FailedToGetJobRolesException;
import org.kainos.ea.db.JobRoleDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Job Roles API")
@Path("/api")
public class JobRoleController {
    private JobRoleService jobRoleService = new JobRoleService(new JobRoleDao());

    @GET
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllJobRoles() {
        try {
            return Response.ok(jobRoleService.getAllJobRoles()).build();
        } catch (FailedToGetJobRolesException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }
}
