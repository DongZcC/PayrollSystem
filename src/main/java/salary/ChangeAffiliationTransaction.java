package salary;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {

    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee e) {
        e.setAffiliation(getAffiliation());

        //
        recordMemberShip(e);
    }

    protected abstract void recordMemberShip(Employee e);

    protected abstract Affiliation getAffiliation();
}
