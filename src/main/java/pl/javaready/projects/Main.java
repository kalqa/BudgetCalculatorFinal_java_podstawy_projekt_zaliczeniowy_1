package pl.javaready.projects;

import java.util.Scanner;

// Main ma JEDNA robote: stworzyc obiekty i je ze soba polaczyc.
// Nie czyta wejscia, nie zna zasad biznesowych, nie wypisuje niczego
// na ekran - to wszystko robia ConsoleInput, TaskBoard, TaskPrinter
// i TaskConsoleApp.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleInput input = new ConsoleInput(scanner);
        TaskBoard board = new TaskBoard();
        TaskPrinter printer = new TaskPrinter();
        TaskConsoleApp app = new TaskConsoleApp(board, printer, input);

        app.run();
    }
}
