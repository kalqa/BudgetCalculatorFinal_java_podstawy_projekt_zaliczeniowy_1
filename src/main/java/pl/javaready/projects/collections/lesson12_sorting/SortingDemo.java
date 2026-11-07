package pl.javaready.projects.collections.lesson12_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingDemo {

    public static void main(String[] args) {
        // Integer and String already know how to compare themselves
        List<Integer> numbers = new ArrayList<>();
        numbers.add(42);
        numbers.add(7);
        numbers.add(19);
        numbers.add(3);
        Collections.sort(numbers);
        System.out.println(numbers);   // [3, 7, 19, 42]

        List<String> stamps = new ArrayList<>();
        stamps.add("PL");
        stamps.add("DE");
        stamps.add("FR");
        Collections.sort(stamps);
        System.out.println(stamps);    // [DE, FR, PL]
    }
}
