package pl.javaready.projects;

public class BankAccount {



    private String ownerName;
    private int accountState;
    private int ownerAge;
    private String bestFriend;

    BankAccount(String ownerName, int accountState, int ownerAge, String bestFriend) {
        this.ownerName = ownerName;
        this.accountState = accountState;
        this.ownerAge = ownerAge;
        this.bestFriend = bestFriend;
    }

    public int getAccountState(){
        return this.accountState;
    }

    public String getOwnerName(){
        return this.ownerName;
    }

    public int getOwnerAge(){
        return this.ownerAge;
    }

    public void print(){
        System.out.println("stan konta:" + this.accountState);
        System.out.println("nazwa wlasciiela:" + this.ownerName);
        System.out.println("wiek wlasciiela:" + this.ownerAge);
        System.out.println("najlepszy kumpel wlascieila:" + this.bestFriend);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "ownerName='" + ownerName + '\'' +
                ", accountState=" + accountState +
                ", ownerAge=" + ownerAge +
                ", bestFriend='" + bestFriend + '\'' +
                '}';
    }
}