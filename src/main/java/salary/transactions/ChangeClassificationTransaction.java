package salary.transactions;

import salary.payrolldatabase.Employee;
import salary.classifications.PaymentClassification;
import salary.schdules.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

    public ChangeClassificationTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee e) {
        e.setClassification(getClassification());
        e.setSchedule(getSchedule());
    }

    protected abstract PaymentClassification getClassification();

    protected abstract PaymentSchedule getSchedule();
}
