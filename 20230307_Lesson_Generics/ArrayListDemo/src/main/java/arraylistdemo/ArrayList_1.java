package arraylistdemo;

/**
 * Version 1: NOT GENERIC BUT TYPE SAFE ARRAYLIST.
 * @author hvd
 */
public class ArrayList_1 {

    private final Car[] elements = new Car[10];
    private int numElements = 0;
    
    public int size() {
        return numElements;
    }

    public void add(Car c) {
        elements[numElements++] = c;
    }

    public Car get(int i) {
        return elements[i];
    }
    
    public static void main(String[] args) {
        ArrayList_1 cars = new ArrayList_1();
        cars.add( new Car() );
        Car c = cars.get(0);   // No Casting required
        //cars.add("You will crash"); // NOT ACCEPTED BY COMPILER :-(
    }
}
