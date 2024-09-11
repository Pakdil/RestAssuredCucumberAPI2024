package com.hotelreservation;

import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PartiallyUpdateBookingTests extends BaseTest{

    @Test

    public void partiallyUpdateBookingTest () {

        // Create token

        // String token = createToken(); use createToken directly

        // Make reservation
        //Response newBooking = createBooking();
    // int bookingId = createBookingId();

        // Make call

        /*
//        curl -X PATCH \
//        https://restful-booker.herokuapp.com/booking/1 \
//        -H 'Content-Type: application/json' \
//        -H 'Accept: application/json' \
//        -H 'Cookie: token=abc123' \
//        -d '{
//        "firstname" : "James",
//                "lastname" : "Brown"
//    }'

         */

        JSONObject body = new JSONObject();
        body.put("firstname", "Ali");

Response response = given()
        .contentType((ContentType.JSON))
        .header("Cookie", "token=" + createToken())
        .body(body.toString())
        .when()
        .patch("https://restful-booker.herokuapp.com/booking/" +createBookingId());

response.prettyPrint();

// Assertions

        Assertions.assertEquals("Ali", response.jsonPath().getJsonObject("firstname"));


    }


}
