package pl.javaready.projects;

// SpotifyConsoleApp ma JEDNA odpowiedzialnosc: dyrygowac ruchem miedzy
// uzytkownikiem (ConsoleInput), regulami biznesowymi (Library) i ekranem
// (SongPrinter). Wszystkie trzy sa wstrzykiwane przez konstruktor - dokladnie
// tak samo jak TaskConsoleApp(board, printer, input) w poprzedniej lekcji.
public class SpotifyConsoleApp {

    private final Library library;
    private final SongPrinter printer;
    private final ConsoleInput input;

    public SpotifyConsoleApp(Library library, SongPrinter printer, ConsoleInput input) {
        this.library = library;
        this.printer = printer;
        this.input = input;
    }

    public void run() {
        boolean running = true;

        while (running) {
            printer.printMenu();
            String choice = input.readLine();

            if (choice.equals("1")) {
                handleAddSong();
            } else if (choice.equals("2")) {
                handleShowSongs();
            } else if (choice.equals("3")) {
                running = false;
                System.out.println("Do zobaczenia!");
            } else {
                System.out.println("Nieznana opcja.");
            }
        }

        input.close();
    }

    // publiczna run() wola te dwie prywatne metody - swiat na zewnatrz
    // widzi tylko run(), nie musi wiedziec, co dzieje sie w srodku kazdej opcji
    private void handleAddSong() {
        System.out.print("Tytuł: ");
        String title = input.readLine();

        System.out.print("Wykonawca: ");
        Artist artist = new Artist(input.readLine());

        System.out.print("Długość w sekundach: ");
        int durationSeconds = input.readNumber();

        library.addSong(new Song(title, artist, durationSeconds));
    }

    private void handleShowSongs() {
        printer.printSongs(library.getSongs(), library.getSongsCount());
    }
}
