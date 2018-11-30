package salary.transactions;

import salary.methods.DirectMethod;
import salary.methods.PaymentMethod;

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
