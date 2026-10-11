package pl.javaready.projects;

public class Task {

    private int id;
    private String title;
    private Integer priority;
    private Task poprzednie;
    private int[] dane = new int[1_000_000]; // ok. 4 MB, żeby pamięć kończyła się szybko

    public Task(int id, String title, Integer priority, Task poprzednie) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.poprzednie = poprzednie;
    }
}
