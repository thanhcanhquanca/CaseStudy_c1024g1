package controller;

import model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerManager implements GenericManager<Customer>, IGenericFile {
  private final List<Customer> customers = new ArrayList<>();

    private static final String ID_REGEX = "^[A-Za-z0-9]{5,10}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private boolean validateId(String id){

        return Pattern.matches(ID_REGEX, id);
    }

    public boolean validateEmail(String email){

        return Pattern.matches(EMAIL_REGEX, email);
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }

    @Override
    public void add(Customer item) {
        try {
            if (!validateId(item.getIdCustomer())){
                System.out.println("ID không hợp lệ , ID phải từ 5 - 10 ký tự chỉ chứa chữ và số");
                return;
            }

            if (!validateEmail(item.getEmailCustomer())){
                System.out.println("email không hợp lệ , vui lòng nhập email đúng định dạng");
                return;
            }

            for (Customer customer : customers) {
                if (customer.getIdCustomer().equals(item.getIdCustomer())) {
                    System.out.println(" khách hàng đã tồn tại " + item.getIdCustomer() + "đã tồn tại") ;
                    return;
                }
            }

            customers.add(item);
            System.out.println("thêm khách hàng thành công" + item.getIdCustomer());

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
            try {
                boolean found = false;
                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).getIdCustomer().equals(id)) {
                        customers.remove(i);
                        found = true;
                        break;
                    }

                }
                if(found){
                    System.out.println("xóa thành công " + id);
                }else {
                    System.out.println(" không thể tìm thấy người dùng " + id);
                }
            }catch (Exception e) {
                System.out.println("Đã xảy ra lỗi trong quá trình xóa: " + e.getMessage());
            }

         }

    @Override
    public void update(Customer item) {
            try {
                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).getIdCustomer().equals(item.getIdCustomer())) {
                        customers.set(i,item);
                        return;
                    }
                }
                System.out.println("Không tìm thấy khách hàng với ID: " + item.getIdCustomer());
            }catch (Exception e){
                System.out.println("Lỗi " + e.getMessage());
            }
    }

    @Override
    public void sort() {
        customers.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {

                return o1.getIdCustomer().compareTo(o2.getIdCustomer());
            }
        });

    }

    @Override
    public Customer searchById(String id) {
        for (Customer customer : customers) {
            if (customer.getIdCustomer().equals(id)) {
                return customer;
            }
        }
        System.out.println(" không tìm thaay" + id);
        return null;
    }

    @Override
    public void displayAll(Customer item) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Override
    public void writeToFile() throws IOException {
        File file = new File("customers.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(customers);
            System.out.println("Dữ liệu đã được ghi vào tệ txt");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi tệp : " + e.getMessage());
        }
    }

    @Override
    public void readFromFile() {
        File file = new File("customers.txt");
        if (!file.exists()) {
            System.out.println("Tệp không tồn tại ");
            return;
        }

        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            List<Customer> loadedCustomers = (List<Customer>) objectInputStream.readObject();
            customers.clear();
            customers.addAll(loadedCustomers);
            System.out.println("đã đọc file vào tệp  ");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi khi đọc tệp : " + e.getMessage());
        }
    }



}
