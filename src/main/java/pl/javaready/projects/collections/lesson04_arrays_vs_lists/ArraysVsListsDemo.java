package pl.javaready.projects.collections.lesson04_arrays_vs_lists;

import java.util.ArrayList;
import java.util.List;

public class ArraysVsListsDemo {

    public static void main(String[] args) {
        // the array has a fixed size
        String[] array = new String[3];
//        array[0] = "PL";
//        array[1] = "DE";
//        array[2] = "FR";
        // array[3] = "GB";   // ArrayIndexOutOfBoundsException: there is no 4th place

        // the list just grows
        List<String> list = new ArrayList<>();
        list.add("PL");
        list.add("DE");
        list.add("FR");
        list.add("GB");

        System.out.println(array.length);   // 3
        System.out.println(list.size());    // 4
    }
}
