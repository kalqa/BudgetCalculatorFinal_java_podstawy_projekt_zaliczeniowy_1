package pl.javaready.projects;

import java.util.Scanner;

// ConsoleInput opakowuje Scanner - to jego JEDYNA odpowiedzialnosc:
// czytanie tego, co uzytkownik wpisze na klawiaturze. Czytamy wszystko
// przez nextLine() i parsujemy samemu, zeby nie mieszac nextInt()/
// nextDouble() z nextLine().
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

    public double readDouble() {
        return Double.parseDouble(scanner.nextLine());
    }

    public void close() {
        scanner.close();
    }
}
