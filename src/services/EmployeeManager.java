package services;

import model.Employee;
import notify.INotifier;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager implements IGenericEmployeeManager {
    private final List<Employee> employees = new ArrayList<>();
    private final INotifier notifier;

    public EmployeeManager(INotifier notifier) {
        this.notifier = notifier;
    }


    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void removeEmployee(String employeeId) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(employeeId)) {
                employees.remove(i);
                break;
            }
        }

    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void notifyAllEmployees(String message) {
        for (Employee employee : employees) {
            notifier.notifyCustomer(message);
        }
    }

    @Override
    public void notifyEmployeeById(String role, String message) {
        for (Employee employee : employees) {
            if (employee.getId().equals(role)) {
                notifier.notifyCustomer(message);
            }
        }
    }
}
