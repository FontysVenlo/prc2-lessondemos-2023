/*
 * Copyright (c) 2019 Informatics Fontys FHTenL University of Applied Science Venlo
 */
package arraylist;

import arraylistdemo.ArrayList_3;
import arraylistdemo.Car;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author Richard van den Ham {@code r.vandenham@fontys.nl}
 */
public class ArrayListTest {

    //@Disabled("think TDD")
    @Test
    public void size_of_empty_list_0() {

        ArrayList_3 carList = new ArrayList_3();

        int expectedSize = 0;
        int actualSize = carList.size();

        assertThat( actualSize ).as( "Size should be zero for empty list" ).isEqualTo( expectedSize );

        //fail( "method method reached end. You know what to do." );
    }

    //@Disabled("think TDD")
    @Test
    public void sizeafterAdding1() {


        ArrayList_3 carList = new ArrayList_3();
        Car c = new Car();
        carList.add(c);

        int expectedSize = 1;
        int actualSize = carList.size();

        assertThat( actualSize ).as( "Size after adding should be 1" ).isEqualTo( expectedSize );

        //fail( "method sizeafterAdding1 reached end. You know what to do." );
    }
    
    //@Disabled("think TDD")
    @Test
    public void addCar() {
        
        ArrayList_3<Car> carList = new ArrayList_3<>();
        Car carToAdd = new Car();
        //String carToAdd = "You'll crash!";
        carList.add(carToAdd);

        Car actualCar = carList.get(0);

        assertThat( actualCar ).as( "I should get my own car back!" ).isSameAs( carToAdd );
         
        //fail( "method addCar reached end. You know what to do." );
    }
    
    //@Disabled("think TDD")
    @Test
    public void addString() {
        
        ArrayList_3<String> namesList = new ArrayList_3<>();
        String name = "Richard";
        namesList.add( name );
        
        // if ( namesList instanceof ArrayList_3<String>) {   -----! This is not allowed! Generic Type during runtime not available
        if ( namesList instanceof ArrayList_3) {
            System.out.println( "Yes it is a Stringlist" );
            
        }
        
        String expected = name;
        String actual = namesList.get( 0 );
        
        assertThat( actual ).as( "Please name back").isEqualTo( expected );
        
        //fail( "method addString reached end. You know what to do." );
    }

}
