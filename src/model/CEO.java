package model;

public class CEO extends Person{
    private String position;
    public static CEO instance;


    public CEO(String id, String name, int age, String email, String phoneNumber, String department, String position) {
        super(id, name, age, email, phoneNumber, department);
        this.position = position;
    }

    public static CEO getInstance(String id, String name, int age, String email, String phoneNumber, String department, String position){
         if (instance == null){
             instance = new CEO(id, name, age, email, phoneNumber, department, position);
         }
        return instance;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "CEO{" + "id : " + getId() + " , name : " + getName() + " age : " + getAge() + ", email : "
                + getEmail() + ", phoneNumber : " + getPhoneNumber() + ", department : " + getDepartment() + ", position : " + getPosition() + '}';

    }

    public void receiveRevenue(double totalRevenue) {
        System.out.println("Giám đốc nhận được báo cáo doanh thu: " + totalRevenue);
    }
}
