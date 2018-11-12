package salary.method;

import lombok.AllArgsConstructor;
import salary.PayCheck;

@AllArgsConstructor
public class HoldMethod implements PaymentMethod {

    private String address;

    @Override
    public void pay(PayCheck pc) {
        pc.putFields("Disposition", "Hold");
    }
}
