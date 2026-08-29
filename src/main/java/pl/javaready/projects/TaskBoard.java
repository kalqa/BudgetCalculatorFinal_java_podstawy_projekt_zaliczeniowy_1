package pl.javaready.projects;

public class TaskBoard {

    private static final int MAX_TASKS = 20;

    private final Task[] tasks;
    private int tasksCount;

    public TaskBoard() {
        this.tasks = new Task[MAX_TASKS];
        this.tasksCount = 0;
    }

    public boolean addTask(String title) {
        if (tasksCount >= tasks.length) {
            System.out.println("Błąd: lista zadań jest pełna.");
            return false;
        }
        tasks[tasksCount] = new Task(title);
        tasksCount++;
        return true;
    }

    public boolean completeTask(int index) {
        if (index < 0 || index >= tasksCount) {
            System.out.println("Błąd: nie ma zadania o takim numerze.");
            return false;
        }
        tasks[index].markAsDone(); // TaskBoard NIE wie, JAK Task zaznacza się jako gotowy - tylko woła metodę
        return true;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public int getTasksCount() {
        return tasksCount;
    }
}
