package model;

public class CEO extends Person{
    private String position;

    public CEO(String id, String name, int age, String email, String phoneNumber, String department, String position) {
        super(id, name, age, email, phoneNumber, department);
        this.position = position;

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "CEO{" +
                "position='" + position + '\'' +
                '}';
    }
}
