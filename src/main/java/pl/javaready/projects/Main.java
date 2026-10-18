package pl.javaready.projects;

import java.util.Scanner;

// Main ma JEDNA robote: stworzyc obiekty i je ze soba polaczyc.
// Zero logiki, zero czytania wejscia.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleInput input = new ConsoleInput(scanner);
        RatingPrinter printer = new RatingPrinter();
        FoodRaterConsoleApp app = new FoodRaterConsoleApp(input, printer);

        app.run();
    }
}
