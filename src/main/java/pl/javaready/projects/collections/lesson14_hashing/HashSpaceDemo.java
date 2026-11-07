package pl.javaready.projects.collections.lesson14_hashing;

public class HashSpaceDemo {

    public static void main(String[] args) {
        // hashCode() returns an int: about 4.3 billion possible values
        long possibleHashes = 1L << 32;
        System.out.println("possible hashes: " + possibleHashes);   // 4294967296

        // one place for every possible hash, roughly 8 bytes each
        long bytes = possibleHashes * 8;
        System.out.println("memory: " + bytes / (1024 * 1024 * 1024) + " GB");   // 32 GB, even for 10 elements

        // so a hash alone is not enough to choose a place: we need a second step that
        // squeezes the huge range of hashes into a small number of buckets (next lesson)
        System.out.println("PL".hashCode());   // 2556
        System.out.println("PL".hashCode() == "PL".hashCode());   // true: the rule never changes
    }
}
