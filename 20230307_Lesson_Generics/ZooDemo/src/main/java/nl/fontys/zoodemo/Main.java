package nl.fontys.zoodemo;

/**
 *
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 */
public class Main {
    
    public static void main(String[] args) {
        
        Elephant e = new Elephant();
        
        e.eat();
        e.drink();
        
        e.move().eat().drink().drink().move();  
    }
}
