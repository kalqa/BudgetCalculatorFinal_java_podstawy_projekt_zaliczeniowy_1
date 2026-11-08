package pl.javaready.projects;

// Dochod, koszty stale i dostepny budzet jednego miesiaca. Dostepny
// budzet liczy sie raz, w konstruktorze - tak jak numer konta w
// BankAccount z poprzedniego zadania.
public class Budget {

    private static final double LOW_SPENDING_THRESHOLD = 70;
    private static final double MODERATE_SPENDING_THRESHOLD = 100;

    private final double monthlyIncome;
    private final double fixedCosts;
    private final double availableBudget;

    public Budget(double monthlyIncome, double fixedCosts) {
        this.monthlyIncome = monthlyIncome;
        this.fixedCosts = fixedCosts;
        this.availableBudget = monthlyIncome - fixedCosts;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public double getFixedCosts() {
        return fixedCosts;
    }

    public double getAvailableBudget() {
        return availableBudget;
    }

    public String determineStatus(double totalExpenses) {
        double percentage = MathUtils.percentage(totalExpenses, availableBudget);
        if (percentage < LOW_SPENDING_THRESHOLD) {
            return "Niskie wydatki - świetne oszczędności!";
        } else if (percentage <= MODERATE_SPENDING_THRESHOLD) {
            return "Umiarkowane wydatki - w ramach budżetu.";
        } else {
            return "Wysokie wydatki - przekroczono budżet!";
        }
    }
}
