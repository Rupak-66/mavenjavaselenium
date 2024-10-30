package testngpractice.stepdefinations;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import testngpractice.models.Booking;
import testngpractice.models.BookingResponse;
import testngpractice.models.Bookingdates;

import static io.restassured.RestAssured.given;

public class Apitestsstepdef {
    Booking booking = new Booking();
    Bookingdates bookingdates = new Bookingdates();
    Response rs;
    BookingResponse booking_rs;

    @Given("User made a post request with {string}, {string}, {string}")
    public void user_made_a_post_request_with(String firstname, String lastname, String total_price) {
        booking.setFirstname(firstname);
        booking.setLastname(lastname);
        booking.setTotalprice(Double.parseDouble(total_price));
        booking.setDepositpaid(true);
    }
    @When("User enters {string} & {string} dates and provide any {string}")
    public void user_enters_dates_and_provide_any(String checkin, String checkout, String additonalneeds) {
        booking.setAdditionalneeds(additonalneeds);
        bookingdates.setCheckin(checkin);
        bookingdates.setCheckout(checkout);
    }
    @When("User receives response")
    public void user_receives_response() {
         rs =  given()
                .header("Content-Type","application/json")
                .body(booking)
                .when()
                .post("https://restful-booker.herokuapp.com/booking");
        booking_rs = rs.as(BookingResponse.class);
    }
    @Then("The totalprice should be {string}")
    public void the_totalprice_should_be(String total_price) {

        System.out.println(booking_rs.getBooking().getTotalprice());
    }

}
