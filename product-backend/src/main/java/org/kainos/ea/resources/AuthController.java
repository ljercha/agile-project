package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kainos.ea.api.AuthService;
import org.kainos.ea.cli.RequestEmployee;
import org.kainos.ea.client.FailedToCreateNewEmployeeException;
import org.kainos.ea.client.FaliedToCreateEmployeeWrongInputException;
import org.kainos.ea.db.AuthDao;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Engineering Academy Dropwizard Product API")
@Path("/api")
public class AuthController {

    private static final String CREATE = "/auth/register";

    private final AuthService authService = new AuthService(new AuthDao());


    @POST
    @Path(CREATE)
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Creates new employee/admin")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added new employee/admin to the " +
                    "database"),
            @ApiResponse(code = 400, message = "Failed to add new employee/admin to the database"),
            @ApiResponse(code = 500, message = "Failed to connect with the database")
    })
    public Response createNewEmployee(RequestEmployee employee) {
        try {
            return Response.ok(authService.createNewEmployee(employee)).build();
        } catch (FaliedToCreateEmployeeWrongInputException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        catch (FailedToCreateNewEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }


}
