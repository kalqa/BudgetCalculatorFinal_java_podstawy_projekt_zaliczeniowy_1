package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
//        String[] names = {"bartek", "andrzej", "krzysztof"};
//        int[] account = {1000, 2000, 3000};
//        int[] ages = {25, 26, 27};
//        System.out.println(names[0]);
//        System.out.println(account[0]);
//        System.out.println(ages[0]);

//        BankAccount[] bankAccounts = {};

        String ownerName = "bartek";
        int accountState = 1000;
        int ownerAge = 25;

        BankAccount.ownerName = "bartek";
        BankAccount.accountState = 1000;
        BankAccount.ownerAge = 25;
        System.out.println(BankAccount.ownerName);
        System.out.println(BankAccount.accountState);
        System.out.println(BankAccount.ownerAge);

        BankAccount.ownerName = "andrzej";
        BankAccount.accountState = 2000;
        BankAccount.ownerAge = 26;
        System.out.println(BankAccount.ownerName);
        System.out.println(BankAccount.accountState);
        System.out.println(BankAccount.ownerAge);

        BankAccount.ownerName = "krzysztof";
        BankAccount.accountState = 3000;
        BankAccount.ownerAge = 27;
        System.out.println(BankAccount.ownerName);
        System.out.println(BankAccount.accountState);
        System.out.println(BankAccount.ownerAge);
    }
}