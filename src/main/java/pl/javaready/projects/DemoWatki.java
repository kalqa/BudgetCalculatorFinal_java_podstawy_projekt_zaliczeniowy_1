package pl.javaready.projects;

public class DemoWatki {

    public static void main(String[] args) {
        int id = 1;
        Task wspolny = new Task(1, "Wspólne zadanie", new Integer(5));

        WatekZTask watek1 = new WatekZTask("Wątek-1", 100, wspolny);
        WatekZTask watek2 = new WatekZTask("Wątek-2", 200, wspolny);

        watek1.start();
        watek2.start();
    }
}
