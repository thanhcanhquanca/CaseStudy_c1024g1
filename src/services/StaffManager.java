package services;

import model.Staff;
import notify.INotifier;

import java.util.ArrayList;
import java.util.List;

public class StaffManager implements IGenericStaffManager {
    private final List<Staff> staff = new ArrayList<>();
    private final INotifier notifier;

    public StaffManager(INotifier notifier) {
        this.notifier = notifier;
    }


    @Override
    public void addEmployee(Staff staff) {
        this.staff.add(staff);
    }

    @Override
    public void removeEmployee(String employeeId) {
        for (int i = 0; i < staff.size(); i++) {
            if (staff.get(i).getId().equals(employeeId)) {
                staff.remove(i);
                break;
            }
        }

    }

    @Override
    public List<Staff> getEmployees() {
        return staff;
    }

    @Override
    public void notifyAllEmployees(String message) {
        for (Staff staff : this.staff) {
            notifier.notifyCustomer(message);
        }
    }

    @Override
    public void notifyEmployeeById(String role, String message) {
        for (Staff staff : this.staff) {
            if (staff.getId().equals(role)) {
                notifier.notifyCustomer(message);
            }
        }
    }

    @Override
    public void displayAllEmployees() {
        for (Staff staff : this.staff) {
            System.out.println(staff);
        }
    }
}
