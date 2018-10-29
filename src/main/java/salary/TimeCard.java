package salary;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class TimeCard {

    private Date date;

    private double hours;
}
