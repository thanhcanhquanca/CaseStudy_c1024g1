package model;


public class Staff extends Person{
    private String role;

    public Staff(String id, String name, int age, String email, String phoneNumber, String department, String role) {
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
        return "Staff{" + "id : " + getId() + " , name : " + getName() + " age : " + getAge() + ", email : "
                + getEmail() + ", phoneNumber : " + getPhoneNumber() + ", department : " + getDepartment() + ", role : " + role + '}';
    }
}
