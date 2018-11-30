package salary.transactions;

import salary.classifications.CommissionedClassification;
import salary.classifications.PaymentClassification;
import salary.schdules.BiweeklySchedule;
import salary.schdules.PaymentSchedule;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {


    private double commisionRate;

    private double salary;

    public ChangeCommissionedTransaction(int empId, double commissionRate, double salary) {
        super(empId);
        this.commisionRate = commissionRate;
        this.salary = salary;
    }

    @Override
    protected PaymentClassification getClassification() {
        return new CommissionedClassification(commisionRate, salary);
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new BiweeklySchedule();
    }
}
