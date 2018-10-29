package salary.classify;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class SalariedClassification implements PaymentClassification {

    private double salary;

    @Override
    public double caculatePay(Date date) {
        return 0;
    }
}
