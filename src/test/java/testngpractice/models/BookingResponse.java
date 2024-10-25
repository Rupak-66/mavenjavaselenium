package testngpractice.models;

public class BookingResponse {
    private int bookingid;
    Booking BookingObject;


    // Getter Methods

    public int getBookingid() {
        return bookingid;
    }

    public Booking getBooking() {
        return BookingObject;
    }

    // Setter Methods

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public void setBooking(Booking bookingObject) {
        this.BookingObject = bookingObject;
    }

    @Override
    public String toString() {
        return "BookingResponse{" +
                "bookingid=" + bookingid +
                ", BookingObject=" + BookingObject +
                '}';
    }
}
