import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kainos.ea.cli.ProductRequest;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class
ProductIntegrationIT {

    @Mock
    private ProductRequest product;

    private Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    @Test
    void When_ProductPriceLessThan10_Expect_MessageReturned() {
        String apiUrl = dotenv.get("API_URL", "http://localhost:8080");
        given()
                .contentType("application/json")
                .get(apiUrl + "api/products/1")
                .then()
                .statusCode(200)
                .assertThat()
                .body("description", equalTo("One Description"));
    }
}
