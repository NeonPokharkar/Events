package model;

public class Booking {
    int id;
    String user;
    String event;
    String venue;
    String paymentmode;
    String date;

    public int getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public String getPaymentmode() {
        return paymentmode;
    }

    public String getUser() {
        return user;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
