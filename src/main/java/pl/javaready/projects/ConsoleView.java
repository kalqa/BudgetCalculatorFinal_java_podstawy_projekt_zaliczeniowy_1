package pl.javaready.projects;

import java.util.Scanner;

public class ConsoleView {

    public static void displayWelcome() {
        System.out.println("=== SMART BUDGET ANALYZER ===");
        System.out.println("To narzędzie pomoże Ci przeanalizować Twoje RZECZYWISTE wydatki.");
        System.out.println("");
        System.out.println("WSKAZÓWKA: Przygotuj wyciąg bankowy!");
        System.out.println("Naciśnij ENTER, gdy będziesz gotowy...");
    }

    public static void waitForEnter(Scanner scanner) {
        scanner.nextLine();
    }

    public static void displayAvailableBudget(double budget) {
        System.out.println("");
        System.out.println("Dostępne na elastyczne wydatki: " + budget + " PLN");
    }

    public static void displayMenu() {
        System.out.println("");
        System.out.println("=== MENU GŁÓWNE ===");
        System.out.println("1. Pokaż raport miesięczny");
        System.out.println("2. Analiza 80/20");
        System.out.println("3. Ustaw cel oszczędnościowy");
        System.out.println("4. Zakończ");
        System.out.println("");
        System.out.println("Wybierz opcję:");
    }

    public static int getMenuChoice(Scanner scanner) {
        int choice = scanner.nextInt();
        ConsoleInput.clearBuffer(scanner);
        return choice;
    }

    public static void displayTotalExpenses(double total) {
        System.out.println("Suma wydatków: " + total + " PLN");
    }

    public static void displayGoodbye() {
        System.out.println("");
        System.out.println("Dziękujemy za korzystanie z Smart Budget Analyzer!");
        System.out.println("Pamiętaj: Małe zmiany dzisiaj = duże oszczędności jutro!");
        System.out.println("Do zobaczenia!");
    }

    public static void displayIncomePrompt() {
        System.out.println("");
        System.out.println("Podaj swój miesięczny dochód NETTO (po podatkach):");
    }

    public static void displayFixedCostsPrompt() {
        System.out.println("");
        System.out.println("Czy masz stałe miesięczne koszty? (czynsz, kredyt, ubezpieczenie) tak/nie");
    }

    public static void displayEnterFixedCostsPrompt() {
        System.out.println("");
        System.out.println("Podaj sumę kosztów stałych:");
    }

    public static void displayCategoriesPrompt() {
        System.out.println("");
        System.out.println("Ile kategorii wydatków chcesz śledzić?");
    }
}
