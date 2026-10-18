package pl.javaready.projects;

import java.util.Objects;

public class Task {

    private int id;
    private String title;
    Integer priority;

    public Task(int id, String title, Integer priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", priority=" + priority +
                '}';
    }

    public boolean equals(Object obj) {
        return (this == obj);
    }
}
