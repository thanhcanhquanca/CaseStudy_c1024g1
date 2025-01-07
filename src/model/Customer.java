package model;

import java.io.Serializable;

public class Customer implements Serializable {
    private String idCustomer;
    private String nameCustomer;
    private int ageCustomer;
    private int phoneNumberCustomer;
    private String emailCustomer;
    private String addressCustomer;

    public Customer(String idCustomer, String nameCustomer, int ageCustomer, int phoneNumberCustomer, String emailCustomer, String addressCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.ageCustomer = ageCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public int getAgeCustomer() {
        return ageCustomer;
    }

    public void setAgeCustomer(int ageCustomer) {
        this.ageCustomer = ageCustomer;
    }

    public int getPhoneNumberCustomer() {
        return phoneNumberCustomer;
    }

    public void setPhoneNumberCustomer(int phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }
}
