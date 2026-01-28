package pl.javaready.projects;

public class MonthlyReport {

    public static void showMonthlyReport(double totalExpenses, int howManyCategories, double availableBudget, double[] amounts, String[] categories) {
        displayReportHeader();
        double averageExpense = calculateAverageExpense(totalExpenses, howManyCategories);
        displayReportSummary(totalExpenses, averageExpense, availableBudget);
        displayCategoryBreakdown(howManyCategories, amounts, totalExpenses, categories);
        String category = findMaxCategoryName(amounts, categories);
        double healthyLevel = BudgetMath.calculateHealthyLevel(availableBudget, howManyCategories);
        int categoriesAboveHealthyLevel = countCategoriesAboveHealthyLevel(amounts, healthyLevel);
        String budgetStatus = determineBudgetStatus(totalExpenses, availableBudget);
        displayReportStatistics(category, healthyLevel, categoriesAboveHealthyLevel, budgetStatus);
        displayReportFooter();
    }

    public static String determineBudgetStatus(double expenses, double budget) {
        double percentage = BudgetMath.calculatePercentage(expenses, budget);
        if (BudgetRules.isLowSpending(percentage)) {
            return "Niskie wydatki - świetne oszczędności!";
        } else if (BudgetRules.isModerateSpending(percentage)) {
            return "Umiarkowane wydatki - w ramach budżetu.";
        } else {
            return "Wysokie wydatki - przekroczono budżet!";
        }
    }

    public static void displayReportStatistics(String maxCategoryName, double healthyLevel, int categoriesAboveHealthy, String budgetStatus) {
        System.out.println("");
        System.out.println("Kategoria z najwyższym wydatkiem: " + maxCategoryName);
        System.out.println("Kategorie powyżej zdrowego poziomu (" + BudgetMath.roundToTwoDecimals(healthyLevel) + " PLN): " + categoriesAboveHealthy);
        System.out.println("");
        System.out.println("Status budżetu: " + budgetStatus);
    }

    public static int countCategoriesAboveHealthyLevel(double[] amounts, double healthyLevel) {
        int count = 0;
        int howManyAmounts = amounts.length;
        for (int i = 0; i < howManyAmounts; i++) {
            if (BudgetRules.isAmountAboveHealthyLevel(amounts[i], healthyLevel)) {
                count++;
            }
        }
        return count;
    }

    public static String findMaxCategoryName(double[] amounts, String[] categories) {
        int maxIndex = findMaxAmountIndex(amounts);
        return categories[maxIndex];
    }

    public static int findMaxAmountIndex(double[] amounts) {
        int maxIndex = 0;
        double maxValue = amounts[0];
        int howManyAmounts = amounts.length;
        for (int i = 1; i < howManyAmounts; i++) {
            if (BudgetRules.isCurrentAmountGreater(amounts[i], maxValue)) {
                maxValue = amounts[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void displayCategoryBreakdown(int howManyCategories, double[] amounts, double totalExpenses, String[] categories) {
        for (int i = 0; i < howManyCategories; i++) {
            displaySingleCategoryBreakdown(amounts[i], totalExpenses, categories[i]);
        }
    }

    public static void displaySingleCategoryBreakdown(double amount, double totalExpenses, String categoryName) {
        double percentage = BudgetMath.calculatePercentage(amount, totalExpenses);
        System.out.println("- " + categoryName + ": " + amount + " PLN (" + BudgetMath.roundToTwoDecimals(percentage) + "%)");
    }

    public static double calculateAverageExpense(double totalExpenses, int numberOfCategories) {
        return totalExpenses / numberOfCategories;
    }

    public static void displayReportHeader() {
        System.out.println("");
        System.out.println("=== RAPORT MIESIĘCZNY ===");
    }

    public static void displayReportFooter() {
        System.out.println("======================");
    }

    public static void displayReportSummary(double totalExpenses, double averageExpense, double budget) {
        System.out.println("Suma wydatków: " + totalExpenses + " PLN");
        System.out.println("Średni wydatek: " + BudgetMath.roundToTwoDecimals(averageExpense) + " PLN");
        System.out.println("Dostępny budżet: " + budget + " PLN");
        System.out.println("");
        System.out.println("Podział na kategorie:");
    }
}