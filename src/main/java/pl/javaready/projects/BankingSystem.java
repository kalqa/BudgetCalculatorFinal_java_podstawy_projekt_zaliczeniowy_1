package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("bartek", 1000, 25);
        BankAccount bankAccount2 = new BankAccount("andrzej", 2000, 26);
        BankAccount bankAccount3 = new BankAccount("krzysztof", 3000, 27);
        BankAccount bankAccount4 = new BankAccount("ola", 4000, 28);
        BankAccount[] bankAccounts = {bankAccount1, bankAccount2, bankAccount3, bankAccount4};
//        System.out.println((LoanCalculator.calculateLoanYears(5, 5_000)));
//        LoanCalculator loanCalculator = new LoanCalculator();
//        System.out.println(loanCalculator.calculateLoanYears(5, 5_000));
//        for (BankAccount account : bankAccounts) {
//            account.showDetails(":");
//            BankAccount.showDetails(":", account.ownerName, account.accountState, account.ownerAge);
//        }
    }
}