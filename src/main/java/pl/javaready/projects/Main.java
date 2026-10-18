package pl.javaready.projects;

public class Main {

    public static void main(String[] args) {
        int id = 1;
        String title = "Kupić mleko";
        Integer priority = new Integer(50_000);
        Task task = new Task(id, title, priority);

        System.out.println(task.toString());

        Task task2 = new Task(2, "siema", 2_000_000);

        System.out.println(task.equals(task2));
        System.out.println((task == task2));
    }
}
