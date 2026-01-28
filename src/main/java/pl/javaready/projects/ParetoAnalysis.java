package pl.javaready.projects;

import java.util.Scanner;

public class ParetoAnalysis {

    public static void show8020Analysis(double availableBudget, int howManyCategories, double[] amounts, double totalExpenses, String[] categories, Scanner scanner) {
        display8020Header();
        double healthyLevel = BudgetMath.calculateHealthyLevel(availableBudget, howManyCategories);
        int[] topCategories = calculateTopCategories(amounts, totalExpenses);
        double topCategoriesSum = calculateSumByIndices(amounts, topCategories);
        double topPercentage = BudgetMath.calculatePercentage(topCategoriesSum, totalExpenses);
        displayTopCategoriesIntro(topPercentage);
        displayTopCategoriesAnalysis(amounts, totalExpenses, categories, topCategories, healthyLevel);
        displayFocusRecommendation(categories[topCategories[0]]);
        boolean wantDetails = askForDetailedBreakdown(scanner);
        if (wantDetails) {
            handleDetailedBreakdown(scanner, categories, amounts);
        }
        MonthlyReport.displayReportFooter();
    }

    public static void handleDetailedBreakdown(Scanner scanner, String[] categories, double[] amounts) {
        displayEnterCategoryPrompt();
        String categoryName = scanner.nextLine();
        int categoryIndex = findCategoryIndex(categories, categoryName);
        if (BudgetRules.isCategoryFound(categoryIndex)) {
            String foundCategoryName = categories[categoryIndex];
            showDetailedCategoryAnalysis(scanner, foundCategoryName, amounts[categoryIndex]);
        } else {
            System.out.println("Nie znaleziono kategorii.");
        }
    }

    public static void showDetailedCategoryAnalysis(Scanner scanner, String categoryName, double amount) {
        displayDetailedCategoryHeader(categoryName, amount);
        int timesUsed = getTimesUsed(scanner);
        if (isTimesUsedPositive(timesUsed)) {
            displayDetailedSuggestion(amount, timesUsed);
        }
    }

    public static void displayDetailedSuggestion(double amount, int timesUsed) {
        double averageCost = amount / timesUsed;
        displayAverageCost(averageCost);
        double reductionTarget = 0.67;
        int reducedTimes = (int) (timesUsed * reductionTarget);
        if (BudgetRules.canReduceUsage(reducedTimes, timesUsed)) {
            double savings = calculateReduceTimesSaving(timesUsed, averageCost, reducedTimes);
            double yearlySavings = calculateYearlySavings(savings);
            displaySavingsPotential(yearlySavings, savings, reducedTimes);
        }
    }

    public static void displaySavingsPotential(double yearlySavings, double savings, int reducedTimes) {
        System.out.println("Jeśli zmniejszysz do " + reducedTimes + " razy/miesiąc -> zaoszczędzisz " + BudgetMath.roundToTwoDecimals(savings) + " PLN");
        System.out.println("To " + BudgetMath.roundToTwoDecimals(yearlySavings) + " PLN oszczędności rocznie!");
    }

    public static double calculateReduceTimesSaving(int timesUsed, double averageCost, int reducedTimes) {
        return averageCost * (timesUsed - reducedTimes);
    }

    public static double calculateYearlySavings(double savings) {
        int monthsInYear = 12;
        return savings * monthsInYear;
    }

    public static void displayAverageCost(double averageCost) {
        System.out.println("");
        System.out.println("Średni koszt na użycie: " + BudgetMath.roundToTwoDecimals(averageCost) + " PLN");
        System.out.println("");
        System.out.println("SUGESTIA:");
    }

    public static boolean isTimesUsedPositive(int times) {
        return times > 0;
    }

    public static int getTimesUsed(Scanner scanner) {
        System.out.println("Ile razy korzystałeś z tej kategorii w ostatnim miesiącu?");
        int timesUsed = scanner.nextInt();
        ConsoleInput.clearBuffer(scanner);
        return timesUsed;
    }

    public static void displayDetailedCategoryHeader(String categoryName, double amount) {
        System.out.println("");
        System.out.println("=== SZCZEGÓŁY: " + categoryName + " ===");
        System.out.println("Obecne wydatki: " + amount + " PLN");
        System.out.println("");
    }

    public static int findCategoryIndex(String[] categories, String categoryName) {
        for (int i = 0; i < categories.length; i++) {
            if (BudgetRules.doesCategoryMatch(categories[i], categoryName)) {
                return i;
            }
        }
        return -1;
    }

    public static void displayEnterCategoryPrompt() {
        System.out.println("");
        System.out.println("Podaj nazwę kategorii:");
    }

    public static boolean askForDetailedBreakdown(Scanner scanner) {
        System.out.println("Chcesz szczegółowy podział kategorii? (tak/nie)");
        String answer = scanner.nextLine();
        return BudgetRules.wantsDetailedBreakdown(answer);
    }

