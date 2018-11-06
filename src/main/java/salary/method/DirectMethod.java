package salary.method;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DirectMethod implements PaymentMethod {
    private String bankAccount;
}
