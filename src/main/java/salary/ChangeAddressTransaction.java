package salary;

public class ChangeAddressTransaction extends ChangeEmployeeTransaction {

    private String address;


    public ChangeAddressTransaction(int empId, String address) {
        super(empId);
        this.address = address;
    }

    @Override
    protected void change(Employee e) {
        e.setAddress(address);
    }
}
