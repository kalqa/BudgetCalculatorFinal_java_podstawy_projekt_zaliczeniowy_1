package pl.javaready.projects.collections.lesson14_hashing;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchDemo {

    public static void main(String[] args) {
        // 100 000 transfer numbers in a list
        List<Integer> transfers = new ArrayList<>();
        for (int i = 1; i <= 100_000; i++) {
            transfers.add(i);
        }

        // searching one by one: we count the steps
        System.out.println("first transfer:  " + stepsToFind(transfers, 1));           // 1
        System.out.println("middle transfer: " + stepsToFind(transfers, 50_000));      // 50 000
        System.out.println("last transfer:   " + stepsToFind(transfers, 100_000));     // 100 000

        // on average the searched transfer is somewhere in the middle: about n / 2 steps
    }

    static int stepsToFind(List<Integer> transfers, int searched) {
        int steps = 0;
        for (int transfer : transfers) {
            steps++;
            if (transfer == searched) {
                break;
            }
        }
        return steps;
    }
}
