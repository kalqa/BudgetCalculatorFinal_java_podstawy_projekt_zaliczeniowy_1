package pl.javaready.projects;

import java.util.Scanner;

public class SmartBudgetAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        displayWelcome();
        waitForEnter(scanner);
        double monthlyIncome = getMonthlyIncome(scanner);
        double fixedCosts = getFixedCosts(scanner);
        double availableBudget = calculateAvailableBudget(monthlyIncome, fixedCosts);
        displayAvailableBudget(availableBudget);
        String[] categories = getCategories(scanner);
        int howManyCategories = categories.length;
        double[] amounts = collectCategoriesAmounts(howManyCategories, categories, scanner);
        double totalExpenses = calculateTotalExpenses(amounts);
        displayTotalExpenses(totalExpenses);
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getMenuChoice(scanner);
            if (choice == 1) {
                showMonthlyReport(totalExpenses, howManyCategories, availableBudget, amounts, categories);
            } else if (choice == 2) {
                show8020Analysis(availableBudget, howManyCategories, amounts, totalExpenses, categories, scanner);
            } else if (choice == 3) {
                setSavingsGoal(scanner, categories, amounts, availableBudget, totalExpenses);
            } else if (choice == 4) {
                running = false;
                displayGoodbye();
            }
        }
    }

    public static void displayGoodbye() {
        System.out.println("");
        System.out.println("Dziękujemy za korzystanie z Smart Budget Analyzer!");
        System.out.println("Pamiętaj: Małe zmiany dzisiaj = duże oszczędności jutro!");
        System.out.println("Do zobaczenia!");
    }

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
        if (areCutsNeeded(neededFromCuts)) {
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
        double categoryPercentage = calculatePercentage(amount, totalExpenses);
        double cutAmount = (categoryPercentage / 100.0) * neededFromCuts;
        double newBudget = calculateNewBudgetForCategory(amount, cutAmount);
        System.out.println("- " + categoryName + ": obetnij " + roundToTwoDecimals(cutAmount) + " PLN -> nowy budżet: " + roundToTwoDecimals(newBudget) + " PLN");
    }

    private static double calculateNewBudgetForCategory(double amount, double cutAmount) {
        return amount - cutAmount;
    }

    public static void displaySavingsPlan(double extraIncome, double monthlyTarget, double currentSurplus, double coveredByExtraIncome, double neededFromCuts) {
        if (hasExtraIncome(extraIncome)) {
            displayExtraIncomeInfo(coveredByExtraIncome, monthlyTarget);
        }
        if (areCutsNeeded(neededFromCuts)) {
            displayCutsInfo(neededFromCuts, monthlyTarget, currentSurplus, coveredByExtraIncome);
        } else {
            displayNoExtraCutsNeeded(currentSurplus, coveredByExtraIncome, monthlyTarget);
        }
    }

    public static void displayNoExtraCutsNeeded(double currentSurplus, double coveredByExtraIncome, double monthlyTarget) {
        System.out.println("- Świetnie! Dodatkowy dochód pokrywa cel!");
        double extraSurplus = coveredByExtraIncome - monthlyTarget;
        System.out.println("- Dodatkowa nadwyżka: " + roundToTwoDecimals(currentSurplus + extraSurplus) + " PLN");
    }

    public static void displayCutsInfo(double neededFromCuts, double monthlyTarget, double currentSurplus, double coveredByExtraIncome) {
        double cutsPercentage = calculatePercentage(neededFromCuts, monthlyTarget);
        System.out.println("- Musisz obciąć wydatki o: " + roundToTwoDecimals(neededFromCuts) + " PLN (" + roundToTwoDecimals(cutsPercentage) + "%)");
        double newSurplus = currentSurplus - neededFromCuts + coveredByExtraIncome;
        if (isSurplus(newSurplus)) {
            System.out.println("- Nadwyżka po: " + roundToTwoDecimals(newSurplus) + " PLN");
        } else {
            System.out.println("- UWAGA: Deficyt " + roundToTwoDecimals(Math.abs(newSurplus)) + " PLN");
        }
    }

    public static boolean isSurplus(double value) {
        return value >= 0;
    }

    public static boolean areCutsNeeded(double neededFromCuts) {
        return neededFromCuts > 0;
    }

    public static void displayExtraIncomeInfo(double coveredByExtraIncome, double monthlyTarget) {
        double extraIncomePercentage = calculatePercentage(coveredByExtraIncome, monthlyTarget);
        System.out.println("- Dodatkowy dochód pokrywa: " + roundToTwoDecimals(coveredByExtraIncome) + " PLN (" + roundToTwoDecimals(extraIncomePercentage) + "%)");
    }

    public static boolean hasExtraIncome(double extraIncome) {
        return extraIncome > 0;
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
        System.out.println("Obecna miesięczna nadwyżka: " + roundToTwoDecimals(currentSurplus) + " PLN");
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
        System.out.println("Miesięczny cel: " + roundToTwoDecimals(monthlyTarget) + " PLN");
        System.out.println("");
    }

    private static double calculateMonthlySavingTarget(double remaining, int months) {
        return remaining / months;
    }

    private static double calculateRemaining(double totalCost, double existingSavings) {
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
        if (hasExtraIncomeAnswer(answer)) {
            return getExtraIncome(scanner);
        }
        return 0.0;
    }

    public static double getExtraIncome(Scanner scanner) {
        System.out.println("");
        System.out.println("Realistyczny dodatkowy dochód miesięcznie:");
        double income = scanner.nextDouble();
        clearBuffer(scanner);
        return income;
    }

    public static boolean hasExtraIncomeAnswer(String answer) {
        return answer.equalsIgnoreCase("tak");
    }

    public static double getExistingSavingsIfAny(Scanner scanner) {
        System.out.println("");
        System.out.println("Czy masz już jakieś oszczędności na ten cel? (tak/nie)");
        String answer = scanner.nextLine();
        if (hasExistingSavingsAnswer(answer)) {
            return getExistingSavings(scanner);
        }
        return 0.0;
    }

    public static double getExistingSavings(Scanner scanner) {
        System.out.println("");
        System.out.println("Ile?");
        double savings = scanner.nextDouble();
        clearBuffer(scanner);
        return savings;
    }

    public static boolean hasExistingSavingsAnswer(String answer) {
        return answer.equalsIgnoreCase("tak");
    }

    public static int getValidMonths(Scanner scanner) {
        System.out.println("");
        System.out.println("W ile miesięcy chcesz to osiągnąć?");
        int months = scanner.nextInt();
        clearBuffer(scanner);
        while (isNumberInvalid(months)) {
            System.out.println("Liczba miesięcy musi być większa od 0. Spróbuj ponownie:");
            months = scanner.nextInt();
            clearBuffer(scanner);
        }
        return months;
    }

    public static double getSavingsGoalCost(Scanner scanner) {
        System.out.println("");
        System.out.println("Ile to kosztuje?");
        double cost = scanner.nextDouble();
        clearBuffer(scanner);
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

    private static void show8020Analysis(double availableBudget, int howManyCategories, double[] amounts, double totalExpenses, String[] categories, Scanner scanner) {
        display8020Header();
        double healthyLevel = calculateHealthyLevel(availableBudget, howManyCategories);
        int[] topCategories = calculateTopCategories(amounts, totalExpenses);
        double topCategoriesSum = calculateSumByIndices(amounts, topCategories);
        double topPercentage = calculatePercentage(topCategoriesSum, totalExpenses);
        displayTopCategoriesIntro(topPercentage);
        displayTopCategoriesAnalysis(amounts, totalExpenses, categories, topCategories, healthyLevel);
        displayFocusRecommendation(categories[topCategories[0]]);
        boolean wantDetails = askForDetailedBreakdown(scanner);
        if (wantDetails) {
            handleDetailedBreakdown(scanner, categories, amounts);
        }
        displayReportFooter();
    }

    public static void handleDetailedBreakdown(Scanner scanner, String[] categories, double[] amounts) {
        displayEnterCategoryPrompt();
        String categoryName = scanner.nextLine();
        int categoryIndex = findCategoryIndex(categories, categoryName);
        if (isCategoryFound(categoryIndex)) {
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
        if (canReduceUsage(reducedTimes, timesUsed)) {
            double savings = calculateReduceTimesSaving(timesUsed, averageCost, reducedTimes);
            double yearlySavings = calculateYearlySavings(savings);
            displaySavingsPotential(yearlySavings, savings, reducedTimes);
        }
    }

    public static void displaySavingsPotential(double yearlySavings, double savings, int reducedTimes) {
        System.out.println("Jeśli zmniejszysz do " + reducedTimes + " razy/miesiąc -> zaoszczędzisz " + roundToTwoDecimals(savings) + " PLN");
        System.out.println("To " + roundToTwoDecimals(yearlySavings) + " PLN oszczędności rocznie!");
    }

    private static double calculateReduceTimesSaving(int timesUsed, double averageCost, int reducedTimes) {
        return averageCost * (timesUsed - reducedTimes);
    }

    private static double calculateYearlySavings(double savings) {
        int monthsInYear = 12;
        return savings * monthsInYear;
    }

    public static boolean canReduceUsage(int reducedTimes, int currentTimes) {
        return reducedTimes < currentTimes;
    }

    public static void displayAverageCost(double averageCost) {
        System.out.println("");
        System.out.println("Średni koszt na użycie: " + roundToTwoDecimals(averageCost) + " PLN");
        System.out.println("");
        System.out.println("SUGESTIA:");
    }

    public static boolean isTimesUsedPositive(int times) {
        return times > 0;
    }

    public static int getTimesUsed(Scanner scanner) {
        System.out.println("Ile razy korzystałeś z tej kategorii w ostatnim miesiącu?");
        int timesUsed = scanner.nextInt();
        clearBuffer(scanner);
        return timesUsed;
    }

    public static void displayDetailedCategoryHeader(String categoryName, double amount) {
        System.out.println("");
        System.out.println("=== SZCZEGÓŁY: " + categoryName + " ===");
        System.out.println("Obecne wydatki: " + amount + " PLN");
        System.out.println("");
    }

    public static boolean isCategoryFound(int index) {
        return index != -1;
    }

    public static int findCategoryIndex(String[] categories, String categoryName) {
        for (int i = 0; i < categories.length; i++) {
            if (doesCategoryMatch(categories[i], categoryName)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean doesCategoryMatch(String category, String searchName) {
        return category.equalsIgnoreCase(searchName);
    }

    public static void displayEnterCategoryPrompt() {
        System.out.println("");
        System.out.println("Podaj nazwę kategorii:");
    }

    public static boolean askForDetailedBreakdown(Scanner scanner) {
        System.out.println("Chcesz szczegółowy podział kategorii? (tak/nie)");
        String answer = scanner.nextLine();
        return wantsDetailedBreakdown(answer);
    }

    public static boolean wantsDetailedBreakdown(String answer) {
        return answer.equalsIgnoreCase("tak");
    }

    private static void displayTopCategoriesAnalysis(double[] amounts, double totalExpenses, String[] categories, int[] topCategories, double healthyLevel) {
        int howManyTopIndices = topCategories.length;
        for (int i = 0; i < howManyTopIndices; i++) {
            calculateAndDisplaySingleTopCategory(amounts, topCategories, i, totalExpenses, healthyLevel, categories);
        }
    }

    private static void calculateAndDisplaySingleTopCategory(double[] amounts, int[] topCategories, int i, double totalExpenses, double healthyLevel, String[] categories) {
        int categoryIndex = topCategories[i];
        double amountIndex = amounts[categoryIndex];
        double percentage = calculatePercentage(amountIndex, totalExpenses);
        double aboveHealthy = howMuchAboveHealthy(healthyLevel, amountIndex);
        double cutPercentage = 0.20;
        double savingsIfCut20 = amountIndex * cutPercentage;
        int monthsInYear = 12;
        double yearlySavings = savingsIfCut20 * monthsInYear;
        displayTopCategoryDetails(i, categories[categoryIndex], amountIndex, percentage, aboveHealthy, savingsIfCut20, yearlySavings);
    }

    public static void displayTopCategoryDetails(int position, String categoryName, double amount, double percentage, double aboveHealthy, double monthlySavings, double yearlySavings) {
        System.out.println((position + 1) + ". " + categoryName + ": " + amount + " PLN (" + roundToTwoDecimals(percentage) + "%)");
        System.out.println("   - " + roundToTwoDecimals(aboveHealthy) + " PLN powyżej zdrowego poziomu");
        System.out.println("   - Obcięcie o 20% -> oszczędność " + roundToTwoDecimals(monthlySavings) + " PLN/miesiąc (" + roundToTwoDecimals(yearlySavings) + " PLN/rok)");
        System.out.println("");
    }

    private static double howMuchAboveHealthy(double healthyLevel, double amount) {
        double aboveHealthy = amount - healthyLevel;
        if (aboveHealthy < 0) {
            aboveHealthy = 0;
        }
        return aboveHealthy;
    }

    public static void displayTopCategoriesIntro(double topPercentage) {
        System.out.println("Te kategorie pochłaniają " + roundToTwoDecimals(topPercentage) + "% Twojego budżetu:");
        System.out.println("");
    }

    public static double calculateSumByIndices(double[] amounts, int[] indices) {
        double sum = 0.0;
        for (int i = 0; i < indices.length; i++) {
            sum += amounts[indices[i]];
        }
        return sum;
    }

    private static int[] calculateTopCategories(double[] amounts, double totalExpenses) {
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

    private static int limitToMaxThreeHighesExpensiveCategories(int topCount) {
        if (topCount > 3) {
            topCount = 3;
        }
        return topCount;
    }

    private static int accumulateToHaveAroundEightPercentOfExpenses(int[] sortedIndices, double[] amounts, double totalExpenses) {
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

    private static int[] sortDescendingExpensesForCategories(double[] amounts) {
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

    private static void showMonthlyReport(double totalExpenses, int howManyCategories, double availableBudget, double[] amounts, String[] categories) {
        displayReportHeader();
        double averageExpense = calculateAverageExpense(totalExpenses, howManyCategories);
        displayReportSummary(totalExpenses, averageExpense, availableBudget);
        displayCategoryBreakdown(howManyCategories, amounts, totalExpenses, categories);
        String category = findMaxCategoryName(amounts, categories);
        double healthyLevel = calculateHealthyLevel(availableBudget, howManyCategories);
        int categoriesAboveHealthyLevel = countCategoriesAboveHealthyLevel(amounts, healthyLevel);
        String budgetStatus = determineBudgetStatus(totalExpenses, availableBudget);
        displayReportStatistics(category, healthyLevel, categoriesAboveHealthyLevel, budgetStatus);
        displayReportFooter();
    }

    public static String determineBudgetStatus(double expenses, double budget) {
        double percentage = calculatePercentage(expenses, budget);
        if (isLowSpending(percentage)) {
            return "Niskie wydatki - świetne oszczędności!";
        } else if (isModerateSpending(percentage)) {
            return "Umiarkowane wydatki - w ramach budżetu.";
        } else {
            return "Wysokie wydatki - przekroczono budżet!";
        }
    }

    public static boolean isModerateSpending(double percentage) {
        double budgetLimit = 100;
        return percentage <= budgetLimit;
    }

    public static boolean isLowSpending(double percentage) {
        double lowSpendingThreshold = 70;
        return percentage < lowSpendingThreshold;
    }

    public static void displayReportStatistics(String maxCategoryName, double healthyLevel, int categoriesAboveHealthy, String budgetStatus) {
        System.out.println("");
        System.out.println("Kategoria z najwyższym wydatkiem: " + maxCategoryName);
        System.out.println("Kategorie powyżej zdrowego poziomu (" + roundToTwoDecimals(healthyLevel) + " PLN): " + categoriesAboveHealthy);
        System.out.println("");
        System.out.println("Status budżetu: " + budgetStatus);
    }

    private static int countCategoriesAboveHealthyLevel(double[] amounts, double healthyLevel) {
        int count = 0;
        int howManyAmounts = amounts.length;
        for (int i = 0; i < howManyAmounts; i++) {
            if (isAmountAboveHealthyLevel(amounts[i], healthyLevel)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isAmountAboveHealthyLevel(double amount, double level) {
        return amount > level;
    }

    private static double calculateHealthyLevel(double availableBudget, int howManyCategories) {
        return availableBudget / howManyCategories;
    }

    private static String findMaxCategoryName(double[] amounts, String[] categories) {
        int maxIndex = findMaxAmountIndex(amounts);
        return categories[maxIndex];
    }

    private static int findMaxAmountIndex(double[] amounts) {
        int maxIndex = 0;
        double maxValue = amounts[0];
        int howManyAmounts = amounts.length;
        for (int i = 1; i < howManyAmounts; i++) {
            if (isCurrentAmountGreater(amounts[i], maxValue)) {
                maxValue = amounts[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static boolean isCurrentAmountGreater(double current, double max) {
        return current > max;
    }

    private static void displayCategoryBreakdown(int howManyCategories, double[] amounts, double totalExpenses, String[] categories) {
        for (int i = 0; i < howManyCategories; i++) {
            ;
            displaySingleCategoryBreakdown(amounts[i], totalExpenses, categories[i]);
        }
    }

    private static void displaySingleCategoryBreakdown(double amount, double totalExpenses, String categoryName) {
        double percentage = calculatePercentage(amount, totalExpenses);
        System.out.println("- " + categoryName + ": " + amount + " PLN (" + roundToTwoDecimals(percentage) + "%)");
    }

    private static double calculatePercentage(double part, double whole) {
        if (isWholeZero(whole)) {
            return 0.0;
        }
        double percentageMultiplier = 100.0;
        return (part / whole) * percentageMultiplier;
    }

    public static boolean isWholeZero(double whole) {
        return whole == 0;
    }

    public static void displayReportSummary(double totalExpenses, double averageExpense, double budget) {
        System.out.println("Suma wydatków: " + totalExpenses + " PLN");
        System.out.println("Średni wydatek: " + roundToTwoDecimals(averageExpense) + " PLN");
        System.out.println("Dostępny budżet: " + budget + " PLN");
        System.out.println("");
        System.out.println("Podział na kategorie:");
    }

    public static double roundToTwoDecimals(double value) {
        double decimalPlaces = 100.0;
        return Math.round(value * decimalPlaces) / decimalPlaces;
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

    public static int getMenuChoice(Scanner scanner) {
        int choice = scanner.nextInt();
        clearBuffer(scanner);
        return choice;
    }

    public static void displayMenu() {
        System.out.println("");
        System.out.println("=== MENU GŁÓWNE ===");
        System.out.println("1. Pokaż raport miesięczny");
        System.out.println("2. Analiza 80/20");
        System.out.println("3. Ustaw cel oszczędnościowy");
        System.out.println("4. Zakończ");
        System.out.println("");
        System.out.println("Wybierz opcję:");
    }

    public static void displayTotalExpenses(double total) {
        System.out.println("Suma wydatków: " + total + " PLN");
    }

    public static double calculateTotalExpenses(double[] amounts) {
        double total = 0.0;
        int howManyAmounts = amounts.length;
        for (int i = 0; i < howManyAmounts; i++) {
            total += amounts[i];
        }
        return total;
    }

    private static double[] collectCategoriesAmounts(int howManyCategories, String[] categories, Scanner scanner) {
        double[] amounts = new double[howManyCategories];
        for (int i = 0; i < howManyCategories; i++) {
            System.out.println("Podaj kwotę wydaną na \"" + categories[i] + "\" w ostatnim miesiącu:");
            double amount = scanner.nextDouble();
            clearBuffer(scanner);
            while (isCostNegative(amount)) {
                System.out.println("Kwota nie może być ujemna. Spróbuj ponownie:");
                amount = scanner.nextDouble();
                clearBuffer(scanner);
            }
            amounts[i] = amount;
            System.out.println("");
        }
        return amounts;
    }

    private static String[] getCategories(Scanner scanner) {
        int numberOfCategories = getNumberOfCategories(scanner);
        String[] categories = collectCategories(scanner, numberOfCategories);
        return categories;
    }

    private static String[] collectCategories(Scanner scanner, int numberOfCategories) {
        String[] categories = new String[numberOfCategories];
        for (int i = 0; i < numberOfCategories; i++) {
            System.out.println("Podaj nazwę kategorii #" + (i + 1) + ":");
            categories[i] = scanner.nextLine();
        }
        return categories;
    }

    private static int getNumberOfCategories(Scanner scanner) {
        displayCategoriesPrompt();
        int number = scanner.nextInt();
        clearBuffer(scanner);
        while (isNumberInvalid(number)) {
            System.out.println("Liczba musi być większa od 0. Spróbuj ponownie:");
            number = scanner.nextInt();
            clearBuffer(scanner);
        }
        return number;
    }

    public static boolean isNumberInvalid(int number) {
        return number <= 0;
    }

    public static void displayCategoriesPrompt() {
        System.out.println("");
        System.out.println("Ile kategorii wydatków chcesz śledzić?");
    }

    public static void displayAvailableBudget(double budget) {
        System.out.println("");
        System.out.println("Dostępne na elastyczne wydatki: " + budget + " PLN");
    }

    private static double calculateAvailableBudget(double monthlyIncome, double fixedCosts) {
        return monthlyIncome - fixedCosts;
    }

    private static double getFixedCosts(Scanner scanner) {
        displayFixedCostsPrompt();
        String answer = scanner.nextLine();
        if (hasFixedCostsAnswer(answer)) {
            return getFixedCostsAmount(scanner);
        }
        return 0.0;
    }

    private static double getFixedCostsAmount(Scanner scanner) {
        displayEnterFixedCostsPrompt();
        double costs = scanner.nextDouble();
        clearBuffer(scanner);
        while (isCostNegative(costs)) {
            System.out.println("Koszty stałe nie mogą być ujemne. Spróbuj ponownie:");
            costs = scanner.nextDouble();
            clearBuffer(scanner);
        }
        return costs;
    }

    public static boolean isCostNegative(double cost) {
        return cost < 0;
    }

    public static void displayEnterFixedCostsPrompt() {
        System.out.println("");
        System.out.println("Podaj sumę kosztów stałych:");
    }

    private static boolean hasFixedCostsAnswer(String answer) {
        return answer.equalsIgnoreCase("tak");
    }

    public static void displayFixedCostsPrompt() {
        System.out.println("");
        System.out.println("Czy masz stałe miesięczne koszty? (czynsz, kredyt, ubezpieczenie) tak/nie");
    }

    private static double getMonthlyIncome(Scanner scanner) {
        displayIncomePrompt();
        double income = scanner.nextDouble();
        clearBuffer(scanner);
        while (isIncomeInvalid(income)) {
            System.out.println("Dochód musi być większy od 0. Spróbuj ponownie:");
            income = scanner.nextDouble();
            clearBuffer(scanner);
        }
        return income;
    }

    public static boolean isIncomeInvalid(double income) {
        return income <= 0;
    }

    public static void displayWelcome() {
        System.out.println("=== SMART BUDGET ANALYZER ===");
        System.out.println("To narzędzie pomoże Ci przeanalizować Twoje RZECZYWISTE wydatki.");
        System.out.println("");
        System.out.println("WSKAZÓWKA: Przygotuj wyciąg bankowy!");
        System.out.println("Naciśnij ENTER, gdy będziesz gotowy...");
    }

    public static void waitForEnter(Scanner scanner) {
        scanner.nextLine();
    }

    public static void displayIncomePrompt() {
        System.out.println("");
        System.out.println("Podaj swój miesięczny dochód NETTO (po podatkach):");
    }

    public static void clearBuffer(Scanner scanner) {
        scanner.nextLine();
    }

}