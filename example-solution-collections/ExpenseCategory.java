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

    // Nazwa w jednej, ujednoliconej postaci (male litery). Na niej opiera sie
    // equals(), hashCode() i klucz w mapie ExpenseTracker, wiec "Jedzenie"
    // i "jedzenie" to dla programu ta sama kategoria.
    public String getNameKey() {
        return name.toLowerCase();
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

    // Dwie kategorie sa "takie same", jesli maja te sama nazwe (bez roznicy
    // wielkosci liter). Teraz, gdy znamy hashowanie, nadpisujemy tez hashCode():
    // rowne obiekty MUSZA miec ten sam hash, inaczej HashSet i HashMap sie pogubia.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpenseCategory other)) return false;
        return getNameKey().equals(other.getNameKey());
    }

    @Override
    public int hashCode() {
        return getNameKey().hashCode();
    }

    @Override
    public String toString() {
        return name + ": " + amount + " PLN";
    }
}
