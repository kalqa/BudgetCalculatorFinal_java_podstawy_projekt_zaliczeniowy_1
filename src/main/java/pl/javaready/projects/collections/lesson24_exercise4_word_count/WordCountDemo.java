package pl.javaready.projects.collections.lesson24_exercise4_word_count;

import java.util.HashMap;
import java.util.Map;

public class WordCountDemo {

    public static void main(String[] args) {
        String text = "ala ma kota a kot ma ale";
        Map<String, Integer> counter = new HashMap<>();

        for (String word : text.split(" ")) {
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }

        System.out.println(counter);
    }
}
