package salary;

import java.util.Date;

public class NoAffiliation implements Affiliation {


    // NULL OBJECT MODEL

    @Override
    public double getFee(Date date) {
        return 0;
    }
}
