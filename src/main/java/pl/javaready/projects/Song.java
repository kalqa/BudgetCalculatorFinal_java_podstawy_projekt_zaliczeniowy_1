package pl.javaready.projects;

// Song "zawiera w sobie" obiekt Artist - to ta sama zasada, co Engine
// bylo polem w Car. Song nie jest tylko zbiorem Stringow i intow -
// jedno z jego pol to inny, pelnoprawny obiekt.
public class Song {

    private final String title;
    private final Artist artist;
    private final int durationSeconds;

    public Song(String title, Artist artist, int durationSeconds) {
        this.title = title;
        this.artist = artist;
        this.durationSeconds = durationSeconds;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    @Override
    public String toString() {
        return title + " - " + artist + " (" + formattedDuration() + ")";
    }

    // prywatna metoda pomocnicza - publiczne toString() z niej korzysta,
    // ale swiat zewnetrzny nie musi wiedziec, JAK liczymy minuty i sekundy
    private String formattedDuration() {
        int minutes = durationSeconds / 60;
        int seconds = durationSeconds % 60;
        return minutes + ":" + (seconds < 10 ? "0" + seconds : seconds);
    }
}
