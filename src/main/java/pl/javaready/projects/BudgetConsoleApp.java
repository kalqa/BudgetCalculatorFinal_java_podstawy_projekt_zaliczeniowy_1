package pl.javaready.projects;

// BudgetConsoleApp dyryguje ruchem: zbiera dane na starcie, prowadzi
// menu w petli, woli ExpenseTracker/Budget o liczenie i BudgetPrinter
// o wypisywanie. Budget i tracker NIE moga byc final - dostaja wartosc
// dopiero w run(), nie w konstruktorze - ale nadal sa private.
public class BudgetConsoleApp {

    private final ConsoleInput input;
    private final BudgetPrinter printer;

    private Budget budget;
    private ExpenseTracker tracker;

    public BudgetConsoleApp(ConsoleInput input, BudgetPrinter printer) {
        this.input = input;
        this.printer = printer;
    }

    public void run() {
        printIntro();
        budget = gatherBudget();
        tracker = gatherExpenses();

        System.out.println("Suma wydatków: " + tracker.getTotalExpenses() + " PLN");

        boolean running = true;
        while (running) {
            printer.printMenu();
            int choice = input.readNumber();

            if (choice == 1) {
                printer.printMonthlyReport(budget, tracker);
            } else if (choice == 2) {
                handle8020Analysis();
            } else if (choice == 3) {
                handleSavingsGoal();
            } else if (choice == 4) {
                running = false;
                printGoodbye();
            }
        }

        input.close();
    }

    private void printIntro() {
        System.out.println("=== SMART BUDGET ANALYZER ===");
        System.out.println("To narzędzie pomoże Ci przeanalizować Twoje RZECZYWISTE wydatki.");
        System.out.println();
        System.out.println("WSKAZÓWKA: Przygotuj wyciąg bankowy!");
        System.out.println("Naciśnij ENTER, gdy będziesz gotowy...");
        input.readLine();
    }

    private void printGoodbye() {
        System.out.println();
        System.out.println("Dziękujemy za korzystanie z Smart Budget Analyzer!");
        System.out.println("Pamiętaj: Małe zmiany dzisiaj = duże oszczędności jutro!");
        System.out.println("Do zobaczenia!");
    }

    // ===== ZBIERANIE BUDŻETU =====

    private Budget gatherBudget() {
        double monthlyIncome = gatherMonthlyIncome();
        double fixedCosts = gatherFixedCosts();
        Budget result = new Budget(monthlyIncome, fixedCosts);

        System.out.println();
        System.out.println("Dostępne na elastyczne wydatki: " + result.getAvailableBudget() + " PLN");
        return result;
    }

    private double gatherMonthlyIncome() {
        System.out.println();
        System.out.println("Podaj swój miesięczny dochód NETTO (po podatkach):");
        double income = input.readDouble();
        while (income <= 0) {
            System.out.println("Dochód musi być większy od 0. Spróbuj ponownie:");
            income = input.readDouble();
        }
        return income;
    }

    private double gatherFixedCosts() {
        System.out.println();
        System.out.println("Czy masz stałe miesięczne koszty? (czynsz, kredyt, ubezpieczenie) tak/nie");
        String answer = input.readLine();
        if (!answer.equalsIgnoreCase("tak")) {
            return 0.0;
        }

        System.out.println();
        System.out.println("Podaj sumę kosztów stałych:");
        double costs = input.readDouble();
        while (costs < 0) {
            System.out.println("Koszty stałe nie mogą być ujemne. Spróbuj ponownie:");
            costs = input.readDouble();
        }
        return costs;
    }

    // ===== ZBIERANIE KATEGORII =====

    private ExpenseTracker gatherExpenses() {
        String[] names = gatherCategoryNames();
        ExpenseCategory[] categories = gatherCategoryAmounts(names);
        return new ExpenseTracker(categories);
    }

