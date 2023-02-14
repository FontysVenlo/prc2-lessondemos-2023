/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdemo.fluentstyle;

import java.time.LocalDate;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author hvd
 */
public class Main {
    
    public static void main(String[] args) {
        
        Person p = new Person();
        p.setName("Richard");
        p.setBirthDate(LocalDate.of(2000, 1, 1));
        
        System.out.println("Current age is " + p.getAgeAt(LocalDate.now()));
        
        
        int age = new PersonFluent()
                .setName("Richard")
                .setBirthDate(LocalDate.of(2000, 1, 1))
                .getAgeAt(LocalDate.now());
        System.out.println("Current age is " + age);
        
    }
    
}
