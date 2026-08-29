package pl.javaready.projects;

public class Task {

    private final String title;
    private boolean done;

    public Task(String title) {
        this.title = title;
        this.done = false;
    }

    public void markAsDone() {
        done = true;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public String toString() {
        return (done ? "[x] " : "[ ] ") + title;
    }
}
