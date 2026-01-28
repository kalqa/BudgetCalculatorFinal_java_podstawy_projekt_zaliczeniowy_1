package pl.javaready.projects;

import java.util.Scanner;

public class SmartBudgetAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleView.displayWelcome();
        ConsoleView.waitForEnter(scanner);
        double monthlyIncome = UserInput.getMonthlyIncome(scanner);
        double fixedCosts = UserInput.getFixedCosts(scanner);
        double availableBudget = BudgetMath.calculateAvailableBudget(monthlyIncome, fixedCosts);
        ConsoleView.displayAvailableBudget(availableBudget);
        String[] categories = UserInput.getCategories(scanner);
        int howManyCategories = categories.length;
        double[] amounts = UserInput.collectCategoriesAmounts(howManyCategories, categories, scanner);
        double totalExpenses = BudgetMath.calculateTotalExpenses(amounts);
        ConsoleView.displayTotalExpenses(totalExpenses);
        boolean running = true;
        while (running) {
            ConsoleView.displayMenu();
            int choice = ConsoleView.getMenuChoice(scanner);
            if (choice == 1) {
                MonthlyReport.showMonthlyReport(totalExpenses, howManyCategories, availableBudget, amounts, categories);
            } else if (choice == 2) {
                ParetoAnalysis.show8020Analysis(availableBudget, howManyCategories, amounts, totalExpenses, categories, scanner);
            } else if (choice == 3) {
                SavingsGoal.setSavingsGoal(scanner, categories, amounts, availableBudget, totalExpenses);
            } else if (choice == 4) {
                running = false;
                ConsoleView.displayGoodbye();
            }
        }
    }

}