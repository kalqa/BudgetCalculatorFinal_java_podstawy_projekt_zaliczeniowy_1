package pl.javaready.projects;

// TaskPrinter ma JEDNA odpowiedzialnosc: pokazywac menu i zadania na ekranie.
// Nie wie, jak zadania sa przechowywane (to robota TaskBoard) ani skad
// bierze sie to, co wpisze uzytkownik (to robota Scannera w TaskConsoleApp).
public class TaskPrinter {

    public void printMenu() {
        System.out.println("\n1. Dodaj zadanie\n2. Odhacz zadanie\n3. Pokaż listę\n4. Wyjście");
        System.out.print("Wybierz opcję: ");
    }

    public void printTasks(Task[] tasks, int tasksCount) {
        if (tasksCount == 0) {
            System.out.println("Lista jest pusta.");
            return;
        }
        for (int i = 0; i < tasksCount; i++) {
            System.out.println((i + 1) + ". " + tasks[i]);
        }
    }
}
