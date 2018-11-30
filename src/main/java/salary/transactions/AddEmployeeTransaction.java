package salary.transactions;

import lombok.AllArgsConstructor;
import salary.affiliations.Affiliation;
import salary.payrolldatabase.Employee;
import salary.affiliations.NoAffiliation;
import salary.payrolldatabase.PayrollDatabase;
import salary.classifications.PaymentClassification;
import salary.methods.HoldMethod;
import salary.methods.PaymentMethod;
import salary.schdules.PaymentSchedule;

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
        employee.setEmpId(empId);

        employee.setClassification(getClassification());
        employee.setSchedule(getSchedule());
        PaymentMethod paymentMethod = new HoldMethod(itsAddress);
        employee.setPaymentMethod(paymentMethod);
        Affiliation affiliation = new NoAffiliation();
        employee.setAffiliation(affiliation);
        PayrollDatabase.addEmployee(empId, employee);
    }

    protected abstract PaymentClassification getClassification();

    protected abstract PaymentSchedule getSchedule();
}
