package salary;

import salary.method.DirectMethod;
import salary.method.PaymentMethod;

public class ChangeDirectTransaction extends ChangeMethodTransaction {

    private int empId;

    private String bankAccount;

    public ChangeDirectTransaction(int empId, String bankAccount) {
        super(empId);
        this.bankAccount = bankAccount;
    }

    @Override
    protected PaymentMethod getMethod() {
        return new DirectMethod(bankAccount);
    }
}
