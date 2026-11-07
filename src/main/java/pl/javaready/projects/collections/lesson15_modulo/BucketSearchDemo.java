package pl.javaready.projects.collections.lesson15_modulo;

import java.util.ArrayList;
import java.util.List;

public class BucketSearchDemo {

    // the sum of the letter numbers (A = 1, B = 2, ...)
    static int hash(String key) {
        int sum = 0;
        for (char letter : key.toCharArray()) {
            sum += letter - 'A' + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] keys = {"PL", "DE", "FR", "ES", "UK", "IT", "NL", "BE", "SE", "NO",
                "FI", "DK", "PT", "AT", "CZ", "SK", "HU", "GR", "IE", "CH"};

        for (int buckets : new int[]{1, 5, 20}) {
            // put every key into its bucket: hash % buckets
            List<List<String>> table = new ArrayList<>();
            for (int i = 0; i < buckets; i++) {
                table.add(new ArrayList<>());
            }
            for (String key : keys) {
                table.get(hash(key) % buckets).add(key);
            }

            System.out.println("buckets: " + buckets);
            for (String searched : new String[]{"CH", "BR"}) {   // BR is not in the table
                int bucket = hash(searched) % buckets;           // step 2: modulo
                int steps = 2;                                   // step 1: hash, step 2: modulo
                boolean found = false;
                for (String existing : table.get(bucket)) {      // look only into one bucket
                    steps++;
                    if (existing.equals(searched)) {
                        found = true;
                        break;
                    }
                }
                System.out.println("  " + searched + ": bucket " + bucket + ", steps " + steps + ", found " + found);
            }
        }
    }
}
