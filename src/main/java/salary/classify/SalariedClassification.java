package salary.classify;

import lombok.AllArgsConstructor;
import salary.PayCheck;

import java.util.Date;

@AllArgsConstructor
public class SalariedClassification implements PaymentClassification {

    private double salary;

    @Override
    public double caculatePay(PayCheck pc) {
        return salary;
    }
}
