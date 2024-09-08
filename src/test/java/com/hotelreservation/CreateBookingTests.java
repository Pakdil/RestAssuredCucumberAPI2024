package com.hotelreservation;

import com.hotelreservation.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingTests extends BaseTest {

    @Test
    public  void createBookingTest() {

        // Create body
/*
        curl -X POST \
        https://restful-booker.herokuapp.com/booking \
        -H 'Content-Type: application/json' \
        -d '{
        "firstname" : "Jim",
                "lastname" : "Brown",
                "totalprice" : 111,
                "depositpaid" : true,
                "bookingdates" : {
            "checkin" : "2018-01-01",
                    "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Breakfast"
    }'

 */

        /*
//        JSONObject body = new JSONObject();
//        body.put("firstname", "Ahmet");
//        body.put("lastname", "Pakdil");
//        body.put("totalprice", 2500);
//        body.put("depositpaid", true);
//
//        JSONObject bookingdates = new JSONObject();
//        bookingdates.put("checkin", "2024-01-05");
//        bookingdates.put("checkout", "2024-01-15");
//
//        body.put("bookingdates", bookingdates);
//        body.put("additonalneeds", "Breakfast");

         */


// Create call

        /*
//       Response response = given()
//                .when()
//                .contentType(ContentType.JSON)
//                .body(bookingObject())
//                .post("https://restful-booker.herokuapp.com/booking");
//
//       response.prettyPrint();
//
//       response
//               .then()
//               .statusCode(200);

         */

        Response response = createBooking();

        Assertions.assertEquals("Ahmet", response.jsonPath().getJsonObject("booking.firstname"));
        Assertions.assertEquals("Pakdil", response.jsonPath().getJsonObject("booking.lastname"));
        Assertions.assertEquals(2500, (Integer) response.jsonPath().getJsonObject("booking.totalprice"));
        Assertions.assertEquals(true, response.jsonPath().getJsonObject("booking.depositpaid"));

    }


}
