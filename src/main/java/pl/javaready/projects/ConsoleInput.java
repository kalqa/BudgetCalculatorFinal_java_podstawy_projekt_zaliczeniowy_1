package pl.javaready.projects;

import java.util.Scanner;

// ConsoleInput opakowuje Scanner - to jego JEDYNA odpowiedzialnosc:
// czytanie tego, co uzytkownik wpisze na klawiaturze.
// TaskConsoleApp nie zna juz Scannera (klasy z JDK) - zna tylko ConsoleInput,
// czyli NASZA klase, ktora chowa Scanner w srodku.
public class ConsoleInput {

    private final Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public int readNumber() {
        return Integer.parseInt(scanner.nextLine());
    }

    public void close() {
        scanner.close();
    }
}
