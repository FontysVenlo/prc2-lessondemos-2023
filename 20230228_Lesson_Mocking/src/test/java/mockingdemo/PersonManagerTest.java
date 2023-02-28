package mockingdemo;

import java.util.List;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author hvd
 */
@ExtendWith(MockitoExtension.class)
public class PersonManagerTest {

    Person frank = new Person("Frank", "Venlo", "Frank@fontys.nl");
    Person martijn = new Person("Martijn", "Horst", "Martijn@fontys.nl");
    Person ibrahim = new Person("Ibrahim", "Venlo", "Ibrahim@gmail.com");
    Person richard = new Person("Richard", "Venlo", "Richard@fontys.nl");
    
    PersonManager pm;
    
    // Fake service / stub
    //DatabaseService dbs = () -> List.of(frank, martijn, ibrahim, richard);
    
    // Mock for each Dependent On Component
    @Mock
    DatabaseService dbs;
    
    @Mock 
    EmailService ems;
    
    @Captor
    ArgumentCaptor<String> emailCaptor;
    
    @Captor
    ArgumentCaptor<String> messageCaptor;
    
    
//    DatabaseService dbs = new DatabaseService() {
//        
//        @Override
//        public List<Person> getPersons() {
//            return List.of(frank, martijn, ibrahim, richard);
//        }
//    };
    
//    EmailService ems = new EmailService() {
//        @Override
//        public void sendEmail(String to, String message) {
//            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        }
//    };
    
    
    @BeforeEach
    public void initialize() {
        pm = new PersonManager( dbs, ems);  // Arrange
    }
    
    @Test
    public void testGetAllPersons() {
        
        when(dbs.getPersons()).thenReturn( List.of(frank, martijn, ibrahim, richard) );
        
        List<Person> actual = pm.getAllPersons();  // Act
        assertThat(actual).as("Should be all").containsExactlyInAnyOrder(frank, martijn, ibrahim, richard);  // Assert
        
        verify( dbs, times(1)).getPersons();
    }
    
    @Test
    public void testGet() {
        Predicate<Person> predicate = p -> p.getHomeTown().equals("Venlo");
        List<Person> actual = pm.get( predicate );
        assertThat(actual).as("Should be some").containsExactlyInAnyOrder(frank, ibrahim, richard);
    }
    
    @Test
    public void testSendEmailToFontysStudents() {
        
        when(dbs.getPersons()).thenReturn( List.of(frank, martijn, ibrahim, richard) );
        
        Predicate<Person> predicate = p -> p.getEmailAddres().endsWith("fontys.nl");
        assertThatCode( () -> {
            pm.sendEmailTo(predicate, "Hello Fontys");
        }).doesNotThrowAnyException();
        
        verify( ems, times(3) ).sendEmail(emailCaptor.capture(), messageCaptor.capture());
        
        List<String> recordedEmails = emailCaptor.getAllValues();
        assertThat( recordedEmails ).containsExactlyInAnyOrder( frank.getEmailAddres(), martijn.getEmailAddres(), richard.getEmailAddres());
    }
    
    
}