    private String[] gatherCategoryNames() {
        int count = gatherCategoryCount();
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Podaj nazwę kategorii #" + (i + 1) + ":");
            names[i] = input.readLine();
        }
        return names;
    }

    private int gatherCategoryCount() {
        System.out.println();
        System.out.println("Ile kategorii wydatków chcesz śledzić?");
        int count = input.readNumber();
        while (count <= 0) {
            System.out.println("Liczba musi być większa od 0. Spróbuj ponownie:");
            count = input.readNumber();
        }
        return count;
    }

    private ExpenseCategory[] gatherCategoryAmounts(String[] names) {
        ExpenseCategory[] categories = new ExpenseCategory[names.length];
        for (int i = 0; i < names.length; i++) {
            System.out.println("Podaj kwotę wydaną na \"" + names[i] + "\" w ostatnim miesiącu:");
            double amount = input.readDouble();
            while (amount < 0) {
                System.out.println("Kwota nie może być ujemna. Spróbuj ponownie:");
                amount = input.readDouble();
            }
            categories[i] = new ExpenseCategory(names[i], amount);
            System.out.println();
        }
        return categories;
    }

    // ===== ANALIZA 80/20 =====

    private void handle8020Analysis() {
        ExpenseCategory[] topCategories = tracker.findTopCategories();
        printer.print8020Report(tracker, budget, topCategories);

        System.out.println("Chcesz szczegółowy podział kategorii? (tak/nie)");
        String answer = input.readLine();
        if (answer.equalsIgnoreCase("tak")) {
            handleDetailedBreakdown();
        }
        printer.printReportFooter();
    }

    private void handleDetailedBreakdown() {
        System.out.println();
        System.out.println("Podaj nazwę kategorii:");
        String name = input.readLine();

        ExpenseCategory category = tracker.findCategoryByName(name);
        if (category == null) {
            printer.printCategoryNotFound();
            return;
        }

        printer.printDetailedCategoryHeader(category);
        System.out.println("Ile razy korzystałeś z tej kategorii w ostatnim miesiącu?");
        int timesUsed = input.readNumber();
        if (timesUsed > 0) {
            printer.printDetailedSuggestion(category, timesUsed);
        }
    }

    // ===== CEL OSZCZĘDNOŚCIOWY =====

    private void handleSavingsGoal() {
        System.out.println();
        System.out.println("=== USTAW CEL OSZCZĘDNOŚCIOWY ===");
        System.out.println();

        System.out.println("Na co chcesz oszczędzać?");
        String goalName = input.readLine();

        System.out.println();
        System.out.println("Ile to kosztuje?");
        double totalCost = input.readDouble();

        int months = gatherValidMonths();
        double existingSavings = gatherExistingSavings();
        double extraIncome = gatherExtraIncome();

        SavingsGoal goal = new SavingsGoal(goalName, totalCost, months, existingSavings, extraIncome);
        double currentSurplus = budget.getAvailableBudget() - tracker.getTotalExpenses();

        printer.printSavingsGoalReport(goal, currentSurplus, tracker);
    }

    private int gatherValidMonths() {
        System.out.println();
        System.out.println("W ile miesięcy chcesz to osiągnąć?");
        int months = input.readNumber();
        while (months <= 0) {
            System.out.println("Liczba miesięcy musi być większa od 0. Spróbuj ponownie:");
            months = input.readNumber();
        }
        return months;
    }

    private double gatherExistingSavings() {
        System.out.println();
        System.out.println("Czy masz już jakieś oszczędności na ten cel? (tak/nie)");
        String answer = input.readLine();
        if (!answer.equalsIgnoreCase("tak")) {
            return 0.0;
        }

        System.out.println();
        System.out.println("Ile?");
        return input.readDouble();
    }

    private double gatherExtraIncome() {
        System.out.println();
        System.out.println("Czy możesz dodać dodatkowy dochód? (zlecenia, nadgodziny) (tak/nie)");
        String answer = input.readLine();
        if (!answer.equalsIgnoreCase("tak")) {
            return 0.0;
        }

        System.out.println();
        System.out.println("Realistyczny dodatkowy dochód miesięcznie:");
        return input.readDouble();
    }
}
