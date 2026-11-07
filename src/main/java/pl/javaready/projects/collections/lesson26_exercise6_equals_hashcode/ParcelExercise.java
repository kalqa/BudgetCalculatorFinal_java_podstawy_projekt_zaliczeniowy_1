package pl.javaready.projects.collections.lesson26_exercise6_equals_hashcode;

import java.util.HashSet;
import java.util.Set;

public class ParcelExercise {

    public static void main(String[] args) {
        Set<Parcel> parcels = new HashSet<>();
        parcels.add(new Parcel("A1"));
        parcels.add(new Parcel("B2"));
        parcels.add(new Parcel("A1"));

        // TODO 1: print parcels.size(); the code "A1" was added twice, so what do you expect and what do you get?
        // TODO 2: fix the Parcel class (see the TODO inside it), run the program again and compare
        // TODO 3: print parcels.contains(new Parcel("B2")) before and after the fix
    }
}
