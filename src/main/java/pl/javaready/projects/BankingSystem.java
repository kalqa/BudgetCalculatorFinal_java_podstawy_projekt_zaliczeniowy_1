package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
//        String[] names = {"bartek", "andrzej", "krzysztof"};
//        int[] account = {1000, 2000, 3000};
//        int[] ages = {25, 26, 27};

//        for (int i = 0; i < names.length; i++) {
//            System.out.println(names[i]);
//            System.out.println(account[i]);
//            System.out.println(ages[i]);
//        }

        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.ownerName = "bartek";
        bankAccount1.accountState = 1000;
        bankAccount1.ownerAge = 25;
        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.ownerName = "andrzej";
        bankAccount2.accountState = 2000;
        bankAccount2.ownerAge = 26;
        BankAccount bankAccount3 = new BankAccount();
        bankAccount3.ownerName = "krzysztof";
        bankAccount3.accountState = 3000;
        bankAccount3.ownerAge = 27;

        BankAccount[] bankAccounts = {bankAccount1, bankAccount2, bankAccount3};

        for (BankAccount account: bankAccounts) {
            System.out.println(account.ownerName  + ":" + account.accountState + ":" + account.ownerAge);
        }
//
//        BankAccount.ownerName = "bartek";
//        BankAccount.accountState = 1000;
//        BankAccount.ownerAge = 25;
//        System.out.println(BankAccount.ownerName);
//        System.out.println(BankAccount.accountState);
//        System.out.println(BankAccount.ownerAge);
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