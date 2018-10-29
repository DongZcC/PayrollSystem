package salary.method;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailMethod implements PaymentMethod {
    private String address;
}
