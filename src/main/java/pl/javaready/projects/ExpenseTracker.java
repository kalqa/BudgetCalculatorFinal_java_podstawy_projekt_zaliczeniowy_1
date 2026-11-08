package pl.javaready.projects;

// Przechowuje kategorie wydatkow i pilnuje WSZYSTKICH obliczen, ktore
// ich dotycza - sumy, srednie, "zdrowy poziom", top kategorie 80/20.
// Zasada: ExpenseTracker nic nie wypisuje na ekran (to robota
// BudgetPrinter) - tylko liczy.
public class ExpenseTracker {

    private static final double TOP_CATEGORIES_THRESHOLD = 0.8;
    private static final int MAX_TOP_CATEGORIES = 3;
    private static final double CUT_PERCENTAGE = 0.20;
    private static final int MONTHS_IN_YEAR = 12;

    private final ExpenseCategory[] categories;

    public ExpenseTracker(ExpenseCategory[] categories) {
        this.categories = categories;
    }

    public ExpenseCategory[] getCategories() {
        return categories;
    }

    public int getCategoryCount() {
        return categories.length;
    }

    public double getTotalExpenses() {
        double total = 0.0;
        for (int i = 0; i < categories.length; i++) {
            total += categories[i].getAmount();
        }
        return total;
    }

    public double getAverageExpense() {
        return getTotalExpenses() / categories.length;
    }

    public double getHealthyLevel(double availableBudget) {
        return availableBudget / categories.length;
    }

    public int countCategoriesAboveHealthyLevel(double healthyLevel) {
        int count = 0;
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].getAmount() > healthyLevel) {
                count++;
            }
        }
        return count;
    }

    public ExpenseCategory findCategoryWithHighestExpense() {
        int maxIndex = 0;
        for (int i = 1; i < categories.length; i++) {
            if (categories[i].getAmount() > categories[maxIndex].getAmount()) {
                maxIndex = i;
            }
        }
        return categories[maxIndex];
    }

    public ExpenseCategory findCategoryByName(String name) {
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].matchesName(name)) {
                return categories[i];
            }
        }
        return null;
    }

    // Kategorie, ktore razem pochlaniaja okolo 80% wydatkow (max 3).
    // Uwaga: oryginal mial tu bocznu efekt (dziurawa tablice, gdyby
    // potrzeba bylo wiecej niz 3 kategorii) - tutaj go nie odtwarzamy,
    // zwracamy po prostu maksymalnie MAX_TOP_CATEGORIES pozycji.
    public ExpenseCategory[] findTopCategories() {
        int[] sortedIndices = sortDescendingByAmount();
        int topCount = accumulateUntilThreshold(sortedIndices);
        int limitedCount = limitToMaxTopCategories(topCount);

        ExpenseCategory[] topCategories = new ExpenseCategory[limitedCount];
        for (int i = 0; i < limitedCount; i++) {
            topCategories[i] = categories[sortedIndices[i]];
        }
        return topCategories;
    }

    public double sumAmounts(ExpenseCategory[] subset) {
        double sum = 0.0;
        for (int i = 0; i < subset.length; i++) {
            sum += subset[i].getAmount();
        }
        return sum;
    }

    public double calculateCutAmount(ExpenseCategory category, double neededFromCuts) {
        double categoryPercentage = MathUtils.percentage(category.getAmount(), getTotalExpenses());
        return (categoryPercentage / 100.0) * neededFromCuts;
    }

    public double calculateMonthlySavingsFor20PercentCut(ExpenseCategory category) {
        return category.getAmount() * CUT_PERCENTAGE;
    }

    public double calculateYearlySavingsFor20PercentCut(ExpenseCategory category) {
        return calculateMonthlySavingsFor20PercentCut(category) * MONTHS_IN_YEAR;
    }

    public double howMuchAboveHealthy(double healthyLevel, ExpenseCategory category) {
        double above = category.getAmount() - healthyLevel;
        if (above < 0) {
            return 0;
        }
        return above;
    }

    private int[] sortDescendingByAmount() {
        int[] sortedIndices = new int[categories.length];
        for (int i = 0; i < sortedIndices.length; i++) {
            sortedIndices[i] = i;
        }
        for (int i = 0; i < sortedIndices.length - 1; i++) {
            for (int j = i + 1; j < sortedIndices.length; j++) {
                if (categories[sortedIndices[j]].getAmount() > categories[sortedIndices[i]].getAmount()) {
                    int temp = sortedIndices[i];
                    sortedIndices[i] = sortedIndices[j];
                    sortedIndices[j] = temp;
                }
            }
        }
        return sortedIndices;
    }

    private int accumulateUntilThreshold(int[] sortedIndices) {
        double totalExpenses = getTotalExpenses();
        int topCount = 0;
        double sum = 0;
        for (int i = 0; i < sortedIndices.length; i++) {
            if (categories[sortedIndices[i]].getAmount() > 0) {
                sum += categories[sortedIndices[i]].getAmount();
                topCount++;
            }
            if (sum >= totalExpenses * TOP_CATEGORIES_THRESHOLD) {
                break;
            }
        }
        return topCount;
    }

    private int limitToMaxTopCategories(int topCount) {
        if (topCount > MAX_TOP_CATEGORIES) {
            return MAX_TOP_CATEGORIES;
        }
        return topCount;
    }
}
