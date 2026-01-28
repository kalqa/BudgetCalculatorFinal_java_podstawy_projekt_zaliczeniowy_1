package pl.javaready.projects;

import java.util.Scanner;

public class SavingsGoal {

    public static void setSavingsGoal(Scanner scanner, String[] categories, double[] amounts, double budget, double totalExpenses) {
        displaySavingsGoalHeader();
        String goalName = getSavingsGoalName(scanner);
        double totalCost = getSavingsGoalCost(scanner);
        int months = getValidMonths(scanner);
        double existingSavings = getExistingSavingsIfAny(scanner);
        double extraIncome = getExtraIncomeIfAny(scanner);
        double remaining = calculateRemaining(totalCost, existingSavings);
        double monthlyTarget = calculateMonthlySavingTarget(remaining, months);
        displayGoalAnalysis(totalCost, existingSavings, remaining, monthlyTarget, goalName);
        double currentSurplus = calculateCurrentSurplus(budget, totalExpenses);
        displayCurrentSurplus(currentSurplus);
        double coveredByExtraIncome = calculateMonthlyTargetCoveredByExtraIncome(extraIncome, monthlyTarget);
        double neededFromCuts = calculateNeededFromCuts(monthlyTarget, coveredByExtraIncome);
        displaySavingsPlan(extraIncome, monthlyTarget, currentSurplus, coveredByExtraIncome, neededFromCuts);
        if (BudgetRules.areCutsNeeded(neededFromCuts)) {
            displaySuggestedCutsSection(categories, amounts, totalExpenses, neededFromCuts);
        }
        displayGoalCompletion(months);
    }

    public static void displayGoalCompletion(int months) {
        System.out.println("");
        System.out.println("Osiągniesz swój cel za " + months + " miesięcy!");
        System.out.println("======================");
    }

    public static void displaySuggestedCutsSection(String[] categories, double[] amounts, double totalExpenses, double neededFromCuts) {
        System.out.println("");
        System.out.println("PROPONOWANE CIĘCIA:");
        displayProportionalCuts(categories, amounts, totalExpenses, neededFromCuts);
    }

    public static void displayProportionalCuts(String[] categories, double[] amounts, double totalExpenses, double neededFromCuts) {
        int howManyCategories = categories.length;
        for (int i = 0; i < howManyCategories; i++) {
            displaySingleCategoryCut(categories[i], amounts[i], totalExpenses, neededFromCuts);
        }
    }

    public static void displaySingleCategoryCut(String categoryName, double amount, double totalExpenses, double neededFromCuts) {
        double categoryPercentage = BudgetMath.calculatePercentage(amount, totalExpenses);
        double cutAmount = (categoryPercentage / 100.0) * neededFromCuts;
        double newBudget = calculateNewBudgetForCategory(amount, cutAmount);
        System.out.println("- " + categoryName + ": obetnij " + BudgetMath.roundToTwoDecimals(cutAmount) + " PLN -> nowy budżet: " + BudgetMath.roundToTwoDecimals(newBudget) + " PLN");
    }

    public static double calculateNewBudgetForCategory(double amount, double cutAmount) {
        return amount - cutAmount;
    }

    public static void displaySavingsPlan(double extraIncome, double monthlyTarget, double currentSurplus, double coveredByExtraIncome, double neededFromCuts) {
        if (BudgetRules.hasExtraIncome(extraIncome)) {
            displayExtraIncomeInfo(coveredByExtraIncome, monthlyTarget);
        }
        if (BudgetRules.areCutsNeeded(neededFromCuts)) {
            displayCutsInfo(neededFromCuts, monthlyTarget, currentSurplus, coveredByExtraIncome);
        } else {
            displayNoExtraCutsNeeded(currentSurplus, coveredByExtraIncome, monthlyTarget);
        }
    }

    public static void displayNoExtraCutsNeeded(double currentSurplus, double coveredByExtraIncome, double monthlyTarget) {
        System.out.println("- Świetnie! Dodatkowy dochód pokrywa cel!");
        double extraSurplus = coveredByExtraIncome - monthlyTarget;
        System.out.println("- Dodatkowa nadwyżka: " + BudgetMath.roundToTwoDecimals(currentSurplus + extraSurplus) + " PLN");
    }

    public static void displayCutsInfo(double neededFromCuts, double monthlyTarget, double currentSurplus, double coveredByExtraIncome) {
        double cutsPercentage = BudgetMath.calculatePercentage(neededFromCuts, monthlyTarget);
        System.out.println("- Musisz obciąć wydatki o: " + BudgetMath.roundToTwoDecimals(neededFromCuts) + " PLN (" + BudgetMath.roundToTwoDecimals(cutsPercentage) + "%)");
        double newSurplus = currentSurplus - neededFromCuts + coveredByExtraIncome;
        if (BudgetRules.isSurplus(newSurplus)) {
            System.out.println("- Nadwyżka po: " + BudgetMath.roundToTwoDecimals(newSurplus) + " PLN");
        } else {
            System.out.println("- UWAGA: Deficyt " + BudgetMath.roundToTwoDecimals(Math.abs(newSurplus)) + " PLN");
        }
    }

