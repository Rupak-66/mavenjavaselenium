package testngpractice;

import groovy.json.JsonBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testngpractice.models.Booking;
import testngpractice.models.BookingResponse;
import testngpractice.models.Bookingdates;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Apitests {
    @Test
    public void validate_get_request(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=1");
        System.out.println(response.statusCode());
        System.out.println(response.asString());

        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode, 200);
    }

    @Test
    public void bdd_validate_api(){
        given().get("https://reqres.in/api/users?page=1").then()
                .statusCode(200).body("data[0].id", equalTo(1));
    }

    @Test
    public void post_create_users(){
        JSONObject request = new JSONObject();
        request.put("name","Rupak");
        request.put("job","QA");

        System.out.println(request);

        given().header("Content-Type","application/json")
                .body(request)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("job", equalTo("QA"));
    }

    @Test
    public void movie_booking(){
        Booking booking = new Booking();
        booking.setFirstname("Test");
        booking.setLastname("Test");
        booking.setTotalprice(253.45);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");

        booking.setBookingdates(bookingdates);



//        System.out.println(booking);
//
//        given().header("Content-Type","application/json")
//                .body(booking)
//                .when()
//                .post("https://restful-booker.herokuapp.com/booking")
//                .then()
//                .statusCode(200)
//                .body("booking.firstname", equalTo("Test"));

       Response rs =  given()
               .header("Content-Type","application/json")
                .body(booking)
                .when()
                .post("https://restful-booker.herokuapp.com/booking");

       BookingResponse booking1 = rs.as(BookingResponse.class);
        System.out.println(booking1.getBooking().getFirstname());
        System.out.println(booking1.getBooking().getBookingdates().getCheckin());

        System.out.println(booking1.toString());

    }


}
