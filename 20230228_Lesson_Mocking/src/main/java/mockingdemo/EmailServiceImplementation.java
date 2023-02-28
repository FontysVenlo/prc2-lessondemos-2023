package mockingdemo;

/**
 *
 * @author hvd
 */
public class EmailServiceImplementation implements EmailService {
    
    @Override
    public void sendEmail(String to, String message){
        
        // This REAL WORLD component knows how to send emails
        throw new UnsupportedOperationException("Real world email service not supported yet.");
        
    }
    
}
