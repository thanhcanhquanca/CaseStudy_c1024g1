package controller;

import model.Booking;

import java.util.List;

public class InvoiceManager implements IInvoiceManager {
    private final BookingManager bookingManager;

    public InvoiceManager(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    @Override
    public double calculateTotalRevenue() {
        List< Booking> bookings = bookingManager.getAllBookings();
        double totalRevenue = 0;
        for (Booking booking : bookings) {
            totalRevenue += booking.getTotalPrice();

        }
        return totalRevenue;
    }
}
