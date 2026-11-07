package pl.javaready.projects.collections.lesson01_intro;

public class Task {

    private final String title;
    private boolean done;

    public Task(String title) {
        this.title = title;
    }

    public void markDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        if (done) {
            return "[x] " + this.title;
        }
        return "[ ] " + this.title;
    }
}
