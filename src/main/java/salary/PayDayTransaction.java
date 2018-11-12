package salary;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayDayTransaction implements Transaction {

    private Date date;

    private Map<Integer, PayCheck> paychecks = new HashMap<>();

    public PayDayTransaction(Date date) {
        this.date = date;
    }

    @Override
    public void execute() {
        List<Employee> employeeList = PayrollDatabase.getEmployees();
        employeeList.forEach(e -> {
            // 是谁的方法就要谁去处理 .
            if (e.isPayDate(date)) {
                PayCheck pc = new PayCheck(date);
                paychecks.put(e.getEmpId(), pc);
                e.payDate(pc);
            }
        });
    }

    public PayCheck getPayCheck(int empId) {
        return paychecks.get(empId);
    }
}
