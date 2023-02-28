package mockingdemo;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author hvd
 */
public class PersonManager {
    
    private final DatabaseService dbService;// = new DatabaseServiceImplementation();
    private final EmailService emailService;// = new EmailServiceImplementation();

    public PersonManager(DatabaseService dbService, EmailService emailService) {
        this.dbService = dbService;
        this.emailService = emailService;
    }
    
    public List<Person> getAllPersons(){
        return dbService.getPersons();
    }
    
    public List<Person> get( Predicate<Person> selector ){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void sendEmailTo( Predicate<Person> selector, String message){
        getAllPersons()
                .stream()
                .filter(selector)
                .forEach( p -> emailService.sendEmail(p.getEmailAddres(), message));
    }  
}
