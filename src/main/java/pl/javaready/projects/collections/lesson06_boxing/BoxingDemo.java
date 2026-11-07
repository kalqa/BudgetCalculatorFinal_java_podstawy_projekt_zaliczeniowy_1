package pl.javaready.projects.collections.lesson06_boxing;

import java.util.ArrayList;
import java.util.List;

public class BoxingDemo {

    public static void main(String[] args) {
//         List<int> does not compile: a collection holds only objects
        List<Integer> numbers = new ArrayList<>();

        int e = 5;
        numbers.add(e);               // autoboxing: int -> Integer
        int value = numbers.get(5);   // unboxing:   Integer -> int

        System.out.println("in the list: " + numbers + ", back to int: " + value);
    }
}
