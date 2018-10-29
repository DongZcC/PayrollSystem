package salary.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class SalesReceipt {
    private Date date;

    private double amount;
}
