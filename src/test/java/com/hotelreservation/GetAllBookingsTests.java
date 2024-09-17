package com.hotelreservation;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetAllBookingsTests extends BaseTest {
    // Create calls
    // Check responses

    @Test
    public void getAllBookingTest () {

        given(spec)
                .when()
                .get("/booking")
                .then()
                .statusCode(200);

    }

}
