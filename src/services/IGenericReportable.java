package services;

import model.CEO;
import model.Staff;

public interface IGenericReportable {
    void requestTotalRevenue(Staff staff, CEO ceo , InvoiceManager invoiceManager);

}
