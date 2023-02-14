package testdemo.fluentstyle;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class PersonFluent {

    private String name;
    private LocalDate birthDate;

    public PersonFluent setName(String name) {
        this.name = name;
        return this;
    }

    public PersonFluent setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    /**
     * Get the age of a person at a certain date.
     * @param date on which you want to determine the age 
     * @return age of the person at provided date
     */
    public int getAgeAt( LocalDate date ) {
        return Period.between( birthDate, date).getYears();
    }
}
