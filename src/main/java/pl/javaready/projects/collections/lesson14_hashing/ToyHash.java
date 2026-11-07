package pl.javaready.projects.collections.lesson14_hashing;

// A hash function so simple that you can compute it by hand.
public class ToyHash {

    // the sum of the letter numbers (A = 1, B = 2, C = 3, ...)
    public static int hash(String text) {
        int sum = 0;
        for (char letter : text.toUpperCase().toCharArray()) {
            sum += letter - 'A' + 1;
        }
        return sum;
    }
}
