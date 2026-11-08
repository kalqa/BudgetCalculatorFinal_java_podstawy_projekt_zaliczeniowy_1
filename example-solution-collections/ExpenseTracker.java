package pl.javaready.projects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Przechowuje kategorie wydatkow i pilnuje WSZYSTKICH obliczen, ktore
// ich dotycza - sumy, srednie, "zdrowy poziom", top kategorie 80/20.
// Zasada: ExpenseTracker nic nie wypisuje na ekran (to robota
// BudgetPrinter) - tylko liczy.
//
// Co sie zmienilo wzgledem wersji z tablica:
// - ExpenseCategory[]  ->  List<ExpenseCategory> (kolejnosc zostaje, rozmiar jest wolny)
// - szukanie po nazwie ->  Map<String, ExpenseCategory> zamiast petli po wszystkim
public class ExpenseTracker {

    private static final double TOP_CATEGORIES_THRESHOLD = 0.8;
    private static final int MAX_TOP_CATEGORIES = 3;
    private static final double CUT_PERCENTAGE = 0.20;
    private static final int MONTHS_IN_YEAR = 12;

    private final List<ExpenseCategory> categories;
    private final Map<String, ExpenseCategory> categoriesByName;

    public ExpenseTracker(List<ExpenseCategory> categories) {
        this.categories = categories;
        this.categoriesByName = new HashMap<>();
        for (ExpenseCategory category : categories) {
            categoriesByName.put(category.getNameKey(), category);
        }
    }

    // Zwracamy KOPIE listy: ktos z zewnatrz moze ja sobie zmieniac,
    // a tracker i tak zostaje nietkniety.
    public List<ExpenseCategory> getCategories() {
        return new ArrayList<>(categories);
    }

    public int getCategoryCount() {
        return categories.size();
    }

    public double getTotalExpenses() {
        double total = 0.0;
        for (ExpenseCategory category : categories) {
            total += category.getAmount();
        }
        return total;
    }

    public double getAverageExpense() {
        return getTotalExpenses() / categories.size();
    }

    public double getHealthyLevel(double availableBudget) {
        return availableBudget / categories.size();
    }

    public int countCategoriesAboveHealthyLevel(double healthyLevel) {
        int count = 0;
        for (ExpenseCategory category : categories) {
            if (category.getAmount() > healthyLevel) {
                count++;
            }
        }
        return count;
    }

    public ExpenseCategory findCategoryWithHighestExpense() {
        ExpenseCategory highest = categories.get(0);
        for (ExpenseCategory category : categories) {
            if (category.getAmount() > highest.getAmount()) {
                highest = category;
            }
        }
        return highest;
    }

    // Jedno zapytanie do mapy zamiast petli po wszystkich kategoriach.
    // Brak klucza = null, tak jak w wersji z tablica.
    public ExpenseCategory findCategoryByName(String name) {
        return categoriesByName.get(name.toLowerCase());
    }

    // Kategorie, ktore razem pochlaniaja okolo 80% wydatkow (max 3).
    public List<ExpenseCategory> findTopCategories() {
        List<ExpenseCategory> sorted = sortDescendingByAmount();
        int topCount = accumulateUntilThreshold(sorted);
        int limitedCount = limitToMaxTopCategories(topCount);

        List<ExpenseCategory> topCategories = new ArrayList<>();
        for (int i = 0; i < limitedCount; i++) {
            topCategories.add(sorted.get(i));
        }
        return topCategories;
    }

    public double sumAmounts(List<ExpenseCategory> subset) {
        double sum = 0.0;
        for (ExpenseCategory category : subset) {
            sum += category.getAmount();
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

    // Sortujemy KOPIE, zeby nie zmieniac kolejnosci kategorii w trackerze
    // (raport miesieczny ma je wypisywac tak, jak uzytkownik je podal).
    // Collections.sort tu nie pomoze: ExpenseCategory nie umie sie jeszcze
    // porownywac (to dopiero przed nami), wiec sortujemy "recznie".
    private List<ExpenseCategory> sortDescendingByAmount() {
        List<ExpenseCategory> sorted = new ArrayList<>(categories);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(j).getAmount() > sorted.get(i).getAmount()) {
                    ExpenseCategory temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }
        return sorted;
    }

    private int accumulateUntilThreshold(List<ExpenseCategory> sorted) {
        double totalExpenses = getTotalExpenses();
        int topCount = 0;
        double sum = 0;
        for (ExpenseCategory category : sorted) {
            if (category.getAmount() > 0) {
                sum += category.getAmount();
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
