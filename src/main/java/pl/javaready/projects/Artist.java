package pl.javaready.projects;

// Artist to osobna klasa, nie zwykly String - ma wlasne zachowanie
// (toString) i mozna ja kiedys rozbudowac (np. o kraj, gatunek muzyczny)
// bez ruszania klasy Song.
public class Artist {

    private final String name;

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
