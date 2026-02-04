package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
        System.out.println(User.getName());
        System.out.println(User.getCurrentUserMoney());
        System.out.println(User.isAdult());
        User.transferMoney(1000);
        System.out.println(User.getCurrentUserMoney());
    }
}