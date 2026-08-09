package pl.javaready.projects;

/**
 * Reprezentuje pojedyncze konto bankowe.
 * Wszystkie pola są prywatne - świat zewnętrzny nie ma bezpośredniego
 * dostępu do danych, tylko przez publiczne metody (enkapsulacja).
 */
public class BankAccount {

    // ===== STAŁE (final, WIELKIE_LITERY) =====
    private static final double MIN_BALANCE = 0.0;
    private static final double MAX_SINGLE_WITHDRAWAL = 10_000.0;

    // ===== POLE STATYCZNE - wspólne dla wszystkich obiektów =====
    private static int totalAccountsCreated = 0;

    // ===== POLA (nie static - każdy obiekt ma swoje) =====
    private final int accountNumber;
    private String ownerName;
    private double balance;

    // ===== KONSTRUKTOR =====
    public BankAccount(String ownerName, double initialBalance) {
        // this.ownerName = pole klasy, ownerName (po prawej) = parametr konstruktora
        // bez "this." Java nie wiedziałaby, że chcemy przypisać do pola, a nie do samego siebie
        this.ownerName = ownerName;

        if (initialBalance < MIN_BALANCE) {
            throw new IllegalArgumentException("Saldo początkowe nie może być ujemne");
        }
        this.balance = initialBalance;

        totalAccountsCreated++;
        this.accountNumber = totalAccountsCreated; // prosty, rosnący numer konta
    }

    // ===== METODY PUBLICZNE =====

    public void deposit(double amount) {
        if (!isAmountValid(amount)) {
            System.out.println("Błąd: kwota wpłaty musi być większa od zera.");
            return;
        }
        balance += amount;
        System.out.println("Wpłacono " + amount + " zł. Nowe saldo: " + balance + " zł.");
    }

    public void withdraw(double amount) {
        if (!isAmountValid(amount)) {
            System.out.println("Błąd: kwota wypłaty musi być większa od zera.");
            return;
        }
        if (amount > MAX_SINGLE_WITHDRAWAL) {
            System.out.println("Błąd: jednorazowa wypłata nie może przekroczyć " + MAX_SINGLE_WITHDRAWAL + " zł.");
            return;
        }
        if (!hasSufficientFunds(amount)) {
            System.out.println("Błąd: niewystarczające środki na koncie.");
            return;
        }
        balance -= amount;
        System.out.println("Wypłacono " + amount + " zł. Nowe saldo: " + balance + " zł.");
    }

    // ===== METODY PRYWATNE - logika pomocnicza schowana przed światem =====

    private boolean isAmountValid(double amount) {
        return amount > 0;
    }

    private boolean hasSufficientFunds(double amount) {
        return balance - amount >= MIN_BALANCE;
    }

    // ===== GETTERY - jedyne "okno" na dane =====

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // ===== SETTER - tylko tam, gdzie zmiana z zewnątrz ma sens =====

    public boolean setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            System.out.println("Błąd: imię i nazwisko właściciela nie może być puste.");
            return false;
        }
        this.ownerName = ownerName;
        return true;
    }

    // Uwaga: celowo NIE MA setBalance(double balance)!
    // Gdyby istniał, ktoś mógłby zrobić konto.setBalance(-99999) i ominąć
    // całą walidację, którą mamy w deposit()/withdraw(). Saldo zmienia się
    // wyłącznie przez kontrolowane, publiczne metody biznesowe.

    // ===== STATYCZNY GETTER =====

    public static int getTotalAccountsCreated() {
        return totalAccountsCreated;
    }

    // ===== toString() - nadpisanie metody z klasy Object =====

    @Override
    public String toString() {
        return "Konto #" + accountNumber
                + " | właściciel: " + ownerName
                + " | saldo: " + balance + " zł";
    }
}