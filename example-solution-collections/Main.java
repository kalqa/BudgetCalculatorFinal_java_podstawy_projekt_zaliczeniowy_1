package pl.javaready.projects;

import java.util.Scanner;

// Main ma JEDNA robote: stworzyc obiekty i je ze soba polaczyc.
// Zero logiki, zero czytania wejscia - to wszystko robi BudgetConsoleApp.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleInput input = new ConsoleInput(scanner);
        BudgetPrinter printer = new BudgetPrinter();
        BudgetConsoleApp app = new BudgetConsoleApp(input, printer);

        app.run();
    }
}
