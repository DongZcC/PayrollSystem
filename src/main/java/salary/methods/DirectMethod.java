package salary.methods;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import salary.data.PayCheck;

@Getter
@Setter
@AllArgsConstructor
public class DirectMethod implements PaymentMethod {

    private String bankAccount;

    @Override
    public void pay(PayCheck pc) {

    }
}
