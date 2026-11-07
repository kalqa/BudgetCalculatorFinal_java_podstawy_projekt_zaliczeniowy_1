package pl.javaready.projects.collections.lesson13_equals;

public class Task{

    private final String title;

    public Task(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
