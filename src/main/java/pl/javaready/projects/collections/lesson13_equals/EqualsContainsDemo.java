package pl.javaready.projects.collections.lesson13_equals;

import java.util.ArrayList;
import java.util.List;

public class EqualsContainsDemo {

    public static void main(String[] args) {
        // without equals(): contains compares references
        List<Task> tasks = new ArrayList<>();
        Task buyMilk = new Task("Buy milk");
        tasks.add(buyMilk);
        Task buyMilk1 = new Task("Buy milk");
        System.out.println(tasks.contains(buyMilk1));   // false

        // with equals(): contains compares content
        List<TaskWithEquals> tasksWithEquals = new ArrayList<>();
        tasksWithEquals.add(new TaskWithEquals("Buy milk"));
        TaskWithEquals buyMilk2 = new TaskWithEquals("Buy milk");
        boolean contains = tasksWithEquals.contains(buyMilk2);
        System.out.println(contains);   // true
    }
}
