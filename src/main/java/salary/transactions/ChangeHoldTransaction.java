package salary.transactions;

import salary.methods.HoldMethod;
import salary.methods.PaymentMethod;

public class ChangeHoldTransaction extends ChangeMethodTransaction {

    private int empId;

    private String address;

    public ChangeHoldTransaction(int empId, String address) {
        super(empId);
        this.address = address;
    }

    @Override
    protected PaymentMethod getMethod() {
        return new HoldMethod(address);
    }
}
