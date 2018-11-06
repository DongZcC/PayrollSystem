package salary;

import salary.classify.CommissionedClassification;
import salary.classify.PaymentClassification;
import salary.schdule.BiweeklySchedule;
import salary.schdule.PaymentSchedule;

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
