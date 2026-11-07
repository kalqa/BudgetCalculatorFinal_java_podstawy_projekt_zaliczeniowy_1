package pl.javaready.projects.collections.lesson16_hashcode;

import java.util.Objects;

public class UserWithHashCode {

    private final String name;

    public UserWithHashCode(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserWithHashCode that = (UserWithHashCode) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "UserWithHashCode{" +
                "name='" + name + '\'' +
                '}';
    }
}
