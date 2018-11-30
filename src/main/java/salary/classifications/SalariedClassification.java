package salary.classifications;

import lombok.AllArgsConstructor;
import salary.data.PayCheck;

@AllArgsConstructor
public class SalariedClassification implements PaymentClassification {

    private double salary;

    @Override
    public double caculatePay(PayCheck pc) {
        return salary;
    }
}
