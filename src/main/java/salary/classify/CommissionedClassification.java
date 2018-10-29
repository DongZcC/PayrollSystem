package salary.classify;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class CommissionedClassification implements PaymentClassification {

    private double commissionRate;

    private double salary;



    @Override
    public double caculatePay(Date date) {
        return 0;
    }
}
