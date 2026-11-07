package pl.javaready.projects.collections.lesson19_complexity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComplexityTasksDemo {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    // Task 1: 10 000 words checked against a blacklist of 100 000 words
    static void task1() {
        List<String> blacklistList = new ArrayList<>();
        Set<String> blacklistSet = new HashSet<>();
        for (int i = 0; i < 100_000; i++) {
            blacklistList.add("word" + i);
            blacklistSet.add("word" + i);
        }

        long start = System.nanoTime();
        int banned = 0;
        for (int i = 0; i < 10_000; i++) {
            if (blacklistList.contains("word" + (i * 10))) {   // O(n) for each word: 10 000 * 100 000 steps
                banned++;
            }
        }
        System.out.println("task 1, list: " + banned + " banned, " + (System.nanoTime() - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        banned = 0;
        for (int i = 0; i < 10_000; i++) {
            if (blacklistSet.contains("word" + (i * 10))) {    // O(1) for each word
                banned++;
            }
        }
        System.out.println("task 1, set:  " + banned + " banned, " + (System.nanoTime() - start) / 1_000_000 + " ms");
    }

    // Task 2: find a user by id among 100 000 users
    static void task2() {
        List<User> usersList = new ArrayList<>();
        Map<Integer, User> usersById = new HashMap<>();
        for (int i = 0; i < 100_000; i++) {
            User user = new User(i, "user" + i);
            usersList.add(user);
            usersById.put(user.getId(), user);
        }

        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            for (User user : usersList) {              // O(n): look at the users one by one
                if (user.getId() == 99_999) {
                    break;
                }
            }
        }
        System.out.println("task 2, list: " + (System.nanoTime() - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            usersById.get(99_999);                     // O(1): straight to the bucket
        }
        System.out.println("task 2, map:  " + (System.nanoTime() - start) / 1_000_000 + " ms");
    }

    // Task 3: add at the beginning of a list or at the end
    static void task3() {
        List<Integer> atEnd = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            atEnd.add(i);                              // O(1): the elements stay where they are
        }
        System.out.println("task 3, add at the end:       " + (System.nanoTime() - start) / 1_000_000 + " ms");

        List<Integer> atStart = new ArrayList<>();
        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            atStart.add(0, i);                         // O(n): every element must move one place
        }
        System.out.println("task 3, add at the beginning: " + (System.nanoTime() - start) / 1_000_000 + " ms");
    }
}
