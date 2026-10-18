package pl.javaready.projects;

// BudgetPrinter ma JEDNA odpowiedzialnosc: wypisywac duze, wieloliniowe
// raporty na ekran. Nie wie, jak dane sa zbierane (to robota
// BudgetConsoleApp) ani jak sie je liczy (to robota ExpenseTracker/
// Budget/SavingsGoal) - dostaje gotowe obiekty i tylko je formatuje.
public class BudgetPrinter {

    public void printMenu() {
        System.out.println();
        System.out.println("=== MENU GŁÓWNE ===");
        System.out.println("1. Pokaż raport miesięczny");
        System.out.println("2. Analiza 80/20");
        System.out.println("3. Ustaw cel oszczędnościowy");
        System.out.println("4. Zakończ");
        System.out.println();
        System.out.println("Wybierz opcję:");
    }

    public void printMonthlyReport(Budget budget, ExpenseTracker tracker) {
        printReportHeader();

        double totalExpenses = tracker.getTotalExpenses();
        double averageExpense = tracker.getAverageExpense();
        printReportSummary(totalExpenses, averageExpense, budget.getAvailableBudget());
        printCategoryBreakdown(tracker, totalExpenses);

        ExpenseCategory maxCategory = tracker.findCategoryWithHighestExpense();
        double healthyLevel = tracker.getHealthyLevel(budget.getAvailableBudget());
        int categoriesAboveHealthy = tracker.countCategoriesAboveHealthyLevel(healthyLevel);
        String status = budget.determineStatus(totalExpenses);

        printReportStatistics(maxCategory.getName(), healthyLevel, categoriesAboveHealthy, status);
        printReportFooter();
    }

    private void printReportHeader() {
        System.out.println();
        System.out.println("=== RAPORT MIESIĘCZNY ===");
    }

    private void printReportSummary(double totalExpenses, double averageExpense, double availableBudget) {
        System.out.println("Suma wydatków: " + totalExpenses + " PLN");
        System.out.println("Średni wydatek: " + MathUtils.round(averageExpense) + " PLN");
        System.out.println("Dostępny budżet: " + availableBudget + " PLN");
        System.out.println();
        System.out.println("Podział na kategorie:");
    }

    private void printCategoryBreakdown(ExpenseTracker tracker, double totalExpenses) {
        ExpenseCategory[] categories = tracker.getCategories();
        for (int i = 0; i < categories.length; i++) {
            double percentage = MathUtils.percentage(categories[i].getAmount(), totalExpenses);
            System.out.println("- " + categories[i].getName() + ": " + categories[i].getAmount()
                    + " PLN (" + MathUtils.round(percentage) + "%)");
        }
    }

    private void printReportStatistics(String maxCategoryName, double healthyLevel, int categoriesAboveHealthy, String status) {
        System.out.println();
        System.out.println("Kategoria z najwyższym wydatkiem: " + maxCategoryName);
        System.out.println("Kategorie powyżej zdrowego poziomu (" + MathUtils.round(healthyLevel) + " PLN): " + categoriesAboveHealthy);
        System.out.println();
        System.out.println("Status budżetu: " + status);
    }

    public void print8020Report(ExpenseTracker tracker, Budget budget, ExpenseCategory[] topCategories) {
        System.out.println();
        System.out.println("=== ANALIZA 80/20 ===");

        double totalExpenses = tracker.getTotalExpenses();
        double topSum = tracker.sumAmounts(topCategories);
        double topPercentage = MathUtils.percentage(topSum, totalExpenses);
        System.out.println("Te kategorie pochłaniają " + MathUtils.round(topPercentage) + "% Twojego budżetu:");
        System.out.println();

        double healthyLevel = tracker.getHealthyLevel(budget.getAvailableBudget());
        for (int i = 0; i < topCategories.length; i++) {
            printTopCategoryDetails(i, topCategories[i], totalExpenses, healthyLevel, tracker);
        }

        System.out.println("SKUP SIĘ NA: " + topCategories[0].getName() + " - największa szansa na oszczędności!");
        System.out.println();
    }

    private void printTopCategoryDetails(int position, ExpenseCategory category, double totalExpenses, double healthyLevel, ExpenseTracker tracker) {
        double percentage = MathUtils.percentage(category.getAmount(), totalExpenses);
        double aboveHealthy = tracker.howMuchAboveHealthy(healthyLevel, category);
        double monthlySavings = tracker.calculateMonthlySavingsFor20PercentCut(category);
        double yearlySavings = tracker.calculateYearlySavingsFor20PercentCut(category);

        System.out.println((position + 1) + ". " + category.getName() + ": " + category.getAmount()
                + " PLN (" + MathUtils.round(percentage) + "%)");
        System.out.println("   - " + MathUtils.round(aboveHealthy) + " PLN powyżej zdrowego poziomu");
        System.out.println("   - Obcięcie o 20% -> oszczędność " + MathUtils.round(monthlySavings)
                + " PLN/miesiąc (" + MathUtils.round(yearlySavings) + " PLN/rok)");
        System.out.println();
    }

