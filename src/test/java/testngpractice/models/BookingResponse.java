package testngpractice.models;

public class BookingResponse {
    private double bookingid;
    Booking BookingObject;


    // Getter Methods

    public double getBookingid() {
        return bookingid;
    }

    public Booking getBooking() {
        return BookingObject;
    }

    // Setter Methods

    public void setBookingid(double bookingid) {
        this.bookingid = bookingid;
    }

    public void setBooking(Booking bookingObject) {
        this.BookingObject = bookingObject;
    }
}
