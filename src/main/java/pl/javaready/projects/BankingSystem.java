package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("bartek", 1000, 25);

        System.out.println(bankAccount.ownerName);
        System.out.println(bankAccount.accountState);
        System.out.println(bankAccount.ownerAge);
    }
}