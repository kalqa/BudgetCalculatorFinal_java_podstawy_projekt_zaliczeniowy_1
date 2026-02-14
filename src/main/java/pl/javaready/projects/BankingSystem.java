package pl.javaready.projects;

public class BankingSystem {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);



        BankAccount bankAccount = new BankAccount("bartek", 1000, 25);
//        BankAccount bankAccount1 = new BankAccount("bartek");
//        BankAccount bankAccount2 = new BankAccount("bartek", 25);
//        BankAccount bankAccount3 = new BankAccount();

        System.out.println(bankAccount.ownerName);
        System.out.println(bankAccount.accountState);
        System.out.println(bankAccount.ownerAge);

//        System.out.println(bankAccount1.ownerName);
//        System.out.println(bankAccount1.accountState);
//        System.out.println(bankAccount1.ownerAge);
//
//        System.out.println(bankAccount2.ownerName);
//        System.out.println(bankAccount2.accountState);
//        System.out.println(bankAccount2.ownerAge);
//
//        System.out.println(bankAccount3.ownerName);
//        System.out.println(bankAccount3.accountState);
//        System.out.println(bankAccount3.ownerAge);
    }
}