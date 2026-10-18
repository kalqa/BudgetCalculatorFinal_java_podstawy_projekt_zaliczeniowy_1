package pl.javaready.projects;

import java.util.Scanner;

// ConsoleInput opakowuje Scanner - to jego JEDYNA odpowiedzialnosc:
// czytanie tego, co uzytkownik wpisze na klawiaturze. Wszystko czytamy
// przez nextLine() i parsujemy samemu - dzieki temu nie ma problemu
// mieszania nextInt()/nextDouble() z nextLine() (i calego clearBuffer()
// z oryginalu).
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
