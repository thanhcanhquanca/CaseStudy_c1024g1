package view;

import controller.BookingManager;
import controller.CustomerManager;
import controller.InvoiceManager;
import controller.RoomManager;
import model.Booking;
import model.CEO;
import model.Customer;
import model.Room;

import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {
            
            CEO ceo = CEO.getInstance("34","Huyển",45,"email@Ggmail.com","897398323","Giám đốc", "quản lý toàn bộ ");
            CEO ceo1 = CEO.getInstance("34","Trang",45,"email@Ggmail.com","897398323","Giám đốc", "quản lý toàn bộ ");
            System.out.println(ceo);
            System.out.println(ceo1);


            CustomerManager customerManager = new CustomerManager();
            Customer customer1 = new Customer("C00001", "Nguyễn Văn A", 30, 982372312, "a@gmail.com", "Hà Nội");
            Customer customer2 = new Customer("C00002", "Trần Thị B", 25, 122438795, "b@gmail.com", "Hà Nội");
            customerManager.add(customer1);
            customerManager.add(customer2);

            // thêm phòng
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
            System.out.println("Danh sách phòng của khách hàng B001:");
            for (Booking booking : bookingManager.getBookingsByCustomer("B001")) {
                System.out.println(booking);
            }

            bookingManager.cancelBooking("B001s");

            InvoiceManager invoiceManager = new InvoiceManager(bookingManager);
            double totalRevenue = invoiceManager.calculateTotalRevenue();
            System.out.println("Tổng doanh thu từ tất cả đặt phòng: " + totalRevenue);

        }
}