package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount bartekAccount = new BankAccount("bartek", 1000, 25);
        BankAccount michalAccount = new BankAccount("michal", 2000, 27);
        int accountStateBartek = bartekAccount.accountState;
        int ownerAgeBartek = bartekAccount.ownerAge;
        String ownerNameBartek = bartekAccount.ownerName;
        System.out.println(accountStateBartek);
        System.out.println(ownerAgeBartek);
        System.out.println(ownerNameBartek);

    }
}