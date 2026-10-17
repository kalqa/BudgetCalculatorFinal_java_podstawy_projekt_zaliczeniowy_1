package pl.javaready.projects;

public class Main {

    public static void main(String[] args) {
        int id = 1;
        String title = "Kupić mleko";
        Integer priority = new Integer(50_000);
        Task task = new Task(id, title, priority);
//        Task task2 = new Task(id, title, priority);
        System.out.println(id); // 1
        System.out.println(task.priority); // 50_000

        showMe(id, task);

        System.out.println(id); //? 5? czy 1?
        System.out.println(task.priority); // 50_000 czy 1_000_000?
    }

    private static void showMe(int id, Task task){
        int a = new Integer(5);
        id = 5;
//        task.priority = new Integer(1_000_000);
        Task task2 = new Task(2, "siema", 2_000_000);
        task = task2;
        task.priority = new Integer(1_500_000);
    }
}
