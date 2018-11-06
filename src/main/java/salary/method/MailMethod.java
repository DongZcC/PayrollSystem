package salary.method;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MailMethod implements PaymentMethod {
    private String address;
}
