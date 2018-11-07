package salary.method;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HoldMethod implements PaymentMethod {
    private String address;

    @Override
    public void pay(double amount) {

    }
}
