package pl.javaready.projects;

// Jedna kategoria wydatkow - nazwa + kwota. Zastepuje dwie rownolegle
// tablice (categories[] / amounts[]) z oryginalu jedna klasa "dane
// + zachowania" (lekcja 02.01/02.03).
public class ExpenseCategory {

    private static final double USAGE_REDUCTION_TARGET = 0.67;
    private static final int MONTHS_IN_YEAR = 12;

    private final String name;
    private final double amount;

    public ExpenseCategory(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public boolean matchesName(String candidateName) {
        return name.equalsIgnoreCase(candidateName);
    }

    public double averageCostPerUse(int timesUsed) {
        return amount / timesUsed;
    }

    public int reducedUsageCount(int timesUsed) {
        return (int) (timesUsed * USAGE_REDUCTION_TARGET);
    }

    public double monthlySavingsFromReducedUsage(int timesUsed) {
        int reducedTimes = reducedUsageCount(timesUsed);
        double averageCost = averageCostPerUse(timesUsed);
        return averageCost * (timesUsed - reducedTimes);
    }

    public double yearlySavingsFromReducedUsage(int timesUsed) {
        return monthlySavingsFromReducedUsage(timesUsed) * MONTHS_IN_YEAR;
    }

    // equals() z lekcji 12.28/12.38 - dwie kategorie sa "takie same",
    // jesli maja te sama nazwe (bez rozniciu wielkosci liter). hashCode()
    // jeszcze nie nadpisujemy - to kolejna lekcja.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseCategory other = (ExpenseCategory) o;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return name + ": " + amount + " PLN";
    }
}
