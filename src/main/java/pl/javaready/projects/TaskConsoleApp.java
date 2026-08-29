package pl.javaready.projects;

import java.util.Scanner;

public class TaskConsoleApp {

    private final TaskBoard board;
    private final Scanner scanner;

    // Board "wstrzykiwany" przez konstruktor - TaskConsoleApp go nie tworzy sam,
    // tylko dostaje gotowy z zewnątrz (z Main). To ten sam wzorzec, którego
    // użyjesz potem w większym zadaniu.
    public TaskConsoleApp(TaskBoard board) {
        this.board = board;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Treść zadania: ");
                board.addTask(scanner.nextLine());
            } else if (choice.equals("2")) {
                printTasks();
                System.out.print("Numer zadania do odhaczenia: ");
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                board.completeTask(index);
            } else if (choice.equals("3")) {
                printTasks();
            } else if (choice.equals("4")) {
                running = false;
                System.out.println("Do zobaczenia!");
            } else {
                System.out.println("Nieznana opcja.");
            }
        }

        scanner.close();
    }

    private void printMenu() {
        System.out.println("\n1. Dodaj zadanie\n2. Odhacz zadanie\n3. Pokaż listę\n4. Wyjście");
        System.out.print("Wybierz opcję: ");
    }

    private void printTasks() {
        Task[] tasks = board.getTasks();
        if (board.getTasksCount() == 0) {
            System.out.println("Lista jest pusta.");
            return;
        }
        for (int i = 0; i < board.getTasksCount(); i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
    }
}
