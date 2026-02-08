package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
//        int size = 99;
//        BankAccount[] bankAccounts = new BankAccount[size];
//        for(int i = 0; i < size; i++){
//            bankAccounts[i] = constructBankAccount("bartek", 1000, 25);
//        }
        BankAccount bankAccount1 = constructBankAccount("bartek", 1000, 25);
        BankAccount bankAccount2 = constructBankAccount("andrzej", 2000, 26);
        BankAccount bankAccount3 = constructBankAccount("krzysztof", 3000, 27);
        BankAccount[] bankAccounts = {bankAccount1, bankAccount2, bankAccount3};

        for (BankAccount account : bankAccounts) {
            System.out.println(account.ownerName + ":" + account.accountState + ":" + account.ownerAge);
        }
    }

    private static BankAccount constructBankAccount(String name, int accountValue, int age) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.ownerName = name;
        bankAccount.accountState = accountValue;
        bankAccount.ownerAge = age;
        return bankAccount;
    }
}