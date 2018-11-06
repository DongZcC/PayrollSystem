package salary;

import salary.method.PaymentMethod;

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
