package services;

import model.Booking;

import java.util.List;

public interface IBookingManager{
    void addBooking(Booking booking);
    List<Booking> getBookingsByCustomer(String customerId);
    void displayBookings();
    void cancelBooking(String idBooking);

}
