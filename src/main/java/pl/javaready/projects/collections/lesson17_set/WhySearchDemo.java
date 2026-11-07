package pl.javaready.projects.collections.lesson17_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WhySearchDemo {

    public static void main(String[] args) {
        // 100 000 transfer numbers, once in a list and once in a hash set
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 100_000_00; i++) {
            list.add("transfer" + i);
            set.add("transfer" + i);
        }

        String searched = "transfer999999";   // the very last one

        // the list checks the elements one by one
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.contains(searched);
        }
        System.out.println("list: " + (System.nanoTime() - start) / 1_000_000 + " ms");

        // the set uses the hash and goes straight to the right place
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            set.contains(searched);
        }
        System.out.println("set:  " + (System.nanoTime() - start) / 1_000_000 + " ms");
        // the exact times differ on every computer, but the set is many times faster
    }
}
