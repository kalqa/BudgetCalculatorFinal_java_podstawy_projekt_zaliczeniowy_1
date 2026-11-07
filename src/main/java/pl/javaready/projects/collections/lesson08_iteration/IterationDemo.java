package pl.javaready.projects.collections.lesson08_iteration;

import java.util.ArrayList;
import java.util.List;

public class IterationDemo {

    public static void main(String[] args) {
        String[] array = {"PL", "DE", "FR"};

        List<String> list = new ArrayList<>(200);
        list.add("PL");
        list.add("DE");
        list.add("FR");

        // for-each: the same as you know it from arrays, only the collection is on the right
        for (String stamp : array) {
            System.out.println("array stamp: " + stamp);
        }
        for (String stamp : list) {
            System.out.println("list stamp: " + stamp);
        }

        // need the index? use the plain for loop
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ": " + array[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ": " + list.get(i));
        }

        // the array has 5 places but only 3 elements: length counts places, not elements
        String[] bigArray = new String[5];
        bigArray[0] = "PL";
        bigArray[1] = "DE";
        bigArray[2] = "FR";
        for (int i = 0; i < bigArray.length; i++) {
            System.out.println(i + ": " + bigArray[i]);   // the last two are null
        }
        // you have to watch the limit yourself: i <= bigArray.length would throw ArrayIndexOutOfBoundsException

        // size() always returns the number of elements, so the loop adjusts itself
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ": " + list.get(i));   // exactly 3 turns
        }

        // for-each also works for numbers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(8);
        numbers.add(5);

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println("sum: " + sum);   // 16
    }
}
