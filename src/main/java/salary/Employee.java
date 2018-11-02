package salary;

import lombok.Getter;
import lombok.Setter;
import salary.classify.PaymentClassification;
import salary.method.PaymentMethod;
import salary.schdule.PaymentSchedule;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Employee {

    private String name;

    private String address;

    private PaymentClassification classification;

    private PaymentSchedule schedule;

    private PaymentMethod paymentMethod;

    private Affillation affillation;

}
