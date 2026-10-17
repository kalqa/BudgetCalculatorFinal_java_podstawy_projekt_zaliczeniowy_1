package pl.javaready.projects;

public class DemoNewCzyBezNew {

    public static void main(String[] args) {
        Integer a1 = 5;
        Integer b1 = 5;
        System.out.println("male liczby,  a1 == b1:  " + (a1 == b1));

        Integer a2 = 200;
        Integer b2 = 200;
        System.out.println("duze liczby,  a2 == b2:  " + (a2 == b2));

        Integer a3 = new Integer(200);
        Integer b3 = new Integer(200);
        System.out.println("przez new,    a3 == b3:  " + (a3 == b3));

        int x = new Integer(5);
        System.out.println("int x = new Integer(5):  " + x);

        Double d1 = 5.0;
        Double d2 = 5.0;
        System.out.println("Double,       d1 == d2:  " + (d1 == d2));
    }
}
