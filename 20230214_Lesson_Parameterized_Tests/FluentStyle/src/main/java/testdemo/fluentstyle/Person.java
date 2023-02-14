package testdemo.fluentstyle;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class Person {

    private String name;
    private LocalDate birthDate;

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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
