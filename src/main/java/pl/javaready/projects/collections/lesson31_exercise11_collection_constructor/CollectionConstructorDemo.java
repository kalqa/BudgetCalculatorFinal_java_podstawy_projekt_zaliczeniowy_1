package pl.javaready.projects.collections.lesson31_exercise11_collection_constructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionConstructorDemo {

    public static void main(String[] args) {
        List<String> stamps = new ArrayList<>();
        stamps.add("PL");
        stamps.add("DE");
        stamps.add("PL");
        stamps.add("FR");
        stamps.add("DE");

        // a constructor can take another collection and copy all its elements into the new one
        // a set keeps every element only once, so the repeats disappear on the way
        Set<String> unique = new HashSet<>(stamps);
        System.out.println(unique);          // [DE, PL, FR]
        System.out.println(stamps.size());   // 5
        System.out.println(unique.size());   // 3

        // how many repeats were there?
        System.out.println(stamps.size() - unique.size());   // 2

        // and back: a list built from the set (no repeats, the order comes from the set, not from the original list)
        List<String> withoutRepeats = new ArrayList<>(unique);
        System.out.println(withoutRepeats);   // [DE, PL, FR]

        // a list built from a list is an independent copy
        List<String> copy = new ArrayList<>(stamps);
        copy.add("ES");
        System.out.println(copy.size());     // 6
        System.out.println(stamps.size());   // 5, the original did not change
    }
}
