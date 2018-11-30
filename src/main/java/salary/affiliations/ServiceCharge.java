package salary.affiliations;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ServiceCharge {

    private Date date;

    private double amount;
}
