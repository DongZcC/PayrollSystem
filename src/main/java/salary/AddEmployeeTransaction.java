package salary;

import lombok.AllArgsConstructor;

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
    }

    protected abstract PaymentClassification getClassification();

    protected abstract PaymentSchedule getSchedule();
}
