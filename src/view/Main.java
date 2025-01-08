package view;

import controller.BookingManager;
import controller.CustomerManager;
import controller.InvoiceManager;
import controller.RoomManager;
import model.*;

import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {

            //  CEO sử dụng Singleton
            CEO ceo = CEO.getInstance("34","Huyển",45,"email@Ggmail.com","897398323","Giám đốc", "quản lý toàn bộ ");
            CEO ceo1 = CEO.getInstance("34","Trang",45,"email@Ggmail.com","897398323","Giám đốc", "quản lý toàn bộ ");
            System.out.println(ceo);
            System.out.println(ceo1);

            // khách hàng  có regex
            CustomerManager customerManager = new CustomerManager();
            Customer customer1 = new Customer("C00001", "Nguyễn Văn A", 30, 982372312, "a@gmail.com", "Hà Nội");
            Customer customer2 = new Customer("C00002", "Trần Thị B", 25, 122438795, "b@gmail.com", "Hà Nội");
            customerManager.add(customer1);
            customerManager.add(customer2);

            // khởi tạo phòng mặc định với giá phòng có sử dụng Factory và
            RoomManager roomManager = new RoomManager();
            roomManager.add(new Room("R001", RoomType.VIP, false));
            roomManager.add(new Room("R002", RoomType.DELUXE, false));
            roomManager.add(new Room("R003", RoomType.STANDARD, false));
            roomManager.add(new Room("R004", RoomType.ECONOMY, false));



            // Khách hàng đặt phòng nào sử lý tính tiền phòng đó
            BookingManager bookingManager = new BookingManager(customerManager, roomManager);
            Booking booking1 = new Booking("BOO1", "C00001", "R001", LocalDate.of(2025, 1, 10), LocalDate.of(2025, 1, 15), 0);
            Booking booking2 = new Booking("B002", "C00002", "R002", LocalDate.of(2025, 1, 12), LocalDate.of(2025, 1, 14), 0);

            bookingManager.addBooking(booking1);
            bookingManager.addBooking(booking2);

            // Hiển thị tất cả đặt phòng
            System.out.println("Danh sách đặt phòng:");
            bookingManager.displayBookings();


            // Hiển thị các phòng mà khách hàng đã đặt
            System.out.println("Danh sách phòng của khách hàng B001:");
            for (Booking booking : bookingManager.getBookingsByCustomer("C00001")) {
                System.out.println(booking);
            }

            // phòng bị sao đó cần sửa lại ....
            bookingManager.cancelBooking("B001s");




            // tổng tiền tất cả khách hàng đặt phòng .
            InvoiceManager invoiceManager = new InvoiceManager(bookingManager);
            double totalRevenue = invoiceManager.calculateTotalRevenue();
            System.out.println("Tổng doanh thu từ tất cả đặt phòng: " + totalRevenue);

        }
}