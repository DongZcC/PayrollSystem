package salary;

import salary.method.MailMethod;
import salary.method.PaymentMethod;

public class ChangeMailTransaction extends ChangeMethodTransaction {

    private int empId;

    private String address;

    public ChangeMailTransaction(int empId, String address) {
        super(empId);
        this.address = address;
    }

    @Override
    protected PaymentMethod getMethod() {
        return new MailMethod(address);
    }
}
