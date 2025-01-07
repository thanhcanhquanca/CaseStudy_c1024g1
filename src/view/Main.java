package view;

import controller.CustomerManager;
import model.Customer;

public class Main {
        public static void main(String[] args) {
            CustomerManager customerManager = new CustomerManager();
            Customer customer1 = new Customer("C00001", "Nguyễn Văn A", 30, 982372312, "a@gmail.com", "Hà Nội");
            Customer customer2 = new Customer("C00002", "Trần Thị B", 25, 122438795, "b@gmail.com", "Hà Nội");

            customerManager.add(customer1);
            customerManager.add(customer2);

            customerManager.displayAll(customer1);
        }
}