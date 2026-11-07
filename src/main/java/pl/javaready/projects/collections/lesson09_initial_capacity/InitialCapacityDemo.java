package pl.javaready.projects.collections.lesson09_initial_capacity;

import java.util.ArrayList;
import java.util.List;

public class InitialCapacityDemo {

    public static void main(String[] args) {
        // you can give the list an initial size, without it Java uses 10 places
        List<String> defaultList = new ArrayList<>();
        List<String> bigList = new ArrayList<>(20);

        // size() counts the elements, not the free places
        System.out.println(defaultList.size());   // 0
        System.out.println(bigList.size());       // 0, although there is room for 20

        bigList.add("PL");
        bigList.add("DE");
        System.out.println(bigList.size());       // 2

        // an array of the same size would always say 20
        String[] array = new String[20];
        System.out.println(array.length);         // 20

        // a small start is not a limit: the list just grows when it needs more room
        List<String> smallList = new ArrayList<>(3);
        for (int i = 0; i < 5; i++) {
            smallList.add("stamp " + i);
        }
        System.out.println(smallList.size());     // 5

        // the capacity itself cannot be read: ArrayList has no method for that
    }
}
