package pl.javaready.projects.collections.lesson02_under_the_hood;

import java.util.ArrayList;
import java.util.List;

public class UnderTheHoodDemo {

    public static void main(String[] args) {
        // you only call add() and size(), the ArrayList handles the rest
        List<String> stamps = new ArrayList<>();
        stamps.add("PL");
        stamps.add("DE");
        stamps.add("GB");
        stamps.add("GB");
        stamps.add("GB");
        stamps.add("GB");
        stamps.add("GB");
        stamps.add("GB");
        stamps.add("GB");
        stamps.add("GB");
        stamps.add("GB");
        stamps.add("GB");

        // inside there is a plain array, but you do not have to think about it
        System.out.println(stamps.size());   // 2
    }
}
