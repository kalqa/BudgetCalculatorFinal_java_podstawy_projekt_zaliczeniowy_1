package pl.javaready.projects.collections.lesson14_hashing;

public class HashingDemo {

    public static void main(String[] args) {
        // hashing: a text goes in, a number comes out
        // PL = P(16) + L(12) = 28
        String[] countries = {"PL", "DE", "FR", "ES", "UK", "ELA", "ALE"};
        for (String country : countries) {
            System.out.println(country + " -> " + ToyHash.hash(country));
        }

        // the same text always gives the same number
        System.out.println(ToyHash.hash("PL") == ToyHash.hash("PL"));   // true

        // different texts may give the same number (FR and ES): this is a collision
        System.out.println(ToyHash.hash("FR") + " " + ToyHash.hash("ES"));   // 24 24

        // two different people (Ela and Ale) with the same hash: the number alone does not tell who is who
        System.out.println(ToyHash.hash("ELA") + " " + ToyHash.hash("ALE"));   // 18 18
    }
}
