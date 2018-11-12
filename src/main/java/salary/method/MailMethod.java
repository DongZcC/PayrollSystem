package salary.method;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import salary.PayCheck;

@Getter
@Setter
@AllArgsConstructor
public class MailMethod implements PaymentMethod {

    private String address;

    @Override
    public void pay(PayCheck pc) {

    }
}
