package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {

        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.companyName = "mbank";
        bankAccount1.ownerName = "bartek";
        bankAccount1.accountState = 1000;
        bankAccount1.ownerAge = 25;
        System.out.println(bankAccount1.companyName);
        bankAccount1.counter++;

        BankAccount bankAccount2 = new BankAccount();
        bankAccount2.companyName = "mbank123";
        bankAccount2.ownerName = "andrzej";
        bankAccount2.accountState = 2000;
        bankAccount2.ownerAge = 26;
        bankAccount2.counter++;
        System.out.println(bankAccount2.companyName);

        BankAccount bankAccount3 = new BankAccount();
//        bankAccount3.companyName = "mbank123";
        bankAccount3.ownerName = "krzysztof";
        bankAccount3.accountState = 3000;
        bankAccount3.ownerAge = 27;
        bankAccount3.counter++;
        System.out.println(bankAccount3.companyName);

        System.out.println("counter: " + bankAccount3.counter);


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