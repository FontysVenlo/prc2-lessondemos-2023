package mockingdemo;

/**
 *
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 */
public interface EmailService {

    void sendEmail(String to, String message);
    
}
