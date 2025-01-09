package view;

import error.RoomError;
import error.RoomErrorManager;
import notify.INotifier;
import notify.NotifierManager;
import services.*;
import enums.RoomType;
import model.*;

import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {

            System.out.println("_________________ khởi tạo CEO  *_*  ___________________");
            //  CEO sử dụng Singleton khởi tạo  ( Giám đốc )
            CEO ceo = CEO.getInstance("34","NGưu",45,"ngưu@Ggmail.com","897398323","QeZi", "quản lý toàn bộ ");
            System.out.println(ceo);

            System.out.println("____________ Khởi tạo nhân viên  *_*_______________");
            // Thông báo và khởi tạo nhân viên
            INotifier notifier = new NotifierManager();
            IGenericStaffManager staffManager = new StaffManager(notifier);

            Staff staff1 = new Staff("H26", "Quỳnh", 30, "qunhngoc@example.com", "123456789", "IT", "Secretary");
            Staff staff2 = new Staff("H27", "Huyền", 28, "huyendo@example.com", "987654321", "HR", "Manager");

            //  thêm nhân viên
            staffManager.addEmployee(staff1);
            staffManager.addEmployee(staff2);

            // hiển thị ra tất cả nhân viên
            staffManager.displayAllEmployees();

            // xóa nhân viên hay xa thải nhân viên theo id
//            staffManager.removeEmployee("H26");




            System.out.println("______________ khởi tạo khách hàng *_*________________");

            // Khởi tạo khách hàng
            CustomerManager customerManager = new CustomerManager();
            Customer customer1 = new Customer("C0001", " Hà Bá Ao", 30, 982372312, "haBaAo@gmail.com", "Hà Nội");
            Customer customer2 = new Customer("C0002", "Ngưu Văn Bức", 25, 122438795, "nguuBuc@gmail.com", "Hà Nội");

            // thêm khách hàng
            customerManager.add(customer1);
            customerManager.add(customer2);

            // hiển thị khách hàng
            customerManager.displayAll();

            // xóa khách hàng ra khỏi
//            customerManager.delete("C0001");

            // cập nhập lại khách hàng
//          customerManager.update(new Customer("C0001", " HA Ba", 30, 982372312, "haBaAo@gmail.com", "Hà Nội");

            // sắp xếp
//          customerManager.sort();

            // ghi file
//            customerManager.writeToFile();

            // đọc file
//           customerManager.readFromFile();

            System.out.println("______________ khởi tạo phòng *_*__________________");

            // khởi tạo phòng mặc định với giá phòng có sử dụng Factory và Proxy Pattern
            RoomManager roomManager = new RoomManager();
            roomManager.add(new Room("R0001", RoomType.VIP, false));
            roomManager.add(new Room("R0002", RoomType.DELUXE, false));
            roomManager.add(new Room("R0003", RoomType.STANDARD, false));
            roomManager.add(new Room("R0004", RoomType.ECONOMY, false));

            //hiển thị tất cả các phòng
            roomManager.displayAll();

            // xóa phòng
//          roomManager.delete("R0001");



            System.out.println("__________________ khách hàng đặt phòng *_*___________________");

            // Khách hàng đặt phòng .
            BookingManager bookingManager = new BookingManager(customerManager, roomManager);
            Booking booking1 = new Booking("BOO1", "C0001", "R0001", LocalDate.of(2025, 1, 10), LocalDate.of(2025, 1, 15), 0);
            Booking booking2 = new Booking("B002", "C0002", "R0002", LocalDate.of(2025, 1, 12), LocalDate.of(2025, 1, 14), 0);

            bookingManager.addBooking(booking1);
            bookingManager.addBooking(booking2);


            // Hiển thị tất cả đặt phòng
            System.out.println("Danh sách đặt phòng ____:");
            bookingManager.displayBookings();


//          System.out.println("Tìm danh sách theo id khách hàng ____");
//           bookingManager.getBookingsByCustomer("C0001");


           // xóa người dùng đặt phòng
//         bookingManager.cancelBooking("B001s");


            System.out.println("_______________ Tính tiền tất cả người dùng đặt phòng  *_*__________________");

            // tổng tiền tất cả khách hàng đặt phòng .
            InvoiceManager invoiceManager = new InvoiceManager(bookingManager);
            double totalRevenue = invoiceManager.calculateTotalRevenue();
            System.out.println("Tổng doanh thu từ tất cả đặt phòng: " + totalRevenue);


            System.out.println("____________ staff1 thư ký lấy dữ liệu từ hệ thống , thống báo cho CEO  *_*________________");

            // Yêu cầu báo cáo doanh thu từ Staff, sau đó gửi cho CEO
            ManagerReportable managerReportable = new ManagerReportable();
            managerReportable.requestTotalRevenue(staff1,ceo,invoiceManager);


            System.out.println("______________ Khách hàng báo lỗi vấn đề phòng ở  *_*_________________");

            RoomErrorManager roomErrorManager = new RoomErrorManager();
            RoomError roomError = new RoomError("No_1","NoB001","723","BayLy","điều hoa hỏng rồi",LocalDate.of(2025, 1, 15) , false );
            roomErrorManager.addError(roomError);
            roomErrorManager.displayErrors();



        }
}