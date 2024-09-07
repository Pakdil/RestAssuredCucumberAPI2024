import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetBookingByIdTests {

    @Test

    public void getBookingById() {

        // Create call
        // Check response
        // https://restful-booker.herokuapp.com/booking/1
given()
        .when()
        .get("https://restful-booker.herokuapp.com/booking/203")
        .then()
        .log().all()
        .statusCode(200);

    }




}
