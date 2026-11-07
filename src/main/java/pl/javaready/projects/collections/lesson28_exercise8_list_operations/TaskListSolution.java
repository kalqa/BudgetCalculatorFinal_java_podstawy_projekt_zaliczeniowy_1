package pl.javaready.projects.collections.lesson28_exercise8_list_operations;

import java.util.ArrayList;
import java.util.List;

public class TaskListSolution {

    public static void main(String[] args) {
        List<String> tasks = new ArrayList<>();

        // 1
        tasks.add("Buy milk");
        tasks.add("Call mom");
        tasks.add("Pay bills");

        // 2: the index loop gives the position
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));   // 0: Buy milk, 1: Call mom, 2: Pay bills
        }

        // 3
        System.out.println(tasks.indexOf("Call mom"));   // 1

        // 4
        tasks.remove("Call mom");
        System.out.println(tasks.size());   // 2

        // 5
        tasks.clear();
        System.out.println(tasks.isEmpty());   // true
    }
}
