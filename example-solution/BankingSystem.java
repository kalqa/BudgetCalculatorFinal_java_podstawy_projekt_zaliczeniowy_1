package pl.javaready.projects;

import java.util.Scanner;

public class BankingSystem {

    private static final int MAX_ACCOUNTS = 10;

    public static void main(String[] args) {
        // Tablica obiektów - na starcie wszystkie sloty to null!
        // Dopóki nie zrobimy "new BankAccount(...)" w danym slocie,
        // próba użycia go skończy się NullPointerException.
        BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];
        int accountsUsed = 0;

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                accountsUsed = createAccount(scanner, accounts, accountsUsed);
            } else if (choice.equals("2")) {
                handleDeposit(scanner, accounts, accountsUsed);
            } else if (choice.equals("3")) {
                handleWithdraw(scanner, accounts, accountsUsed);
            } else if (choice.equals("4")) {
                showSingleAccount(scanner, accounts, accountsUsed);
            } else if (choice.equals("5")) {
                showAllAccounts(accounts, accountsUsed);
            } else if (choice.equals("6")) {
                handleChangeOwner(scanner, accounts, accountsUsed);
            } else if (choice.equals("7")) {
                running = false;
                System.out.println("Do zobaczenia!");
            } else {
                System.out.println("Nieznana opcja, spróbuj ponownie.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== MINI BANK ===");
        System.out.println("1. Utwórz nowe konto");
        System.out.println("2. Wpłać pieniądze");
        System.out.println("3. Wypłać pieniądze");
        System.out.println("4. Pokaż stan konta");
        System.out.println("5. Pokaż wszystkie konta");
        System.out.println("6. Zmień właściciela konta");
        System.out.println("7. Wyjście");
        System.out.print("Wybierz opcję: ");
    }

    private static int createAccount(Scanner scanner, BankAccount[] accounts, int accountsUsed) {
        if (accountsUsed >= accounts.length) {
            System.out.println("Osiągnięto limit kont (" + accounts.length + ").");
            return accountsUsed;
        }

        System.out.print("Imię i nazwisko właściciela: ");
        String owner = scanner.nextLine();

        System.out.print("Saldo początkowe: ");
        String balanceInput = scanner.nextLine();

        try {
            double initialBalance = Double.parseDouble(balanceInput);
            accounts[accountsUsed] = new BankAccount(owner, initialBalance);
            System.out.println("Utworzono konto: " + accounts[accountsUsed]);
            return accountsUsed + 1;
        } catch (NumberFormatException e) {
            System.out.println("Błąd: saldo musi być liczbą, np. 1000 lub 1000.50.");
            return accountsUsed;
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
            return accountsUsed;
        }
    }

    private static void handleDeposit(Scanner scanner, BankAccount[] accounts, int accountsUsed) {
        BankAccount account = selectAccount(scanner, accounts, accountsUsed);
        if (account == null) {
            return;
        }

        System.out.print("Kwota wpłaty: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            account.deposit(amount);
        } catch (NumberFormatException e) {
            System.out.println("Błąd: kwota musi być liczbą.");
        }
    }

    private static void handleWithdraw(Scanner scanner, BankAccount[] accounts, int accountsUsed) {
        BankAccount account = selectAccount(scanner, accounts, accountsUsed);
        if (account == null) {
            return;
        }

        System.out.print("Kwota wypłaty: ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            account.withdraw(amount);
        } catch (NumberFormatException e) {
            System.out.println("Błąd: kwota musi być liczbą.");
        }
    }

    private static void showSingleAccount(Scanner scanner, BankAccount[] accounts, int accountsUsed) {
        BankAccount account = selectAccount(scanner, accounts, accountsUsed);
        if (account != null) {
            System.out.println(account);
        }
    }

    private static void showAllAccounts(BankAccount[] accounts, int accountsUsed) {
        if (accountsUsed == 0) {
            System.out.println("Brak kont do wyświetlenia.");
            return;
        }

        System.out.println("--- Wszystkie konta (" + BankAccount.getTotalAccountsCreated() + " utworzonych łącznie) ---");
        // Pętla idzie tylko do accountsUsed, więc nigdy nie dotykamy
        // pustych (null) slotów w tablicy - to zabezpiecza nas przed NPE.
        for (int i = 0; i < accountsUsed; i++) {
            System.out.println(accounts[i]);
        }
    }

    private static void handleChangeOwner(Scanner scanner, BankAccount[] accounts, int accountsUsed) {
        BankAccount account = selectAccount(scanner, accounts, accountsUsed);
        if (account == null) {
            return;
        }

        System.out.print("Nowe imię i nazwisko właściciela: ");
        String newOwner = scanner.nextLine();
        if (account.setOwnerName(newOwner)) {
            System.out.println("Zaktualizowano dane konta: " + account);
        }
    }

    /**
     * Pyta użytkownika o numer indeksu konta (1, 2, 3...) i zwraca odpowiedni obiekt.
     * Zwraca null, jeśli input jest niepoprawny albo poza zakresem - dzięki temu
     * metody wołające nie muszą się martwić o ArrayIndexOutOfBoundsException.
     */
    private static BankAccount selectAccount(Scanner scanner, BankAccount[] accounts, int accountsUsed) {
        if (accountsUsed == 0) {
            System.out.println("Nie ma jeszcze żadnych kont.");
            return null;
        }

        System.out.print("Podaj numer konta (1-" + accountsUsed + "): ");
        String input = scanner.nextLine();

        try {
            int index = Integer.parseInt(input) - 1; // użytkownik liczy od 1, tablica od 0
            if (index < 0 || index >= accountsUsed) {
                System.out.println("Błąd: nie ma konta o takim numerze.");
                return null;
            }
            return accounts[index];
        } catch (NumberFormatException e) {
            System.out.println("Błąd: numer konta musi być liczbą całkowitą.");
            return null;
        }
    }
}