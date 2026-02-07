package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
        String[] names = {"bartek", "andrzej", "krzysztof"};
        int[] account = {1000, 2000, 3000};
        int[] ages = {25, 26, 27};

//        for (int i = 0; i < names.length; i++) {
//            System.out.println(names[i]);
//            System.out.println(account[i]);
//            System.out.println(ages[i]);
//        }

        BankAccount[] bankAccounts = {};

        String firstUserName = "bartek";
        int firstUserAge = 25;

        String secondUserName = "andrzej";
        int secondUserAge = 26;

        String thirdUserName = "krzysztof";
        int thirdUserAge = 27;

        BankAccount.ownerName = "bartek";
//        BankAccount.accountState = 1000;
//        BankAccount.ownerAge = 25;
        System.out.println(BankAccount.ownerName);
        System.out.println(BankAccount.accountState);
        System.out.println(BankAccount.ownerAge);
//        BankAccount.ownerName = "andrzej";
//        BankAccount.accountState = 2000;
//        BankAccount.ownerAge = 26;
//        System.out.println(BankAccount.ownerName);
//        System.out.println(BankAccount.accountState);
//        System.out.println(BankAccount.ownerAge);
//        BankAccount.ownerName = "krzysztof";
//        BankAccount.accountState = 3000;
//        BankAccount.ownerAge = 27;

//        System.out.println(BankAccount.ownerName);
//        System.out.println(BankAccount.accountState);
//        System.out.println(BankAccount.ownerAge);
    }
}