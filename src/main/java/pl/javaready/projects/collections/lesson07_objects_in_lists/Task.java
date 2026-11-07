package pl.javaready.projects.collections.lesson07_objects_in_lists;

public class Task {

    private final String title;
    private boolean done;

    public Task(String title) {
        this.title = title;
    }

//    public Task(String title, boolean done) {
//        this.title = title;
//        this.done = done;
//    }

    public void markDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        if (this.done) {
            return "[x] " + title;
        }
        return "[ ] " + title;
    }
}
