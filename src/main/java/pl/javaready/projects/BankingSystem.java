package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount bartekAccount = new BankAccount("bartek", 1000, 25);
        System.out.println(bartekAccount.getAccountState());
    }
}