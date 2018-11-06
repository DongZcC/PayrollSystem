package salary;

import salary.ChangeClassificationTransaction;
import salary.classify.PaymentClassification;
import salary.classify.SalariedClassification;
import salary.schdule.MonthlySchedule;
import salary.schdule.PaymentSchedule;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction {

    private double salary;

    public ChangeSalariedTransaction(int empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    protected PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    protected PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }
}
