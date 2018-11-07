package salary;

import java.util.Date;
import java.util.List;

public class PayDayTransaction implements Transaction {

    private Date date;

    public PayDayTransaction(Date date) {
        this.date = date;
    }

    @Override
    public void execute() {
        List<Employee> employeeList = PayrollDatabase.getEmployees();
        employeeList.forEach((e) -> {
            if (e.getSchedule().isPayDate(date)) {
                double amount = e.getClassification().caculatePay(date);
                e.getPaymentMethod().pay(amount);
            }
        });
    }
}
