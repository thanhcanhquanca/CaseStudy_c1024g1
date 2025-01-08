package services;

import model.Booking;
import model.Customer;
import model.Room;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class BookingManager implements IBookingManager {
   private final List<Booking> bookings = new ArrayList<>();
   private final CustomerManager customerManager;
   private final RoomManager roomManager;

    public BookingManager(CustomerManager customerManager, RoomManager roomManager) {
        this.customerManager = customerManager;
        this.roomManager = roomManager;
    }


    @Override
    public void addBooking(Booking booking) {

        try {
            Customer customer = customerManager.searchById(booking.getCustomerID());
            Room room = roomManager.searchById(booking.getRoomId());

            if (customer == null) {
                System.out.println("Khách hàng không tồn tại");
                return;

            }
            if (room == null) {
                System.out.println("Phòng không tồn tại .");
                return;
            }

            if (room.isStatus()){
                System.out.println("phòng đã được đặt");
                return;
            }

            long daysStayed = ChronoUnit.DAYS.between(booking.getCheckInDate(), booking.getCheckOutDate());
            if (daysStayed <= 0){
                System.out.println("ngày đặt phòng không hợp lệ ");
                return;
            }

            int pricePerDay = room.getType().getPrice();
            booking.setTotalPrice(daysStayed * pricePerDay);

            bookings.add(booking);
            room.setStatus(true);
            System.out.println("đặt phòng thành công ,  Tổng Tiền :" + booking.getTotalPrice());




        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    @Override
    public void cancelBooking(String idBooking) {
        Booking bookingToRemove = null;
        for (Booking booking : bookings) {
            if (booking.getIdBooking().equals(idBooking)) {
                bookingToRemove = booking;
                break;
            }
        }
        if (bookingToRemove != null) {
            Room room = roomManager.searchById(bookingToRemove.getRoomId());
            if (room != null) {
                room.setStatus(false);
            }

            bookings.remove(bookingToRemove);
            System.out.println("Hủy đặt phòng thành công: " + idBooking);
        } else {
            System.out.println("Không tìm thấy mã đặt phòng: " + idBooking);
        }

    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }


    @Override
    public List<Booking> getBookingsByCustomer(String customerId) {
        List<Booking> customerBookings  = new ArrayList<>();
        for (Booking booking : bookings) {
            if (booking.getCustomerID().equals(customerId)) {
                customerBookings.add(booking);
            }
        }
        return customerBookings;
    }

    @Override
    public void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("Chưa có đặt phòng nào!");
        }else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }



}
