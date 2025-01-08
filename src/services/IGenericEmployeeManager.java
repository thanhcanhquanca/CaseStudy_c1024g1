package services;

import model.Employee;

import java.util.List;

public interface IGenericEmployeeManager {
    void addEmployee(Employee employee);
    void removeEmployee(String employeeId);
    List<Employee> getEmployees();
    void notifyAllEmployees(String message);
    void notifyEmployeeById(String role, String message);
}
