package pl.javaready.projects.collections.lesson30_exercise10_dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionarySolution {

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

        // 1: getOrDefault gives "?" when the key is missing
        for (String word : words) {
            System.out.println(word + " = " + dictionary.getOrDefault(word, "?"));
        }

        // 2
        dictionary.put("ryba", "fish");
        for (String word : words) {
            System.out.println(word + " = " + dictionary.getOrDefault(word, "?"));
        }

        // 3
        System.out.println(dictionary.size());   // 4
    }
}
