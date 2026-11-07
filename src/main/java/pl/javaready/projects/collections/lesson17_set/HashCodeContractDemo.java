package pl.javaready.projects.collections.lesson17_set;

import java.util.HashSet;
import java.util.Set;

public class HashCodeContractDemo {

    public static void main(String[] args) {
        // equals() without hashCode(): the HashSet still lets two equal objects in
        Set<User> without = new HashSet<>();
        User ann = new User("ann");
        without.add(ann);
        User ann1 = new User("ann");
        without.add(ann1);
        System.out.println(ann.equals(ann1));

        System.out.println("without hashCode: " + without.size());   // 2

        // equals() together with hashCode(): only one stays
        Set<UserWithHashCode> with = new HashSet<>();
        with.add(new UserWithHashCode("ann"));
        with.add(new UserWithHashCode("ann"));
        System.out.println("with hashCode:    " + with.size());      // 1
    }
}
