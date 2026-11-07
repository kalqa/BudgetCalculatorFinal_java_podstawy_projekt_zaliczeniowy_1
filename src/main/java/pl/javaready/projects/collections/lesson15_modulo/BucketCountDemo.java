package pl.javaready.projects.collections.lesson15_modulo;

public class BucketCountDemo {

    public static void main(String[] args) {
        int elements = 1_000_000;

        // the search costs: one jump to the bucket + looking through the bucket (on average half of it)
        for (int buckets : new int[]{1, 10, 1_000, 100_000, 1_000_000, 10_000_000}) {
            double perBucket = (double) elements / buckets;
            double steps = 1 + perBucket / 2;
            long memory = buckets * 8L;   // roughly 8 bytes per bucket
            System.out.println("buckets: " + buckets + ", steps: " + steps + ", memory: " + memory + " B");
        }

        // too few buckets: the buckets are crowded, we search almost one by one
        // too many buckets: it is not faster any more (the cost cannot drop below 1 step), but it wastes memory
        // the sweet spot: about as many buckets as elements
    }
}
