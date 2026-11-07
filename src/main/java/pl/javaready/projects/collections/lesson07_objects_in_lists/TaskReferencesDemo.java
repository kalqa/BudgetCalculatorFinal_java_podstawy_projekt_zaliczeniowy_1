package pl.javaready.projects.collections.lesson07_objects_in_lists;

import java.util.ArrayList;
import java.util.List;

public class TaskReferencesDemo {

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Buy milk"));
        tasks.add(new Task("Write the lesson"));
        tasks.add(new Task("Walk the dog"));

        System.out.println(tasks);

        // the list holds references to objects, not the objects themselves
        Task shopping = tasks.get(0);
        shopping.markDone();

        System.out.println(tasks.get(0));                  // [x] Buy milk
        System.out.println(tasks.get(1));                  // [x] Buy milk
        System.out.println(tasks.get(2));                  // [x] Buy milk
        System.out.println(tasks.get(0) == shopping);      // true: it is the same object
        System.out.println(tasks);
    }
}
