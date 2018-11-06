package salary;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {

    private int empId;

    private int memId;

    private double amount;

    public ChangeMemberTransaction(int empId, int memId, double amount) {
        super(empId);
        this.memId = memId;
        this.amount = amount;
    }


    @Override
    protected void recordMemberShip(Employee e) {
        PayrollDatabase.addUnionMember(memId, e);
    }

    @Override
    protected Affiliation getAffiliation() {
        return new UnionAffiliation(memId, amount);
    }
}
