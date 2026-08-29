package pl.javaready.projects;

// SongPrinter ma JEDNA odpowiedzialnosc: pokazywac menu i piosenki
// na ekranie. Nie wie, jak piosenki sa przechowywane (to robota Library)
// ani skad bierze sie to, co wpisze uzytkownik (to robota ConsoleInput).
public class SongPrinter {

    public void printMenu() {
        System.out.println("\n1. Dodaj piosenkę\n2. Pokaż listę\n3. Wyjście");
        System.out.print("Wybierz opcję: ");
    }

    public void printSongs(Song[] songs, int songsCount) {
        if (songsCount == 0) {
            System.out.println("Biblioteka jest pusta.");
            return;
        }
        printSeparator();
        for (int i = 0; i < songsCount; i++) {
            System.out.println((i + 1) + ". " + songs[i]);
        }
        printSeparator();
    }

    // prywatna metoda pomocnicza - czysto kosmetyczna, publiczne printSongs()
    // nie musi ujawniac, ze w srodku wypisujemy linie kresek
    private void printSeparator() {
        System.out.println("------------------------------");
    }
}
