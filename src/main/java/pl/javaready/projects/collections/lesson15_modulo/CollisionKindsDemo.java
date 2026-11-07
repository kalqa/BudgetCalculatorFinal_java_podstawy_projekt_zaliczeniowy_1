package pl.javaready.projects.collections.lesson15_modulo;

public class CollisionKindsDemo {

    // the sum of the letter numbers (A = 1, B = 2, ...)
    static int hash(String key) {
        int sum = 0;
        for (char letter : key.toCharArray()) {
            sum += letter - 'A' + 1;
        }
        return sum;
    }

    static void compare(String first, String second, int buckets) {
        int hashFirst = hash(first);
        int hashSecond = hash(second);
        System.out.println(first + " (" + hashFirst + ") and " + second + " (" + hashSecond + "), buckets: " + buckets);
        System.out.println("  same hash:   " + (hashFirst == hashSecond));
        System.out.println("  same bucket: " + (hashFirst % buckets == hashSecond % buckets));
    }

    public static void main(String[] args) {
        // a hash collision: the same hash, so surely the same bucket
        compare("FR", "ES", 10);   // 24 and 24

        // a bucket collision: different hashes, but the same bucket after the modulo
        compare("DE", "AR", 10);   // 9 and 19 -> both in bucket 9

        // with another number of buckets they may part
        compare("DE", "AR", 7);    // 9 % 7 = 2, 19 % 7 = 5
    }
}
