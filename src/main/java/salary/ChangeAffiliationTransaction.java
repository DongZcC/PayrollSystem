package salary;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {

    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee e) {
        e.setAffiliation(getAffiliation());
    }

    protected abstract Affiliation getAffiliation();
}
