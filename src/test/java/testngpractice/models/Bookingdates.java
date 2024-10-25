package testngpractice.models;

public class Bookingdates {
    private String checkin;
    private String checkout;


    // Getter Methods

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    // Setter Methods

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Bookingdates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
