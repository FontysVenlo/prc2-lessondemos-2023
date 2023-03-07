package fontys.cheatdemo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hvd
 */
public class Main {

    public static void main(String[] args) {
        
        List<Integer> list = new ArrayList<>();
        ((List) list).add("a String");
        //Integer result = list.get(0);
        System.out.println(list.get(0));
        
        List<String> list2 = new ArrayList<>();
        ((List) list2).add(1);
        System.out.println(list2.get(0));
    }

}
