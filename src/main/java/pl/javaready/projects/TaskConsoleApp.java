package pl.javaready.projects;

import java.util.Scanner;

// TaskConsoleApp ma JEDNA odpowiedzialnosc: dyrygowac ruchem miedzy
// uzytkownikiem (Scanner), regulami biznesowymi (TaskBoard) i ekranem
// (TaskPrinter). Sam nie przechowuje zadan i sam nie wypisuje ich na ekran -
// tylko woła te trzy obiekty we wlasciwej kolejnosci.
//
// Wszystkie trzy sa "wstrzykiwane" przez konstruktor - TaskConsoleApp
// ich nie tworzy, tylko dostaje gotowe z zewnatrz (z Main).
public class TaskConsoleApp {

    private final TaskBoard board;
    private final TaskPrinter printer;
    private final Scanner scanner;

    public TaskConsoleApp(TaskBoard board, TaskPrinter printer, Scanner scanner) {
        this.board = board;
        this.printer = printer;
        this.scanner = scanner;
    }

    public void run() {
        boolean running = true;

        while (running) {
            printer.printMenu();
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Treść zadania: ");
                board.addTask(scanner.nextLine());
            } else if (choice.equals("2")) {
                printer.printTasks(board.getTasks(), board.getTasksCount());
                System.out.print("Numer zadania do odhaczenia: ");
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                board.completeTask(index);
            } else if (choice.equals("3")) {
                printer.printTasks(board.getTasks(), board.getTasksCount());
            } else if (choice.equals("4")) {
                running = false;
                System.out.println("Do zobaczenia!");
            } else {
                System.out.println("Nieznana opcja.");
            }
        }

        scanner.close();
    }
}
