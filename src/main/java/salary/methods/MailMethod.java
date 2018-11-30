package salary.methods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import salary.data.PayCheck;

@Getter
@Setter
@AllArgsConstructor
public class MailMethod implements PaymentMethod {

    private String address;

    @Override
    public void pay(PayCheck pc) {

    }
}
