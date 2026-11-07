package pl.javaready.projects.collections.lesson11_operations;

import java.util.ArrayList;
import java.util.List;

public class OperationsDemo {

    public static void main(String[] args) {
        List<String> stamps = new ArrayList<>();
        stamps.add("PL");
        stamps.add("DE");
        stamps.add("FR");

        // ready-made methods from the creators of Java: you do not have to write them
        System.out.println(stamps.contains("DE"));   // true
        System.out.println(stamps.indexOf("FR"));    // 2
        System.out.println(stamps.indexOf("GB"));    // -1, so it is not there

        stamps.remove(0);                            // by index -> [DE, FR]
        stamps.remove("FR");                         // by value -> [DE]
        System.out.println(stamps);

        System.out.println(stamps.isEmpty());        // false
        stamps.clear();
        System.out.println(stamps.isEmpty());        // true

        // trap: on a list of numbers remove(int) removes by index, remove(Object) by value
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.remove(10);                     // index 1 -> [10, 30]
        numbers.remove(Integer.valueOf(10));   // value 10 -> [30]
        System.out.println(numbers);
    }
}
