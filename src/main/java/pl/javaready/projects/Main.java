package pl.javaready.projects;

public class Main {

    public static void main(String[] args) {
        int id = 1;
        String title = "Kupić mleko";

        Integer priority = 5;

        Task task = new Task(id, title, priority);

        System.out.println(task);

        priority = null;

        System.out.println(task);
    }
}
