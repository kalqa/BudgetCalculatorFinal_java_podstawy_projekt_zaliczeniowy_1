package pl.javaready.projects.collections.lesson17_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StampSetDemo {

    public static void main(String[] args) {
        // the same stamps as in the list lessons
        List<String> stamps = new ArrayList<>();
        stamps.add("PL");
        stamps.add("DE");
        stamps.add("PL");
        stamps.add("FR");
        stamps.add("DE");

        Set<String> countries = new HashSet<>();
        for (String stamp : stamps) {
            boolean added = countries.add(stamp);
            System.out.println(stamp + " -> " + (added ? "added" : "already there"));
        }

        System.out.println("list: " + stamps.size() + ", set: " + countries.size());
        System.out.println(countries.contains("FR"));

        // the main difference: the list remembers what and in which order (duplicates too),
        // the set remembers only what is inside, each element once
        System.out.println(stamps.get(2));   // PL, the list has numbers
        // countries.get(2);                 // does not exist, the set has no numbers
    }
}
