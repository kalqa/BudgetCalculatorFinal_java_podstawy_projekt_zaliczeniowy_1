package pl.javaready.projects;

public class DemoEqualsIObject {

    public static void main(String[] args) {
        Task task1 = new Task(1, "Kupić mleko", 5);
        Task task2 = new Task(1, "Kupić mleko", 5);

        System.out.println("task1 == task2:      " + (task1 == task2));
        System.out.println("task1.equals(task2): " + task1.equals(task2));

        Integer a = 200;
        Integer b = 200;

        System.out.println("a == b:              " + (a == b));
        System.out.println("a.equals(b):         " + a.equals(b));

        System.out.println();
        System.out.println("task1.toString():    " + task1.toString());
        System.out.println("task1.hashCode():     " + task1.hashCode());
    }
}
