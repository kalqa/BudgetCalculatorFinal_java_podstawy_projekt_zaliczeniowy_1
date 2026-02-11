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

//    public void showDetails(String separator) {
//        System.out.println(this.ownerName + separator + this.accountState + separator + this.ownerAge);
//    }

    public static void showDetails(String separator,
                                   String ownerName,
                                   int accountState,
                                   int ownerAge) {
        System.out.println(ownerName + separator + accountState + separator + ownerAge);
    }

}
