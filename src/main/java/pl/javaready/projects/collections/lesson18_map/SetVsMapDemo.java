package pl.javaready.projects.collections.lesson18_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SetVsMapDemo {

    public static void main(String[] args) {
        List<String> stamps = new ArrayList<>();
        stamps.add("PL");
        stamps.add("DE");
        stamps.add("PL");
        stamps.add("FR");
        stamps.add("DE");

        // the set knows which countries we have, but nothing more
        Set<String> countries = new HashSet<>();
        for (String stamp : stamps) {
            countries.add(stamp);
        }
        System.out.println(countries.contains("PL"));   // true
        // how many PL stamps? the set cannot tell: it keeps each element once and attaches nothing to it

        // the map attaches a number to each country
        Map<String, Integer> counts = new HashMap<>();
        for (String stamp : stamps) {
            int value = counts.getOrDefault(stamp, 0) + 1;
            counts.put(stamp, value);
        }
        System.out.println(counts.get("PL"));   // 2
    }
}
