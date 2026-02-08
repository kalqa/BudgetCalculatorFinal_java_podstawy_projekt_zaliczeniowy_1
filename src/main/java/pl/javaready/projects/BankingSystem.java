package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("bartek", 1000, 25);
        BankAccount bankAccount2 = new BankAccount("andrzej", 2000, 26);
        BankAccount bankAccount3 = new BankAccount("krzysztof", 3000, 27);
        BankAccount[] bankAccounts = {bankAccount1, bankAccount2, bankAccount3};
        for (BankAccount account : bankAccounts) {
            account.show();
            BankAccount.show(account.ownerName, account.accountState, account.ownerAge);
//            System.out.println(account.ownerName + ":" + account.accountState + ":" + account.ownerAge);
        }
    }
}