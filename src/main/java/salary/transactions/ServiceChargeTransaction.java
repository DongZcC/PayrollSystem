package salary.transactions;

import lombok.AllArgsConstructor;
import salary.payrolldatabase.Employee;
import salary.payrolldatabase.PayrollDatabase;
import salary.affiliations.ServiceCharge;
import salary.affiliations.UnionAffiliation;

import java.util.Date;

@AllArgsConstructor
public class ServiceChargeTransaction implements Transaction {

    private Date date;

    private int memberId;

    private double charge;


    @Override
    public void execute() {
        Employee e = PayrollDatabase.getUnionMember(memberId);
        if (e == null)
            throw new RuntimeException("the member have no employee");

//        for (Affiliation affiliation : e.getAffillations()) {
            // 如果是工会则可以添加服务费
            if (e.getAffiliation() instanceof UnionAffiliation) {
                UnionAffiliation unionAffillation = (UnionAffiliation) e.getAffiliation();
                ServiceCharge sc = new ServiceCharge(date, charge);
                unionAffillation.addServiceCharge(sc);
            }
//        }
    }
}
