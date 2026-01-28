package pl.javaready.projects;

public class BudgetRules {

    public static boolean isNumberInvalid(int number) {
        return number <= 0;
    }

    public static boolean isIncomeInvalid(double income) {
        return income <= 0;
    }

    public static boolean isCostNegative(double cost) {
        return cost < 0;
    }

    public static boolean isModerateSpending(double percentage) {
        double budgetLimit = 100;
        return percentage <= budgetLimit;
    }

    public static boolean isLowSpending(double percentage) {
        double lowSpendingThreshold = 70;
        return percentage < lowSpendingThreshold;
    }

    public static boolean isCurrentAmountGreater(double current, double max) {
        return current > max;
    }

    public static boolean isAmountAboveHealthyLevel(double amount, double level) {
        return amount > level;
    }

    public static boolean isSurplus(double value) {
        return value >= 0;
    }

    public static boolean hasExtraIncome(double extraIncome) {
        return extraIncome > 0;
    }

    public static boolean areCutsNeeded(double neededFromCuts) {
        return neededFromCuts > 0;
    }

    public static boolean wantsDetailedBreakdown(String answer) {
        return answer.equalsIgnoreCase("tak");
    }

    public static boolean doesCategoryMatch(String category, String searchName) {
        return category.equalsIgnoreCase(searchName);
    }

    public static boolean isCategoryFound(int index) {
        return index != -1;
    }

    public static boolean canReduceUsage(int reducedTimes, int currentTimes) {
        return reducedTimes < currentTimes;
    }

    public static boolean hasFixedCostsAnswer(String answer) {
        return answer.equalsIgnoreCase("tak");
    }

    public static boolean hasExistingSavingsAnswer(String answer) {
        return answer.equalsIgnoreCase("tak");
    }

    public static boolean hasExtraIncomeAnswer(String answer) {
        return answer.equalsIgnoreCase("tak");
    }
}
