package arraylistdemo;

/**
 * Version 2: GENERIC BUT NOT TYPE SAFE ARRAYLIST.
 * @author hvd
 */
public class ArrayList_2 {

    private final Object[] elements = new Object[10];
    private int numElements = 0;
    
    public int size() {
        return numElements;
    }

    public void add(Object o) {
        elements[numElements++] = o;
    }

    public Object get(int i) {
        return elements[i];
    }
    
    public static void main(String[] args) {
        ArrayList_2 cars = new ArrayList_2();
        cars.add( new Car() );
        Car c = (Car)cars.get(0);   // Casting required
        cars.add("You will crash"); // ACCEPTED BY COMPILER :-(
        Car c2 = (Car)cars.get(1);  // Will cause ClassCastException at Runtime! :-(
    }
}
