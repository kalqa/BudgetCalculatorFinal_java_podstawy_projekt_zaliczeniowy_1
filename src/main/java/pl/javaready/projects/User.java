package pl.javaready.projects;

// Celowo NIC poza polem i konstruktorem - zero equals(), zero hashCode(),
// zero toString(). To ma pokazac, jak Java domyslnie traktuje obiekty.
public class User {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