    public void printCategoryNotFound() {
        System.out.println("Nie znaleziono kategorii.");
    }

    public void printDetailedCategoryHeader(ExpenseCategory category) {
        System.out.println();
        System.out.println("=== SZCZEGÓŁY: " + category.getName() + " ===");
        System.out.println("Obecne wydatki: " + category.getAmount() + " PLN");
        System.out.println();
    }

    public void printDetailedSuggestion(ExpenseCategory category, int timesUsed) {
        double averageCost = category.averageCostPerUse(timesUsed);
        System.out.println();
        System.out.println("Średni koszt na użycie: " + MathUtils.round(averageCost) + " PLN");
        System.out.println();
        System.out.println("SUGESTIA:");

        int reducedTimes = category.reducedUsageCount(timesUsed);
        if (reducedTimes < timesUsed) {
            double savings = category.monthlySavingsFromReducedUsage(timesUsed);
            double yearlySavings = category.yearlySavingsFromReducedUsage(timesUsed);
            System.out.println("Jeśli zmniejszysz do " + reducedTimes + " razy/miesiąc -> zaoszczędzisz " + MathUtils.round(savings) + " PLN");
            System.out.println("To " + MathUtils.round(yearlySavings) + " PLN oszczędności rocznie!");
        }
    }

    public void printSavingsGoalReport(SavingsGoal goal, double currentSurplus, ExpenseTracker tracker) {
        printGoalAnalysis(goal);
        printCurrentSurplus(currentSurplus);
        printSavingsPlan(goal, currentSurplus);
        if (goal.needsCuts()) {
            printSuggestedCuts(tracker, goal.getNeededFromCuts());
        }
        printGoalCompletion(goal.getMonths());
    }

    private void printGoalAnalysis(SavingsGoal goal) {
        System.out.println();
        System.out.println("=== ANALIZA CELU ===");
        System.out.println("CEL: " + goal.getName());
        System.out.println("Całkowity koszt: " + goal.getTotalCost() + " PLN");
        System.out.println("Już zaoszczędzone: " + goal.getExistingSavings() + " PLN");
        System.out.println("Pozostało: " + goal.getRemaining() + " PLN");
        System.out.println("Miesięczny cel: " + MathUtils.round(goal.getMonthlyTarget()) + " PLN");
        System.out.println();
    }

    private void printCurrentSurplus(double currentSurplus) {
        System.out.println("Obecna miesięczna nadwyżka: " + MathUtils.round(currentSurplus) + " PLN");
        System.out.println();
        System.out.println("PLAN:");
    }

    private void printSavingsPlan(SavingsGoal goal, double currentSurplus) {
        if (goal.hasExtraIncome()) {
            double percentage = MathUtils.percentage(goal.getCoveredByExtraIncome(), goal.getMonthlyTarget());
            System.out.println("- Dodatkowy dochód pokrywa: " + MathUtils.round(goal.getCoveredByExtraIncome())
                    + " PLN (" + MathUtils.round(percentage) + "%)");
        }
        if (goal.needsCuts()) {
            double cutsPercentage = MathUtils.percentage(goal.getNeededFromCuts(), goal.getMonthlyTarget());
            System.out.println("- Musisz obciąć wydatki o: " + MathUtils.round(goal.getNeededFromCuts())
                    + " PLN (" + MathUtils.round(cutsPercentage) + "%)");
            double newSurplus = currentSurplus - goal.getNeededFromCuts() + goal.getCoveredByExtraIncome();
            if (newSurplus >= 0) {
                System.out.println("- Nadwyżka po: " + MathUtils.round(newSurplus) + " PLN");
            } else {
                System.out.println("- UWAGA: Deficyt " + MathUtils.round(Math.abs(newSurplus)) + " PLN");
            }
        } else {
            System.out.println("- Świetnie! Dodatkowy dochód pokrywa cel!");
            double extraSurplus = goal.getCoveredByExtraIncome() - goal.getMonthlyTarget();
            System.out.println("- Dodatkowa nadwyżka: " + MathUtils.round(currentSurplus + extraSurplus) + " PLN");
        }
    }

    private void printSuggestedCuts(ExpenseTracker tracker, double neededFromCuts) {
        System.out.println();
        System.out.println("PROPONOWANE CIĘCIA:");
        ExpenseCategory[] categories = tracker.getCategories();
        for (int i = 0; i < categories.length; i++) {
            double cutAmount = tracker.calculateCutAmount(categories[i], neededFromCuts);
            double newBudget = categories[i].getAmount() - cutAmount;
            System.out.println("- " + categories[i].getName() + ": obetnij " + MathUtils.round(cutAmount)
                    + " PLN -> nowy budżet: " + MathUtils.round(newBudget) + " PLN");
        }
    }

    private void printGoalCompletion(int months) {
        System.out.println();
        System.out.println("Osiągniesz swój cel za " + months + " miesięcy!");
        System.out.println("======================");
    }

    public void printReportFooter() {
        System.out.println("======================");
    }
}
