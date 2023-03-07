package nl.fontys.zoodemo;

/**
 *
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 * @param <A>
 */
public interface Animal <A extends Animal<A>>{
    
    A move();
    
}
