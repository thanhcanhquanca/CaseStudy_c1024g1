package exception;

public class ErrorHandler {
    public static void logError(String action, Exception e) {
        System.out.println("Lỗi xảy ra hành động " + action);
        System.out.println("Chi tiết lỗi  " + e.getMessage());

    }

    public static void notifyUsers(String message) {
        System.out.println("Chi tiết lỗi  " + message);

    }

    public static void notifyAdmin(String action, Exception e) {
        System.out.println("Thông báo cho quản cho quản trị viên admin ceo : " +
                "lỗi hàng động gì" + action  + " chi tiết lỗi  " + e.getMessage());

    }
}
