package pl.javaready.projects.collections.lesson15_modulo;

public class ModuloDemo {

    public static void main(String[] args) {
        // % is the remainder of a division
        System.out.println(28 % 10);   // 8, because 28 = 2 * 10 + 8
        System.out.println(9 % 10);    // 9, because 9 = 0 * 10 + 9
        System.out.println(30 % 10);   // 0, because 30 = 3 * 10 + 0

        // you already use it every day: the days of the week repeat every 7 days
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int today = 0;   // Monday
        System.out.println(days[(today + 10) % 7]);   // Thursday, 10 days from now

        // a closed cycle: after the last place we are back at the first one
        int size = 5;
        int index = 3;
        for (int step = 0; step < 4; step++) {
            System.out.print(index + " ");   // 3 4 0 1
            index = (index + 1) % size;
        }
        System.out.println();

        // a letter with number 127 goes to one of 10 pigeonholes
        System.out.println(127 % 10);   // 7

        // the result is always between 0 and (divisor - 1)
        // so any number can be turned into a valid bucket number
        int[] hashes = {28, 9, 24, 24, 32};   // PL, DE, FR, ES, UK

        for (int buckets : new int[]{4, 5, 10}) {
            System.out.println("buckets: " + buckets);
            for (int hash : hashes) {
                System.out.println("  " + hash + " % " + buckets + " = " + hash % buckets);
            }
        }

        // a hand-made hash table: the keys are put into buckets by key % buckets
        int[] keys = {12, 7, 22, 9, 17, 14};
        for (int buckets : new int[]{5, 11}) {
            System.out.println("buckets: " + buckets);
            for (int key : keys) {
                System.out.println("  " + key + " % " + buckets + " = " + key % buckets);
            }
        }
    }
}
