package arraylistdemo;

/**
 * Version 3: GENERIC AND TYPE SAFE ARRAYLIST.
 * @author hvd
 * @param <E> Called Formal Type Parameter or Type token
 */
public class ArrayList_3<E> {

    private final Object[] elements = new Object[10];    // new E[10] not allowed, class should be compilable by itself
    private int numElements = 0;
    
    public int size() {
        return numElements;
    }

    public void add(E e) {
        elements[numElements++] = e;
    }

    @SuppressWarnings("unchecked")
    public E get(int i) {
        return (E)elements[i];
    }
    
    public static void main(String[] args) {
        ArrayList_3<Car> cars = new ArrayList_3<>();
        cars.add( new Car() );
        Car c = cars.get(0); // No casting required
        //cars.add("You will crash"); // NOT ACCEPTED BY COMPILER
        ArrayList_3 carList = new ArrayList_3(); // Using so-called RAW-type is still allowed!
        //carList. ...
    }
}
