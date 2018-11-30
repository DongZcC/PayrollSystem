package salary.transactions;

import salary.payrolldatabase.Employee;
import salary.payrolldatabase.PayrollDatabase;

public abstract class ChangeEmployeeTransaction implements Transaction {

    private int empId;

    public ChangeEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getEmployee(empId);
        if (e != null)
            change(e);
    }

    protected abstract void change(Employee e);
}
