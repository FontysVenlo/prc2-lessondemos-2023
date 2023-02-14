package demo;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class Person {

    private final String name;
    private final LocalDate birthDate;

    /**
     * Create Person object.
     * @param name
     * @param birthDate
     */
    public Person( String name, LocalDate birthDate ) {
        this.name = name;
        this.birthDate = birthDate;
    }
    
    /**
     * Get name of person.
     * @return name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Get DOB.
     * @return dob
     */
    public LocalDate getBirthDate() {
        return birthDate;
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
