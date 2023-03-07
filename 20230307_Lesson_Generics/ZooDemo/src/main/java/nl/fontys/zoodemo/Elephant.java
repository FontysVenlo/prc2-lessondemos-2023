package nl.fontys.zoodemo;

/**
 *
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 */
public class Elephant implements Animal<Elephant> {
    
    public Elephant eat(){
        
        System.out.println("I am an eating elephant");
        return this;
        
    }
    
    public Elephant drink(){
        
        System.out.println("I am a drinking elephant");
        return this;
    }


    @Override
    public Elephant move() {
        System.out.println("I'm moving elephant");
        return this;        
    }








    
}
