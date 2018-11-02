package salary;

import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UnionAffillation implements Affillation {

    private int memberId;

    private double amount;

    private Map<Date, ServiceCharge> serviceCharges = new HashMap<>();

    public UnionAffillation(int memberId, double amount) {
        this.memberId = memberId;
        this.amount = amount;
    }


    @Override
    public double getFee(Date date) {
        return 0;
    }

    public ServiceCharge getServiceCharge(Date date) {
        return serviceCharges.get(date);
    }

    public void addServiceCharge(ServiceCharge sc) {
        serviceCharges.put(sc.getDate(), sc);
    }
}
