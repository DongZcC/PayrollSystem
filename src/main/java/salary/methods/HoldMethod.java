package salary.methods;

import lombok.AllArgsConstructor;
import salary.data.PayCheck;

@AllArgsConstructor
public class HoldMethod implements PaymentMethod {

    private String address;

    @Override
    public void pay(PayCheck pc) {
        pc.putFields("Disposition", "Hold");
    }
}
