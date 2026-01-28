package pl.javaready.projects;

public class BudgetMath {

    public static double roundToTwoDecimals(double value) {
        double decimalPlaces = 100.0;
        return Math.round(value * decimalPlaces) / decimalPlaces;
    }

    public static double calculatePercentage(double part, double whole) {
        if (whole == 0) {
            return 0.0;
        }
        double percentageMultiplier = 100.0;
        return (part / whole) * percentageMultiplier;
    }

    public static double calculateHealthyLevel(double availableBudget, int howManyCategories) {
        return availableBudget / howManyCategories;
    }

    public static double calculateAvailableBudget(double monthlyIncome, double fixedCosts) {
        return monthlyIncome - fixedCosts;
    }

    public static double calculateTotalExpenses(double[] amounts) {
        double total = 0.0;
        int howManyAmounts = amounts.length;
        for (int i = 0; i < howManyAmounts; i++) {
            total += amounts[i];
        }
        return total;
    }
}
