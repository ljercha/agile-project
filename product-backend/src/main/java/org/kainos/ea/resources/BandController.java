package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.checkerframework.checker.units.qual.A;
import org.kainos.ea.api.AdminService;
import org.kainos.ea.cli.Admin;
import org.kainos.ea.client.FailedToCreateBandException;
import org.kainos.ea.db.AdminDao;
import org.kainos.ea.exception.NameTooShortException;
import org.kainos.ea.validator.AdminValidator;
import org.kainos.ea.db.DatabaseConnector;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Admin API")
@Path("/api")
public class AdminController {
    DatabaseConnector databaseConnector = new DatabaseConnector();

    private AdminService adminService = new AdminService(new AdminDao(), databaseConnector);



    @POST
    @Path("/admin/band")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBand(Admin admin) throws NameTooShortException, SQLException {

        try {
            return Response.ok(adminService.createBand(admin)).build();
        } catch (FailedToCreateBandException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