    public static void displayTopCategoriesAnalysis(double[] amounts, double totalExpenses, String[] categories, int[] topCategories, double healthyLevel) {
        int howManyTopIndices = topCategories.length;
        for (int i = 0; i < howManyTopIndices; i++) {
            calculateAndDisplaySingleTopCategory(amounts, topCategories, i, totalExpenses, healthyLevel, categories);
        }
    }

    public static void calculateAndDisplaySingleTopCategory(double[] amounts, int[] topCategories, int i, double totalExpenses, double healthyLevel, String[] categories) {
        int categoryIndex = topCategories[i];
        double amountIndex = amounts[categoryIndex];
        double percentage = BudgetMath.calculatePercentage(amountIndex, totalExpenses);
        double aboveHealthy = howMuchAboveHealthy(healthyLevel, amountIndex);
        double cutPercentage = 0.20;
        double savingsIfCut20 = amountIndex * cutPercentage;
        int monthsInYear = 12;
        double yearlySavings = savingsIfCut20 * monthsInYear;
        displayTopCategoryDetails(i, categories[categoryIndex], amountIndex, percentage, aboveHealthy, savingsIfCut20, yearlySavings);
    }

    public static void displayTopCategoryDetails(int position, String categoryName, double amount, double percentage, double aboveHealthy, double monthlySavings, double yearlySavings) {
        System.out.println((position + 1) + ". " + categoryName + ": " + amount + " PLN (" + BudgetMath.roundToTwoDecimals(percentage) + "%)");
        System.out.println("   - " + BudgetMath.roundToTwoDecimals(aboveHealthy) + " PLN powyżej zdrowego poziomu");
        System.out.println("   - Obcięcie o 20% -> oszczędność " + BudgetMath.roundToTwoDecimals(monthlySavings) + " PLN/miesiąc (" + BudgetMath.roundToTwoDecimals(yearlySavings) + " PLN/rok)");
        System.out.println("");
    }

    public static double howMuchAboveHealthy(double healthyLevel, double amount) {
        double aboveHealthy = amount - healthyLevel;
        if (aboveHealthy < 0) {
            aboveHealthy = 0;
        }
        return aboveHealthy;
    }

    public static void displayTopCategoriesIntro(double topPercentage) {
        System.out.println("Te kategorie pochłaniają " + BudgetMath.roundToTwoDecimals(topPercentage) + "% Twojego budżetu:");
        System.out.println("");
    }

    public static double calculateSumByIndices(double[] amounts, int[] indices) {
        double sum = 0.0;
        for (int i = 0; i < indices.length; i++) {
            sum += amounts[indices[i]];
        }
        return sum;
    }

    public static int[] calculateTopCategories(double[] amounts, double totalExpenses) {
        int[] sortedIndices = sortDescendingExpensesForCategories(amounts);
        int topCount = accumulateToHaveAroundEightPercentOfExpenses(sortedIndices, amounts, totalExpenses);
        int topCountLimited = limitToMaxThreeHighesExpensiveCategories(topCount);
        int[] topCategories = new int[topCount];
        for (int i = 0; i < topCountLimited; i++) {
            topCategories[i] = sortedIndices[i];
        }
        return topCategories;
    }

    public static void displayFocusRecommendation(String categoryName) {
        System.out.println("SKUP SIĘ NA: " + categoryName + " - największa szansa na oszczędności!");
        System.out.println("");
    }

    public static int limitToMaxThreeHighesExpensiveCategories(int topCount) {
        if (topCount > 3) {
            topCount = 3;
        }
        return topCount;
    }

    public static int accumulateToHaveAroundEightPercentOfExpenses(int[] sortedIndices, double[] amounts, double totalExpenses) {
        int topCount = 0;
        double sum = 0;
        double eightPrecentHighestExpenses = 0.8;
        for (int i = 0; i < sortedIndices.length; i++) {
            if (amounts[sortedIndices[i]] > 0) {
                sum += amounts[sortedIndices[i]];
                topCount++;
            }
            if (sum >= totalExpenses * eightPrecentHighestExpenses) {
                break;
            }
        }
        return topCount;
    }

    public static int[] sortDescendingExpensesForCategories(double[] amounts) {
        int[] sortedIndices = new int[amounts.length];
        for (int i = 0; i < sortedIndices.length; i++) {
            sortedIndices[i] = i;
        }
        for (int i = 0; i < sortedIndices.length - 1; i++) {
            for (int j = i + 1; j < sortedIndices.length; j++) {
                if (amounts[sortedIndices[j]] > amounts[sortedIndices[i]]) {
                    int temp = sortedIndices[i];
                    sortedIndices[i] = sortedIndices[j];
                    sortedIndices[j] = temp;
                }
            }
        }
        return sortedIndices;
    }

    public static void display8020Header() {
        System.out.println("");
        System.out.println("=== ANALIZA 80/20 ===");
    }
}