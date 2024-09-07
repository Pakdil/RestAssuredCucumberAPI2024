import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingByIdTests {

    @Test

    public void getBookingById() {

        // Create call
        // Check response
        // https://restful-booker.herokuapp.com/booking/1
Response response = given()
        .when()
        .get("https://restful-booker.herokuapp.com/booking/633");

//        .log().all()
//        .statusCode(200);

        response
                .then()
                .statusCode(200);

       response.prettyPrint();

        String firstname = response.jsonPath().getJsonObject("firstname");
        String lastname = response.jsonPath().getJsonObject("lastname");
        int totalprice = response.jsonPath().getJsonObject("totalprice");

        Assertions.assertEquals("Josh", firstname);
        Assertions.assertEquals("Allen", lastname);
        Assertions.assertEquals(111, totalprice);

    }
}
