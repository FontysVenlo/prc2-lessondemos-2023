package testdemo.consumer;

import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author Richard van den Ham <r.vandenham@fontys.nl>
 */
public class ConsumerLessonDemo {

    public static void main(String[] args) {

        // Consumer is a Functional Interface, it has a Single Abstract Method void accept(T t)...
        Consumer<String> textWriter1 = s -> System.out.println("Printwriter 1 says: " + s);
        Consumer<String> textWriter2 = s -> System.out.println("Printwriter 2 says: " + s);
        
        // Invoke the accept method and pass the actual parameter
        // It must be a String because we defined a Consumer 'of' String
        textWriter1.accept("Hello");
        textWriter2.accept("Bonjour");
        
        // We'd like to execute one of the lamda's based on a String
        String writerToUse = "textWriter2";
        
        // We map each String to a specific lambda
        // The data type of the lambda is, as you can see in lines 15/16,
        // Consumer<String>
        Map<String, Consumer<String>> methods = Map.of(
                "textWriter1", textWriter1,
                "textWriter2", textWriter2    
        );
        
        // Get from map the method with writerToUse String as key
        // Assume that it will be found and immediately execute it.
        methods.get(writerToUse).accept("Say Hello");
        
        // Goal of this example? We want to be able to pass the name of a method as String
        // to a parameterized test. Based on the map, we can find the method to be executed.
        // You'll see this concept applied in the Fraction assignment.
    }

}
