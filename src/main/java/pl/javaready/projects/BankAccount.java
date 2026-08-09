package pl.javaready.projects;

public class BankAccount {

    private String ownerName;
    public int accountState;
    private int ownerAge;

    BankAccount(String ownerName, int accountState, int ownerAge) {
        this.ownerName = ownerName;
        this.accountState = accountState;
        this.ownerAge = ownerAge;
    }

    public void addToAccount(int accountState){
        System.out.println("dodaj " + accountState + " zł");
        this.accountState += accountState;
    }
}