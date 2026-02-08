package pl.javaready.projects;

public class BankAccount {

    public String ownerName;
    public int accountState;
    public int ownerAge;

    BankAccount(String ownerName, int accountState, int ownerAge) {
        this.ownerName = ownerName;
        this.accountState = accountState;
        this.ownerAge = ownerAge;
    }
}
