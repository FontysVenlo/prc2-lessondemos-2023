package mockingdemo;

import java.util.List;

/**
 *
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 */
@FunctionalInterface
public interface DatabaseService {

    List<Person> getPersons();
    
}
