package pl.javaready.projects.collections.lesson26_exercise6_equals_hashcode;

public class Parcel {

    private final String code;

    public Parcel(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    // TODO 2: add equals() and hashCode() based on the code (let the IDE generate them)
}
