package pl.javaready.projects;

// Library ma JEDNA odpowiedzialnosc: przechowywac piosenki i pilnowac
// reguly "nie wiecej niz MAX_SONGS". To ten sam wzorzec co TaskBoard
// z poprzedniej lekcji.
public class Library {

    private static final int MAX_SONGS = 50;

    private final Song[] songs;
    private int songsCount;

    public Library() {
        this.songs = new Song[MAX_SONGS];
        this.songsCount = 0;
    }

    public boolean addSong(Song song) {
        if (isFull()) {
            System.out.println("Błąd: biblioteka jest pełna.");
            return false;
        }
        songs[songsCount] = song;
        songsCount++;
        return true;
    }

    public Song[] getSongs() {
        return songs;
    }

    public int getSongsCount() {
        return songsCount;
    }

    // prywatna metoda pomocnicza - publiczne addSong() z niej korzysta,
    // zeby nie powtarzac tego samego warunku w wielu miejscach
    private boolean isFull() {
        return songsCount >= songs.length;
    }
}
