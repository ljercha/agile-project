package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.checkerframework.checker.units.qual.A;
import org.kainos.ea.api.AdminService;
import org.kainos.ea.cli.Admin;
import org.kainos.ea.client.FailedToCreateBandException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Admin API")
@Path("/api")
public class AdminController {
    private AdminService adminService = new AdminService();


    @POST
    @Path("/admin/band")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBand(Admin admin) {

        try {
            return Response.ok(adminService.createBand(admin)).build();
        } catch (FailedToCreateBandException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
