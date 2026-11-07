package pl.javaready.projects.collections.lesson21_exercise1_list;

import java.util.ArrayList;
import java.util.List;

public class ExpensesExercise {

    public static void main(String[] args) {
        List<Integer> expenses = new ArrayList<>();
        expenses.add(50);
        expenses.add(120);
        expenses.add(30);
        expenses.add(120);
        expenses.add(80);

        // TODO 1: print the expenses with a for-each loop and count their sum
        // TODO 2: remove the first expense equal to 120 (by value)
        // TODO 3: remove the expense from the beginning of the list (by index 0)
        // TODO 4: check if the list contains 30 and print its size
    }
}
