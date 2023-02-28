package mockingdemo;

import java.util.List;

/**
 *
 * @author hvd
 */
public class DatabaseServiceImplementation implements DatabaseService {
    
    @Override
    public List<Person> getPersons(){
        
        // This REAL WORLD class should do difficult database stuff
        
        throw new UnsupportedOperationException("Real world database service not supported yet.");
    }
    
    
}
