package pl.javaready.projects.collections.lesson18_map;

import java.util.*;
import java.util.Map.Entry;

public class StampMapDemo {

    public static void main(String[] args) {
        // the same stamps, counted by country: PL, DE, PL, FR, DE
        Map<String, Integer> counts = new HashMap<>();
        counts.put("PL", 2);
        counts.put("DE", 2);
        counts.put("FR", 1);

        counts.put("PL", 3);   // the same key: overwrites the value

        System.out.println(counts.get("PL"));               // 3
        System.out.println(counts.get("GB"));               // null
        System.out.println(counts.getOrDefault("GB", 0));   // 0

        System.out.println(counts.containsKey("DE"));   // true
        counts.remove("DE");                            // removes the whole pair
        System.out.println(counts.size());              // 2

        // every pair is an Entry object: it holds one key and one value
        Set<Entry<String, Integer>> entries = counts.entrySet();
        for (Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        List<String> stamps = new ArrayList<>();
        stamps.add("PL");
        stamps.add("GB");
        for (String stamp : stamps){
            System.out.println(stamp);
        }
    }
}
