package pl.javaready.projects;

public class BankAccount {

    public String ownerName;
    public int accountState = 1000;
    public int ownerAge = 30;

    BankAccount() {
        this.ownerName = "unnamed";
        this.accountState = 9999;
        this.ownerAge = 67;
    }

    BankAccount(String ownerName, int accountState, int ownerAge) {
        this.ownerName = ownerName;
        this.accountState = accountState;
        this.ownerAge = ownerAge;
    }

    BankAccount(String ownerName) {
        this.ownerName = ownerName;
    }

    BankAccount(String ownerName, int ownerAge) {
        this.ownerName = ownerName;
        this.ownerAge = ownerAge;
        this.accountState = 5000;
    }

    public void showDetails(String separator) {
        System.out.println(this.ownerName + separator + this.accountState + separator + this.ownerAge);
    }

}
