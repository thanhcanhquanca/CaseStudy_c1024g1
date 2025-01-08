package notify;

public class NotifierManager implements INotifier {
    @Override
    public void notifyEmployee(String message) {
        System.out.println("Thông báo cho nhân viên : " + message);
    }

    @Override
    public void notifyCustomer(String message) {
        System.out.println("Thông báo cho khách hàng : "+ message);
    }
}
