package pl.javaready.projects;

import java.util.Scanner;

public class UserInput {

    public static double getMonthlyIncome(Scanner scanner) {
        ConsoleView.displayIncomePrompt();
        double income = scanner.nextDouble();
        ConsoleInput.clearBuffer(scanner);
        while (BudgetRules.isIncomeInvalid(income)) {
            System.out.println("Dochód musi być większy od 0. Spróbuj ponownie:");
            income = scanner.nextDouble();
            ConsoleInput.clearBuffer(scanner);
        }
        return income;
    }

    public static double getFixedCosts(Scanner scanner) {
        ConsoleView.displayFixedCostsPrompt();
        String answer = scanner.nextLine();
        if (BudgetRules.hasFixedCostsAnswer(answer)) {
            return getFixedCostsAmount(scanner);
        }
        return 0.0;
    }

    public static double getFixedCostsAmount(Scanner scanner) {
        ConsoleView.displayEnterFixedCostsPrompt();
        double costs = scanner.nextDouble();
        ConsoleInput.clearBuffer(scanner);
        while (BudgetRules.isCostNegative(costs)) {
            System.out.println("Koszty stałe nie mogą być ujemne. Spróbuj ponownie:");
            costs = scanner.nextDouble();
            ConsoleInput.clearBuffer(scanner);
        }
        return costs;
    }

    public static String[] getCategories(Scanner scanner) {
        int numberOfCategories = getNumberOfCategories(scanner);
        String[] categories = collectCategories(scanner, numberOfCategories);
        return categories;
    }

    public static String[] collectCategories(Scanner scanner, int numberOfCategories) {
        String[] categories = new String[numberOfCategories];
        for (int i = 0; i < numberOfCategories; i++) {
            System.out.println("Podaj nazwę kategorii #" + (i + 1) + ":");
            categories[i] = scanner.nextLine();
        }
        return categories;
    }

    public static int getNumberOfCategories(Scanner scanner) {
        ConsoleView.displayCategoriesPrompt();
        int number = scanner.nextInt();
        ConsoleInput.clearBuffer(scanner);
        while (BudgetRules.isNumberInvalid(number)) {
            System.out.println("Liczba musi być większa od 0. Spróbuj ponownie:");
            number = scanner.nextInt();
            ConsoleInput.clearBuffer(scanner);
        }
        return number;
    }

    public static double[] collectCategoriesAmounts(int howManyCategories, String[] categories, Scanner scanner) {
        double[] amounts = new double[howManyCategories];
        for (int i = 0; i < howManyCategories; i++) {
            System.out.println("Podaj kwotę wydaną na \"" + categories[i] + "\" w ostatnim miesiącu:");
            double amount = scanner.nextDouble();
            ConsoleInput.clearBuffer(scanner);
            while (BudgetRules.isCostNegative(amount)) {
                System.out.println("Kwota nie może być ujemna. Spróbuj ponownie:");
                amount = scanner.nextDouble();
                ConsoleInput.clearBuffer(scanner);
            }
            amounts[i] = amount;
            System.out.println("");
        }
        return amounts;
    }
}