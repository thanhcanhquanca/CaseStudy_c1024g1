package services;

import model.Staff;

import java.util.List;

public interface IGenericStaffManager {
    void addEmployee(Staff staff);
    void removeEmployee(String employeeId);
    List<Staff> getEmployees();
    void notifyAllEmployees(String message);
    void notifyEmployeeById(String role, String message);
    void displayAllEmployees();
}
