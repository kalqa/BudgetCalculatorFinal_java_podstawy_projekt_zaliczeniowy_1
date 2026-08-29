package pl.javaready.projects;

public class Main {

    public static void main(String[] args) {
        TaskBoard board = new TaskBoard();
        TaskConsoleApp app = new TaskConsoleApp(board);

        app.run();
    }
}
