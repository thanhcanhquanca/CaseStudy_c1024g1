package model;

public class Employee extends Person{
    private String role;

    public Employee(String id, String name, int age, String email, String phoneNumber, String department, String role) {
        super(id, name, age, email, phoneNumber, department);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "role='" + role + '\'' +
                '}';
    }
}
