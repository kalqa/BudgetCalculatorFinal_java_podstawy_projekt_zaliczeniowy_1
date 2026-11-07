package pl.javaready.projects.collections.lesson05_diamond;

import java.util.ArrayList;
import java.util.List;

public class DiamondDemo {

    public static void main(String[] args) {
        // List<String>: the type of the elements; <>: the compiler infers it from the left side
        List<String> stamps = new ArrayList<>();
        stamps.add("PL");   // OK

        Integer i = 5;
//        stamps.add(i);   // compile error: incompatible types: int cannot be converted to String

        List<Integer> numbers = new ArrayList<>();
        int e = 5;
        numbers.add(e);     // OK
//         numbers.add("PL"); // compile error: incompatible types: String cannot be converted to Integer

        System.out.println(stamps + " " + numbers);
    }
}
