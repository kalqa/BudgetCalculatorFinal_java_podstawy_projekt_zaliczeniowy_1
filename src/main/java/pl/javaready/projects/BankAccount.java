package pl.javaready.projects;

public class BankAccount {

    private String ownerName;
    private int accountState;
    private int ownerAge;

    BankAccount(String ownerName, int accountState, int ownerAge) {
        this.ownerName = ownerName;
        this.accountState = accountState;
        this.ownerAge = ownerAge;
    }

    public int getAccountState(){
        return this.accountState;
    }
}