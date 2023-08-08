package integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.kainos.ea.cli.Admin;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminIT {
    @Test
    public void postBand_shouldReturn201() {
        Admin admin = new Admin(
                "kamil",
                1,
                "Test"
        );

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(admin)
                .post("http://localhost:8080/api/admin/band");

        assertEquals(201, response.getStatusCode());
    }
    @Test
    public void postBand_shouldReturn500() {
        Admin admin = new Admin(
                "kamil",
                1,
                "Test"
        );

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(admin)
                .post("http://localhost:8080/api/admin/band");

        assertEquals(500, response.getStatusCode());
    }
}
