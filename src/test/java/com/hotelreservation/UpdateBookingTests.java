package com.hotelreservation;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdateBookingTests extends BaseTest {

@Test
    public void updateBooking () {

//    curl -X PUT \
//    https://restful-booker.herokuapp.com/booking/1 \
//    -H 'Content-Type: application/json' \
//    -H 'Accept: application/json' \
//    -H 'Cookie: token=abc123' \
//    -d '{
//    "firstname" : "James",
//            "lastname" : "Brown",
//            "totalprice" : 111,
//            "depositpaid" : true,
//            "bookingdates" : {
//        "checkin" : "2018-01-01",
//                "checkout" : "2019-01-01"
//    },
//    "additionalneeds" : "Breakfast"
//}'

          // Create Token

//    curl -X POST \
//    https://restful-booker.herokuapp.com/auth \
//    -H 'Content-Type: application/json' \
//    -d '{
//    "username" : "admin",
//            "password" : "password123"
//}'

    String token = createToken();

    // Create reservation

    Response createBookingObject = createBooking();
   int bookingId = createBookingObject.jsonPath().getJsonObject("bookingid");

   // Request

    Response response = given()
            .contentType(ContentType.JSON)
            .header("Cookie", "token=" +token)
            .body(bookingObject("Aysenur", "Pakdil", 3500, false))
            .put("https://restful-booker.herokuapp.com/booking/" +bookingId);

    response.prettyPrint();

    // Assertion/Test

    String firstName = response.jsonPath().getJsonObject("firstname");
    String lastName = response.jsonPath().getJsonObject("lastname");
    int totalPrice = response.jsonPath().getJsonObject("totalprice");
    Boolean depositPaid = response.jsonPath().getJsonObject("depositpaid");

    Assertions.assertEquals("Aysenur", firstName);
    Assertions.assertEquals("Pakdil", lastName);
    Assertions.assertEquals(3500, totalPrice);
    Assertions.assertEquals(false, depositPaid);



}




}
