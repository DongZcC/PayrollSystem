package salary.transactions;

import salary.affiliations.Affiliation;
import salary.affiliations.NoAffiliation;
import salary.affiliations.UnionAffiliation;
import salary.payrolldatabase.Employee;
import salary.payrolldatabase.PayrollDatabase;

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
