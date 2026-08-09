package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount bartekAccount = new BankAccount("bartek", 1000, 25, "krzysztof");
//        bartekAccount.print();
        System.out.println(bartekAccount);
        BankAccount miichalAccount = new BankAccount("michal", 2000, 35, "konrad");
//        miichalAccount.print();
        System.out.println(miichalAccount);
    }
}