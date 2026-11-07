package pl.javaready.projects.collections.lesson29_exercise9_map_stock;

import java.util.HashMap;
import java.util.Map;

public class StockSolution {

    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();

        // 1
        stock.put("apple", 5);
        stock.put("pear", 2);
        stock.put("plum", 4);

        // 2: the same key again overwrites the value
        stock.put("apple", stock.get("apple") - 2);
        System.out.println(stock.get("apple"));   // 3

        // 3
        if (!stock.containsKey("banana")) {
            System.out.println("we do not have banana");
        }

        // 4
        stock.remove("pear");

        // 5
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
