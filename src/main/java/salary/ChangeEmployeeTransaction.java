package salary;

public class ChangeEmployeeTransaction implements Transaction {

    private int empId;

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getEmployee(empId);


    }
}
