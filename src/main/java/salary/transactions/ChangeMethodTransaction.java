package salary.transactions;

import salary.payrolldatabase.Employee;
import salary.methods.PaymentMethod;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {

    public ChangeMethodTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee e) {
        e.setPaymentMethod(getMethod());
    }

    protected abstract PaymentMethod getMethod();
}
