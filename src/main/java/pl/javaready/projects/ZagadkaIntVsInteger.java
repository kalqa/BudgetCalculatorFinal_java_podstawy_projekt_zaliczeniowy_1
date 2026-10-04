package pl.javaready.projects;

public class ZagadkaIntVsInteger {

    public static void main(String[] args) {
        System.out.println("## Zagadka 1: int kontra Integer");

        int a = 1000;
        int b = 1000;
        System.out.println("int:     a == b          -> " + (a == b));

        Integer x = 1000;
        Integer y = 1000;
        System.out.println("Integer: x == y          -> " + (x == y));
        System.out.println("Integer: x.equals(y)     -> " + x.equals(y));

        // Pytanie: to te same liczby, ten sam operator (==), a wyniki sa
        // inne. Dlaczego int i Integer zachowuja sie tutaj inaczej?
    }
}
