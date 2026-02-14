package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
//        BankAccount bankAccount = new BankAccount("bartek", 1000, 25);
//
//        System.out.println(bankAccount.ownerName);
//        System.out.println(bankAccount.accountState);
//        System.out.println(bankAccount.ownerAge);

        int age = 25;
        System.out.println(age);
        age = 40;
        System.out.println(age);

        String name;
        name = "Krzysztof";
        System.out.println(name);
        name = null;
        System.out.println(name);

        BankAccount bankAccount3;
        BankAccount bankAccount1 = new BankAccount("bartek", 1000, 25);
        bankAccount3 = bankAccount1;
        System.out.println(bankAccount1.ownerName);
        bankAccount1 = new BankAccount("krzysztof", 2000, 26);
        System.out.println(bankAccount1.ownerName);
        System.out.println(bankAccount3.ownerName);

    }
}