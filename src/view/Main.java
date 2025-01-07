package view;

import controller.BookingManager;
import controller.CustomerManager;
import controller.RoomManager;
import model.Booking;
import model.Customer;
import model.Room;

import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {
            CustomerManager customerManager = new CustomerManager();
            Customer customer1 = new Customer("C00001", "Nguyễn Văn A", 30, 982372312, "a@gmail.com", "Hà Nội");
            Customer customer2 = new Customer("C00002", "Trần Thị B", 25, 122438795, "b@gmail.com", "Hà Nội");
            customerManager.add(customer1);
            customerManager.add(customer2);

            RoomManager roomManager = new RoomManager();
            Room room1 = new Room("R1001", "VIP", 500000, false);
            Room room2 = new Room("R1002", "Standard", 300000, false);
            roomManager.add(room1);
            roomManager.add(room2);

            BookingManager bookingManager = new BookingManager(customerManager, roomManager);

            // Khách hàng đặt phòng
            Booking booking1 = new Booking("B001", "C00001", "R1001", LocalDate.of(2025, 1, 10), LocalDate.of(2025, 1, 15), 0);
            Booking booking2 = new Booking("B002", "C00002", "R1002", LocalDate.of(2025, 1, 12), LocalDate.of(2025, 1, 14), 0);

            bookingManager.addBooking(booking1);
            bookingManager.addBooking(booking2);

            // Hiển thị tất cả đặt phòng
            System.out.println("Danh sách đặt phòng:");
            bookingManager.displayBookings();

            // Hiển thị các phòng mà khách hàng đã đặt
            System.out.println("Danh sách phòng của khách hàng C00001:");
            for (Booking booking : bookingManager.getBookingsByCustomer("C00001")) {
                System.out.println(booking);
            }

        }
}