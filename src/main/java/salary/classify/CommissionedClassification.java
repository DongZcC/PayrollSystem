package salary.classify;

import salary.PayCheck;
import salary.data.SalesReceipt;

import java.util.Date;
import java.util.List;

public class CommissionedClassification implements PaymentClassification {

    private double commissionRate;

    private double salary;

    public CommissionedClassification(double commissionRate, double salary) {
        this.commissionRate = commissionRate;
        this.salary = salary;
    }

    private List<SalesReceipt> salesReceiptList;

    @Override
    public double caculatePay(PayCheck pc) {
        return 0;
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceiptList.add(salesReceipt);
    }
}
