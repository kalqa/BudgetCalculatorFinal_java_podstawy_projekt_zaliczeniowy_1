package pl.javaready.projects.collections.lesson03_collection_is_object;

import java.util.ArrayList;
import java.util.List;

public class StampListDemo {

    public static void main(String[] args) {
        // the variable holds a reference, the ArrayList is an object with data and methods
        List<String> stamps = new ArrayList<>();

        stamps.add("PL");
        stamps.add("DE");
        stamps.add("FR");
        System.out.println(stamps.size());   // 3
        System.out.println(stamps.get(0));   // PL

        stamps.set(0, "GB");                 // replace the element at index 0
        stamps.add(1, "IT");                 // insert at index 1, the rest shifts right
        stamps.remove(0);                    // remove index 0, the rest shifts left
        System.out.println(stamps);          // [IT, DE, FR]
        boolean czyZawieraIT = stamps.contains("IT");
        if(czyZawieraIT){
            //
        } else {
            stamps.add("IT");
        }
    }
}
