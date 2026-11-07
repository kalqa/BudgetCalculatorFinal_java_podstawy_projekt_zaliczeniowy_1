package pl.javaready.projects.collections.lesson10_growth;

import java.util.ArrayList;
import java.util.List;

public class GrowthDemo {

    public static void main(String[] args) {
        // you can add as many elements as you like, the list grows by itself
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }
        System.out.println(numbers.size());   // 100
    }
}
