package pl.javaready.projects.collections.lesson22_exercise2_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingSolution {

    public static void main(String[] args) {
        List<Integer> expenses = new ArrayList<>();
        expenses.add(120);
        expenses.add(50);
        expenses.add(200);
        expenses.add(30);
        expenses.add(80);

        List<String> names = new ArrayList<>();
        names.add("Kasia");
        names.add("Adam");
        names.add("Zofia");
        names.add("Bartek");

        // 1: a ready-made method sorts ascending
        Collections.sort(expenses);
        System.out.println(expenses);   // [30, 50, 80, 120, 200]

        // 2: after sorting the smallest is the first, the biggest is the last
        System.out.println("smallest: " + expenses.get(0));                   // 30
        System.out.println("biggest: " + expenses.get(expenses.size() - 1));  // 200

        // 3: the same method sorts the names alphabetically
        Collections.sort(names);
        System.out.println(names);   // [Adam, Bartek, Kasia, Zofia]
    }
}
