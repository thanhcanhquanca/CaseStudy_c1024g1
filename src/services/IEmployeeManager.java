package services;

import model.Employee;
import notify.INotifier;

import java.util.ArrayList;
import java.util.List;

public class IEmployeeManager {
    private final List<Employee> employees = new ArrayList<>();
    private final INotifier notifier;


    public IEmployeeManager(INotifier notifier) {
        this.notifier = notifier;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {

    }
}