    public static void displayExtraIncomeInfo(double coveredByExtraIncome, double monthlyTarget) {
        double extraIncomePercentage = BudgetMath.calculatePercentage(coveredByExtraIncome, monthlyTarget);
        System.out.println("- Dodatkowy dochód pokrywa: " + BudgetMath.roundToTwoDecimals(coveredByExtraIncome) + " PLN (" + BudgetMath.roundToTwoDecimals(extraIncomePercentage) + "%)");
    }

    public static double calculateNeededFromCuts(double monthlyTarget, double coveredByExtraIncome) {
        return monthlyTarget - coveredByExtraIncome;
    }

    public static double calculateMonthlyTargetCoveredByExtraIncome(double extraIncome, double monthlyTarget) {
        if (extraIncome < monthlyTarget) {
            return extraIncome;
        } else {
            return monthlyTarget;
        }
    }

    public static void displayCurrentSurplus(double currentSurplus) {
        System.out.println("Obecna miesięczna nadwyżka: " + BudgetMath.roundToTwoDecimals(currentSurplus) + " PLN");
        System.out.println("");
        System.out.println("PLAN:");
    }

    public static double calculateCurrentSurplus(double budget, double totalExpenses) {
        return budget - totalExpenses;
    }

    public static void displayGoalAnalysis(double totalCost, double existingSavings, double remaining, double monthlyTarget, String goalName) {
        System.out.println("");
        System.out.println("=== ANALIZA CELU ===");
        System.out.println("CEL: " + goalName);
        System.out.println("Całkowity koszt: " + totalCost + " PLN");
        System.out.println("Już zaoszczędzone: " + existingSavings + " PLN");
        System.out.println("Pozostało: " + remaining + " PLN");
        System.out.println("Miesięczny cel: " + BudgetMath.roundToTwoDecimals(monthlyTarget) + " PLN");
        System.out.println("");
    }

    public static double calculateMonthlySavingTarget(double remaining, int months) {
        return remaining / months;
    }

    public static double calculateRemaining(double totalCost, double existingSavings) {
        double remaining = totalCost - existingSavings;
        if (remaining <= 0) {
            remaining = 0;
        }
        return remaining;
    }

    public static double getExtraIncomeIfAny(Scanner scanner) {
        System.out.println("");
        System.out.println("Czy możesz dodać dodatkowy dochód? (zlecenia, nadgodziny) (tak/nie)");
        String answer = scanner.nextLine();
        if (BudgetRules.hasExtraIncomeAnswer(answer)) {
            return getExtraIncome(scanner);
        }
        return 0.0;
    }

    public static double getExtraIncome(Scanner scanner) {
        System.out.println("");
        System.out.println("Realistyczny dodatkowy dochód miesięcznie:");
        double income = scanner.nextDouble();
        ConsoleInput.clearBuffer(scanner);
        return income;
    }

    public static double getExistingSavingsIfAny(Scanner scanner) {
        System.out.println("");
        System.out.println("Czy masz już jakieś oszczędności na ten cel? (tak/nie)");
        String answer = scanner.nextLine();
        if (BudgetRules.hasExistingSavingsAnswer(answer)) {
            return getExistingSavings(scanner);
        }
        return 0.0;
    }

    public static double getExistingSavings(Scanner scanner) {
        System.out.println("");
        System.out.println("Ile?");
        double savings = scanner.nextDouble();
        ConsoleInput.clearBuffer(scanner);
        return savings;
    }

    public static int getValidMonths(Scanner scanner) {
        System.out.println("");
        System.out.println("W ile miesięcy chcesz to osiągnąć?");
        int months = scanner.nextInt();
        ConsoleInput.clearBuffer(scanner);
        while (BudgetRules.isNumberInvalid(months)) {
            System.out.println("Liczba miesięcy musi być większa od 0. Spróbuj ponownie:");
            months = scanner.nextInt();
            ConsoleInput.clearBuffer(scanner);
        }
        return months;
    }

    public static double getSavingsGoalCost(Scanner scanner) {
        System.out.println("");
        System.out.println("Ile to kosztuje?");
        double cost = scanner.nextDouble();
        ConsoleInput.clearBuffer(scanner);
        return cost;
    }

    public static String getSavingsGoalName(Scanner scanner) {
        System.out.println("Na co chcesz oszczędzać?");
        return scanner.nextLine();
    }

    public static void displaySavingsGoalHeader() {
        System.out.println("");
        System.out.println("=== USTAW CEL OSZCZĘDNOŚCIOWY ===");
        System.out.println("");
    }
}