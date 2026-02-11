package pl.javaready.projects;

class LoanCalculator {

    static int rate = 2;

    public static int calculateLoanYears(int age, int savings) {
        return age/2 * savings/2 * rate;
    }
}
