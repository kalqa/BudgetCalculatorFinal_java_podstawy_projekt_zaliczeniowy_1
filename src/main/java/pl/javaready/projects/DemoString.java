package pl.javaready.projects;

public class DemoString {

    public static void main(String[] args) {
        String a = "ready";
        String b = "ready";

        System.out.println("a == b:            " + (a == b));
        System.out.println("a.equals(b):       " + a.equals(b));

        String c = new String("ready");

        System.out.println("a == c:            " + (a == c));
        System.out.println("a.equals(c):       " + a.equals(c));
    }
}
