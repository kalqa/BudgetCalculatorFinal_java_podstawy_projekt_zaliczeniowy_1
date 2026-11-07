package pl.javaready.projects.collections.lesson26_exercise6_equals_hashcode;

import java.util.HashSet;
import java.util.Set;

public class ParcelSolution {

    public static void main(String[] args) {
        // before the fix: Parcel has no equals() and hashCode(), every object counts as different
        Set<Parcel> before = new HashSet<>();
        before.add(new Parcel("A1"));
        before.add(new Parcel("B2"));
        before.add(new Parcel("A1"));
        System.out.println(before.size());                        // 3
        System.out.println(before.contains(new Parcel("B2")));    // false

        // after the fix: ParcelFixed has equals() and hashCode() based on the code
        Set<ParcelFixed> after = new HashSet<>();
        after.add(new ParcelFixed("A1"));
        after.add(new ParcelFixed("B2"));
        after.add(new ParcelFixed("A1"));
        System.out.println(after.size());                         // 2
        System.out.println(after.contains(new ParcelFixed("B2")));  // true
    }
}
