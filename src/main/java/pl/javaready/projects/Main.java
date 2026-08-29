package pl.javaready.projects;

import java.util.Scanner;

// Main ma JEDNA robote: stworzyc obiekty i je ze soba polaczyc.
// Nie czyta wejscia, nie zna zasad biznesowych, nie wypisuje niczego
// na ekran - to wszystko robia ConsoleInput, Library, SongPrinter
// i SpotifyConsoleApp.
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleInput input = new ConsoleInput(scanner);
        Library library = new Library();
        SongPrinter printer = new SongPrinter();
        SpotifyConsoleApp app = new SpotifyConsoleApp(library, printer, input);

        app.run();
    }
}
