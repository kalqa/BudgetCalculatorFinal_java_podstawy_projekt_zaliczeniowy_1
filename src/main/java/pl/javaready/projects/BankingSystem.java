package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.ownerName = "bartek";
//        bankAccount1.accountState = 1000;
//        bankAccount1.ownerAge = 25;

        BankAccount bankAccount2 = new BankAccount();
//        bankAccount2.ownerName = "andrzej";
//        bankAccount2.accountState = 2000;
        bankAccount2.ownerAge = 26;

        BankAccount bankAccount3 = new BankAccount();
//        bankAccount3.ownerName = "krzysztof";
        bankAccount3.accountState = 3000;
//        bankAccount3.ownerAge = 27;

        BankAccount[] bankAccounts = {bankAccount1, bankAccount2, bankAccount3};

        for (BankAccount account : bankAccounts) {
            System.out.println(account.ownerName + ":" + account.accountState + ":" + account.ownerAge);
        }
    }
}