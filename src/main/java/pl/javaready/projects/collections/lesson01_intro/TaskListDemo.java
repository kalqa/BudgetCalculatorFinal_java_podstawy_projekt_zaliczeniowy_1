package pl.javaready.projects.collections.lesson01_intro;

import java.util.ArrayList;
import java.util.List;

public class TaskListDemo {

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();

        Task shopping = new Task("Buy milk");
        tasks.add(shopping);
        tasks.add(new Task("Write the lesson"));
        tasks.add(new Task("Walk the dog"));

        System.out.println(tasks);
    }
}
