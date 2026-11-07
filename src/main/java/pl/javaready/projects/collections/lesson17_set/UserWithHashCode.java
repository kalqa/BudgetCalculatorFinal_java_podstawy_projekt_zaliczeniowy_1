package pl.javaready.projects.collections.lesson17_set;

import java.util.Objects;

public class UserWithHashCode {

    private final String name;

    public UserWithHashCode(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserWithHashCode other)) return false;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
