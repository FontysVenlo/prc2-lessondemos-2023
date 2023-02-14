package demo;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author hvd
 */
public class PersonTest {

    static Map<String, Person> testPersons = Map.of(
            "Alex", new Person("Alex", LocalDate.of(1990, 6, 1)),
            "Lisa", new Person("Lisa", LocalDate.of(1990, 6, 1))
    // etc
    );

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("Age before birthDay", 28, new Person("Alex", LocalDate.of(1990, 6, 1)), "2019-02-01"),
                Arguments.of("Age day before birthDay", 29, new Person("Lisa", LocalDate.of(1990, 6, 1)), "2020-05-31")
        );
    }

    //@Disabled("think TDD")
    @ParameterizedTest
    @CsvSource(
        {
            // Message,                 exp,name    dob         date
            "Age before birthDay,       28, Alex,   1990-06-01, 2019-02-01",
            "Age day before birthDay,   29, Lisa,   1990-06-01, 2020-05-31",
            "Age on birthDay,           30, Jim,    1990-06-01, 2020-06-01",
            "Age day after birthDay,    30, Sarah,  1990-06-01, 2020-06-02",
            "Age leapYear birthDay,     15, John,   2004-02-29, 2020-02-01",
            "Age first year of life,     0, Baby,   2020-01-01, 2020-12-01"
        }
    )
    public void ageTabularCSV(String message, int expectedAge, String name, LocalDate dob, LocalDate dateOfRequest) {

        //Arrange
        //Person p = testPersons.get(name);
        Person p = new Person(name, dob);

        // Act
        int actualAge = p.getAgeAt(dateOfRequest);

        // Assert
        assertThat(actualAge).as(message).isEqualTo(expectedAge);

        //fail( "method ageTabular reached end. You know what to do." );
    }

    //@Disabled("think TDD")
    @ParameterizedTest
    @CsvFileSource(resources = "testCases.csv", numLinesToSkip = 1)
    public void ageTabularCSVFile(String message, int expectedAge, String name, LocalDate dob, LocalDate dateOfRequest) {

        Person p = new Person(name, dob);
        assertThat(p.getAgeAt(dateOfRequest)).as(message).isEqualTo(expectedAge);
        //fail( "method ageTabular reached end. You know what to do." );
    }

    //@Disabled("think TDD")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void ageTabularMethodSource(String message, int expectedAge, Person p, LocalDate dateOfRequest) {

        assertThat(p.getAgeAt(dateOfRequest)).as(message).isEqualTo(expectedAge);
        //fail( "method ageTabular reached end. You know what to do." );
    }

}
