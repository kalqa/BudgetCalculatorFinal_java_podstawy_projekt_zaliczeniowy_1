package pl.javaready.projects.collections.lesson13_equals;

import java.util.Objects;

public class TaskWithEquals {

    private final String title;

    public TaskWithEquals(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TaskWithEquals that = (TaskWithEquals) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public String toString() {
        return title;
    }
}
