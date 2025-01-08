package services;

import model.CEO;
import model.Employee;

public class ManagerReportable implements IGenericReportable{

    @Override
    public void requestTotalRevenue(Employee employee, CEO ceo, InvoiceManager invoiceManager) {
        double totalRevenue  = invoiceManager.calculateTotalRevenue();
        sendRevenueReport(ceo, totalRevenue );
    }

    private void sendRevenueReport(CEO ceo, double totalRevenue ) {
        ceo.receiveRevenue(totalRevenue);
    }


}
