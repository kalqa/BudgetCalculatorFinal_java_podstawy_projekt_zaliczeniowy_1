package pl.javaready.projects.collections.lesson25_exercise5_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueCodesSolution {

    public static void main(String[] args) {
        List<String> codes = new ArrayList<>();
        codes.add("A1");
        codes.add("B2");
        codes.add("A1");
        codes.add("C3");
        codes.add("B2");
        codes.add("A1");

        Set<String> unique = new HashSet<>();
        List<String> repeated = new ArrayList<>();

        // 1: a code we have already seen goes to the list, a new one goes to the set
        for (String code : codes) {
            if (unique.contains(code)) {
                repeated.add(code);
            } else {
                unique.add(code);
            }
        }

        // 2
        System.out.println(unique.size());   // 3

        // 3
        System.out.println(unique.contains("C3"));   // true
        System.out.println(unique.contains("Z9"));   // false

        // 4
        System.out.println(repeated);   // [A1, B2, A1]
    }
}
