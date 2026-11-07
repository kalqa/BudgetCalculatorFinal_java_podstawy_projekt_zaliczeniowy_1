package pl.javaready.projects.collections.lesson25_exercise5_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueCodesExercise {

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

        // TODO 1: go through the codes; a code that is already in the set goes to "repeated",
        //         every other code goes to the set
        // TODO 2: print how many unique codes there are
        // TODO 3: check whether the set contains "C3" and whether it contains "Z9"
        // TODO 4: print the list of repeated codes
    }
}
