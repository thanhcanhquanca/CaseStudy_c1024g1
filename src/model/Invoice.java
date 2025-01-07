package model;

import java.time.LocalDate;
public class Invoice {
    private String invoiceID;
    private int bookingID;
    private LocalDate issueDate;
    private double totalAmount;

    public Invoice(String invoiceID, int bookingID, LocalDate issueDate, double totalAmount) {
        this.invoiceID = invoiceID;
        this.bookingID = bookingID;
        this.issueDate = issueDate;
        this.totalAmount = totalAmount;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceID='" + invoiceID + '\'' +
                ", bookingID=" + bookingID +
                ", issueDate=" + issueDate +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
