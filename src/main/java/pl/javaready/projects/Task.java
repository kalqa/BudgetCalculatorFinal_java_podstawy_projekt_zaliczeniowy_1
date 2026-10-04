package pl.javaready.projects;

public class Task {

    private int id;
    private final String title;
    private Integer priority;
    private boolean done;

    public Task(String title) {
        this.title = title;
        this.done = false;
    }

    // dodatkowy konstruktor - id (prymityw) i priority (obiekt Integer)
    // pokazuja dokladnie to, co widac w wizualizacji modelu pamieci
    public Task(int id, String title, Integer priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.done = false;
    }

    public void markAsDone() {
        done = true;
    }

    public boolean isDone() {
        return done;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return (done ? "[x] " : "[ ] ") + title;
    }
}
