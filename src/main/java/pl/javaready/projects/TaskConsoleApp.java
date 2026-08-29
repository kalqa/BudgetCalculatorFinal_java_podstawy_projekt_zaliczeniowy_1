package pl.javaready.projects;

// TaskConsoleApp ma JEDNA odpowiedzialnosc: dyrygowac ruchem miedzy
// uzytkownikiem (ConsoleInput), regulami biznesowymi (TaskBoard) i ekranem
// (TaskPrinter). Sam nie przechowuje zadan i sam nie wypisuje ich na ekran -
// tylko woła te trzy obiekty we wlasciwej kolejnosci.
//
// Wszystkie trzy sa "wstrzykiwane" przez konstruktor - TaskConsoleApp
// ich nie tworzy, tylko dostaje gotowe z zewnatrz (z Main). Zauwaz, ze
// TaskConsoleApp w ogole nie wie o istnieniu Scannera - zna tylko ConsoleInput.
public class TaskConsoleApp {

    private final TaskBoard board;
    private final TaskPrinter printer;
    private final ConsoleInput input;

    public TaskConsoleApp(TaskBoard board, TaskPrinter printer, ConsoleInput input) {
        this.board = board;
        this.printer = printer;
        this.input = input;
    }

    public void run() {
        boolean running = true;

        while (running) {
            printer.printMenu();
            String choice = input.readLine();

            if (choice.equals("1")) {
                System.out.print("Treść zadania: ");
                board.addTask(input.readLine());
            } else if (choice.equals("2")) {
                printer.printTasks(board.getTasks(), board.getTasksCount());
                System.out.print("Numer zadania do odhaczenia: ");
                int index = input.readNumber() - 1;
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

        input.close();
    }
}
