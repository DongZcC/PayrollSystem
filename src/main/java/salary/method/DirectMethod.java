package salary.method;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DirectMethod implements PaymentMethod {
    private String bankAccount;
}
