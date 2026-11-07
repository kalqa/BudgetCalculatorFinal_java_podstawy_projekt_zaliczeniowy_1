package pl.javaready.projects.collections.lesson19_complexity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComplexityDemo {

    public static void main(String[] args) {
        for (int n : new int[]{10, 1_000, 100_000}) {
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            Map<Integer, String> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
                set.add(i);
                map.put(i, "value" + i);
            }

            int searched = n - 1; // the worst case for the list: the last element

            long start = System.nanoTime();
            list.contains(searched);
            long listNs = System.nanoTime() - start;

            start = System.nanoTime();
            set.contains(searched);
            long setNs = System.nanoTime() - start;

            start = System.nanoTime();
            map.get(searched);
            long mapNs = System.nanoTime() - start;

            System.out.println("n = " + n + ": ArrayList.contains " + listNs + " ns, HashSet.contains " + setNs
                    + " ns, HashMap.get " + mapNs + " ns");
        }
    }
}
