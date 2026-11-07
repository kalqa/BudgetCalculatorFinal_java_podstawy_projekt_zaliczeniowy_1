package pl.javaready.projects.collections.lesson16_hashcode;

import java.util.Objects;

public class User extends Object{

    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
