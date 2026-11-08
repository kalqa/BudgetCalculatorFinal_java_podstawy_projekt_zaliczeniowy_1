package pl.javaready.projects;

// Jeden cel oszczednosciowy. W oryginale to 7 lokalnych zmiennych w
// setSavingsGoal(), ktore zawsze podrozowaly razem z metody do metody -
// klasyczny sygnal, ze to powinien byc jeden obiekt, nie kilka zmiennych.
public class SavingsGoal {

    private final String name;
    private final double totalCost;
    private final int months;
    private final double existingSavings;
    private final double extraIncome;

    private final double remaining;
    private final double monthlyTarget;
    private final double coveredByExtraIncome;
    private final double neededFromCuts;

    public SavingsGoal(String name, double totalCost, int months, double existingSavings, double extraIncome) {
        this.name = name;
        this.totalCost = totalCost;
        this.months = months;
        this.existingSavings = existingSavings;
        this.extraIncome = extraIncome;

        this.remaining = calculateRemaining();
        this.monthlyTarget = remaining / months;
        this.coveredByExtraIncome = calculateCoveredByExtraIncome();
        this.neededFromCuts = monthlyTarget - coveredByExtraIncome;
    }

    private double calculateRemaining() {
        double value = totalCost - existingSavings;
        if (value < 0) {
            return 0;
        }
        return value;
    }

    private double calculateCoveredByExtraIncome() {
        if (extraIncome < monthlyTarget) {
            return extraIncome;
        }
        return monthlyTarget;
    }

    public boolean hasExtraIncome() {
        return extraIncome > 0;
    }

    public boolean needsCuts() {
        return neededFromCuts > 0;
    }

    public String getName() {
        return name;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public int getMonths() {
        return months;
    }

    public double getExistingSavings() {
        return existingSavings;
    }

    public double getExtraIncome() {
        return extraIncome;
    }

    public double getRemaining() {
        return remaining;
    }

    public double getMonthlyTarget() {
        return monthlyTarget;
    }

    public double getCoveredByExtraIncome() {
        return coveredByExtraIncome;
    }

    public double getNeededFromCuts() {
        return neededFromCuts;
    }
}
