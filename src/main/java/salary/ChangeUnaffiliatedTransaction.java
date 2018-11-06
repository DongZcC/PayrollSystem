package salary;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {

    private int empId;

    public ChangeUnaffiliatedTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void recordMemberShip(Employee e) {
        Affiliation af = e.getAffiliation();
        if (af instanceof UnionAffiliation) {
            UnionAffiliation nf = (UnionAffiliation) af;
            PayrollDatabase.removeUnionMember(nf.getMemberId());
        }
    }

    @Override
    protected Affiliation getAffiliation() {
        return new NoAffiliation();
    }
}
