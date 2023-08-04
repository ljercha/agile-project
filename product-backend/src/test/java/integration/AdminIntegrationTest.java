package integration;

import org.kainos.ea.DropwizardWebServiceApplication;
import org.kainos.ea.DropwizardWebServiceConfiguration;
import org.kainos.ea.cli.Admin;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import org.kainos.ea.validator.AdminValidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ExtendWith(DropwizardExtensionsSupport.class)
public class AdminIntegrationTest {
    static final DropwizardAppExtension<DropwizardWebServiceConfiguration> APP = new DropwizardAppExtension<>(
            DropwizardWebServiceApplication.class, null,
            new ResourceConfigurationSourceProvider()
    );

    @Test
    public void postBand_shouldReturn200() {
        Admin admin = new Admin(
                "tomek",
                "Integration",
                "Test"
        );

        Response response = APP.client().target("http://localhost:8080/api/admin/band")
                .request()
                .post(Entity.entity(admin, MediaType.APPLICATION_JSON_TYPE));

        Assertions.assertEquals(response.getStatus(), 200);
    }
}
