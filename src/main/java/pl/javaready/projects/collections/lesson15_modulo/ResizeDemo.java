package pl.javaready.projects.collections.lesson15_modulo;

public class ResizeDemo {

    public static void main(String[] args) {
        int[] hashes = {28, 9, 24, 24, 32};   // PL, DE, FR, ES, UK

        // when the number of buckets changes, the same hash may land in another bucket
        for (int hash : hashes) {
            System.out.println(hash + ": bucket " + hash % 8 + " (8 buckets) -> bucket " + hash % 16 + " (16 buckets)");
        }

        // a rule of thumb: the table starts small and doubles when it gets too full
        int buckets = 16;
        int elements = 13;
        if (elements > buckets * 0.75) {
            buckets = buckets * 2;   // 13 elements do not fit into 16 buckets comfortably
        }
        System.out.println("buckets: " + buckets);   // 32
    }
}
