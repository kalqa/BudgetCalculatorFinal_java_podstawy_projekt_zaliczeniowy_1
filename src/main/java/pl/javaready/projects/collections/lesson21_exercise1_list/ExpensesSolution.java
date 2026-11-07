package pl.javaready.projects.collections.lesson21_exercise1_list;

import java.util.ArrayList;
import java.util.List;

public class ExpensesSolution {

    public static void main(String[] args) {
        List<Integer> expenses = new ArrayList<>();
        expenses.add(50);
        expenses.add(120);
        expenses.add(30);
        expenses.add(120);
        expenses.add(80);

        // 1: iterate and count the sum
        int sum = 0;
        for (int expense : expenses) {
            System.out.println(expense);
            sum += expense;
        }
        System.out.println("sum: " + sum);   // 400

        // 2: remove by value (not by index!)
        expenses.remove(Integer.valueOf(120));   // removes only the first 120
        System.out.println(expenses);            // [50, 30, 120, 80]

        // 3: remove by index
        expenses.remove(0);                      // removes 50
        System.out.println(expenses);            // [30, 120, 80]

        // 4: contains and size
        System.out.println(expenses.contains(30));   // true
        System.out.println(expenses.size());         // 3
    }
}
