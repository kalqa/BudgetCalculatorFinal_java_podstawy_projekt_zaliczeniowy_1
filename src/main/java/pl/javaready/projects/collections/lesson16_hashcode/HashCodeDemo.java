package pl.javaready.projects.collections.lesson16_hashcode;

public class HashCodeDemo {

    public static void main(String[] args) {
        // every object in Java has hashCode(): it returns an int (4 bytes), and we get it for free
        // String and Integer already have a ready one
        {
            int hash = "PL".hashCode();
            System.out.println(hash);   // 2556
            Integer i = Integer.valueOf(42);
            System.out.println(i.hashCode());   // 42
            System.out.println("DE".hashCode());   // 2177
            int i1 = "PL".hashCode();
            int i2 = "PL".hashCode();
            System.out.println(i1 == i2);   // true
        }

       {
            // User has equals() but no hashCode(): equal users get different numbers
            User first = new User("Ania");
            User second = new User("Ania");
            System.out.println(first.equals(second));                       // true
            System.out.println(first.hashCode() == second.hashCode());      // false (the numbers differ on every run)
        }

        {// UserWithHashCode: equal users get the same number
            UserWithHashCode a = new UserWithHashCode("ann");
            UserWithHashCode b = new UserWithHashCode("ann");
            System.out.println(a.equals(b));                        // true
            System.out.println(a.hashCode() + " " + b.hashCode());  // 96768 96768
        }
    }
}
