package pl.javaready.projects.collections.lesson26_exercise6_equals_hashcode;

import java.util.Objects;

public class ParcelFixed {

    private final String code;

    public ParcelFixed(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParcelFixed other)) return false;
        return code.equals(other.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return code;
    }
}
