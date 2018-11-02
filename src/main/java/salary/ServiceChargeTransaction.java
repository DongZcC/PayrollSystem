package salary;

import lombok.AllArgsConstructor;

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

//        for (Affillation affillation : e.getAffillations()) {
            // 如果是工会则可以添加服务费
            if (e.getAffillation() instanceof UnionAffillation) {
                UnionAffillation unionAffillation = (UnionAffillation) e.getAffillation();
                ServiceCharge sc = new ServiceCharge(date, charge);
                unionAffillation.addServiceCharge(sc);
            }
//        }
    }
}
