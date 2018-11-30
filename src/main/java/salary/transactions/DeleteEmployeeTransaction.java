package salary.transactions;

import lombok.AllArgsConstructor;
import salary.payrolldatabase.PayrollDatabase;

@AllArgsConstructor
public class DeleteEmployeeTransaction implements Transaction {

    private int empId;

    @Override
    public void execute() {
        PayrollDatabase.deleteEmployee(empId);
    }
}
