package pl.javaready.projects.collections.lesson17_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListOrSetDemo {

    public static void main(String[] args) {
        // a list: the order matters and the same thing may appear twice (a to-do list)
        List<String> todo = new ArrayList<>();
        todo.add("Buy milk");
        todo.add("Call mom");
        todo.add("Buy milk");   // allowed: it is a second, separate task
        System.out.println(todo.size());   // 3
        System.out.println(todo.get(1));   // Call mom: we can ask for the item number 1

        // a set: only "is it inside?" matters (newsletter subscribers)
        Set<String> subscribers = new HashSet<>();
        System.out.println(subscribers.add("ann@x.com"));   // true
        System.out.println(subscribers.add("ann@x.com"));   // false: already subscribed
        System.out.println(subscribers.contains("ann@x.com"));   // true, answered quickly even with millions of addresses
    }
}
