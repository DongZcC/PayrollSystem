package salary.transactions;

import salary.classifications.PaymentClassification;
import salary.classifications.SalariedClassification;
import salary.schdules.MonthlySchedule;
import salary.schdules.PaymentSchedule;

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
