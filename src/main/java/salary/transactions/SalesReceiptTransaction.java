package salary.transactions;

import lombok.AllArgsConstructor;
import salary.payrolldatabase.Employee;
import salary.payrolldatabase.PayrollDatabase;
import salary.classifications.CommissionedClassification;
import salary.classifications.PaymentClassification;
import salary.data.SalesReceipt;

import java.util.Date;

@AllArgsConstructor
public class SalesReceiptTransaction implements Transaction {

    private Date date;

    private double amount;

    private int empId;


    @Override
    public void execute() {
        Employee e = PayrollDatabase.getEmployee(empId);
        if (e == null)
            throw new RuntimeException("no such employee");

        PaymentClassification classification = e.getClassification();
        if (classification instanceof CommissionedClassification) {
            CommissionedClassification commissionedClassification = (CommissionedClassification) classification;
            SalesReceipt salesReceipt = new SalesReceipt(date, amount);
            commissionedClassification.addSalesReceipt(salesReceipt);
        } else {
            throw new RuntimeException("Try to add SalesReceipt to non-commissioned employee");
        }
    }
}
