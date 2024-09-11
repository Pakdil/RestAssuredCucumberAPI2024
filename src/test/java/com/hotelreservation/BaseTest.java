package com.hotelreservation;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class BaseTest {

protected String bookingObject( String firstName, String lastName, int totalPrice, boolean depositPaid) {

    JSONObject body = new JSONObject();
    body.put("firstname", firstName);
    body.put("lastname", lastName);
    body.put("totalprice", totalPrice);
    body.put("depositpaid", depositPaid);

    JSONObject bookingdates = new JSONObject();
    bookingdates.put("checkin", "2024-01-05");
    bookingdates.put("checkout", "2024-01-15");

    body.put("bookingdates", bookingdates);
    body.put("additonalneeds", "Breakfast");

    return body.toString();
}

protected int createBookingId() {
    Response response = createBooking();
    return response.jsonPath().getJsonObject("bookingid");
}

protected Response createBooking () {

    Response response = given()
            .when()
            .contentType(ContentType.JSON)
            .body(bookingObject("Ahmet", "Pakdil", 2500, true))
            .post("https://restful-booker.herokuapp.com/booking");

    response.prettyPrint();

    response
            .then()
            .statusCode(200);
    return response;
}

    protected String createToken () {

        JSONObject body = new JSONObject();
        body.put("username", "admin");
        body.put("password", "password123");

        Response response = given().contentType(ContentType.JSON)
                .when()
                .body(body.toString())
                .log().all()
                .post("https://restful-booker.herokuapp.com/auth");

        response.prettyPrint();
        return response.jsonPath().getJsonObject("token");

    }

}
