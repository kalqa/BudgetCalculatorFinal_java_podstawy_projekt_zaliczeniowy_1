package pl.javaready.projects.collections.lesson18_map;

import java.util.*;

public class SetAndMapBasicsDemo {

    public static void main(String[] args) {
        // SET: add an element, ask whether it is inside
        Set<String> countries = new HashSet<>();
        countries.add("PL");
        countries.add("DE");
        countries.add("PL");   // already there, the set stays the same

        System.out.println(countries.contains("PL"));   // true
        System.out.println(countries.contains("FR"));   // false
        System.out.println(countries.size());           // 2
        // the set has no get(): it only knows what is inside

        // MAP: put a key together with a value, get the value by the key
        Map<String, Integer> stamps = new HashMap<>();
        stamps.put("PL", 3);
        stamps.put("DE", 1);
        stamps.put("PL", 5);   // the same key again: the value is overwritten

        System.out.println(stamps.get("PL"));           // 5
        System.out.println(stamps.get("FR"));           // null, there is no such key
        System.out.println(stamps.containsKey("DE"));   // true
        System.out.println(stamps.size());              // 2
    }
}
