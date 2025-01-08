package controller;

import model.CEO;
import model.Employee;

public interface IGenericReportable {
    void requestTotalRevenue(Employee employee , CEO ceo , InvoiceManager invoiceManager);

}
