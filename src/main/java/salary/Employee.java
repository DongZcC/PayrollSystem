package salary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private String name;

    private String address;

    private PaymentClassification classification;

    private PaymentSchedule schedule;
}
