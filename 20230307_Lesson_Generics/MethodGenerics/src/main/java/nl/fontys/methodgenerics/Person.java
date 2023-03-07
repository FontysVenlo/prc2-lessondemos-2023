package nl.fontys.methodgenerics;

/**
 *
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 */
public class Person {
    
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + '}';
    }
    
    
}
