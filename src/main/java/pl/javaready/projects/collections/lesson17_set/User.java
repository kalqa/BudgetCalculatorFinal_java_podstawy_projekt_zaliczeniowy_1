package pl.javaready.projects.collections.lesson17_set;

public class User {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User other)) return false;
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
