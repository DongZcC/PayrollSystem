package salary;

import lombok.AllArgsConstructor;
import salary.classify.PaymentClassification;
import salary.method.HoldMethod;
import salary.method.PaymentMethod;
import salary.schdule.PaymentSchedule;

@AllArgsConstructor
public abstract class AddEmployeeTransaction implements Transaction {

    protected int empId;
    protected String itsAddress;
    protected String itsName;

    @Override
    public void execute() {
        Employee employee = new Employee();
        employee.setAddress(itsAddress);
        employee.setName(itsName);

        employee.setClassification(getClassification());
        employee.setSchedule(getSchedule());
        PaymentMethod paymentMethod = new HoldMethod();
        employee.setPaymentMethod(paymentMethod);

        PayrollDatabase.addEmployee(empId, employee);
    }

    protected abstract PaymentClassification getClassification();

    protected abstract PaymentSchedule getSchedule();
}