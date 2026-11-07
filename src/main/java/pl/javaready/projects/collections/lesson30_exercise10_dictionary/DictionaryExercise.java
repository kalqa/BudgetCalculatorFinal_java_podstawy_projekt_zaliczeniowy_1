package pl.javaready.projects.collections.lesson30_exercise10_dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryExercise {

    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("kot", "cat");
        dictionary.put("pies", "dog");
        dictionary.put("dom", "house");

        List<String> words = new ArrayList<>();
        words.add("kot");
        words.add("dom");
        words.add("ryba");
        words.add("pies");

        // TODO 1: go through the list and print every word with its translation, in the form "kot = cat"
        //         (a word that is not in the dictionary should show "?")
        // TODO 2: add the missing translation "ryba" -> "fish" and run the loop again
        // TODO 3: print the size of the dictionary
    }
}
