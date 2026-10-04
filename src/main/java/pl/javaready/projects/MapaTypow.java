package pl.javaready.projects;

public class MapaTypow {

    public static void main(String[] args) {
        System.out.println("## Mapa: prymityw -> jego klasa opakowujaca (wrapper)");

        int intPrymityw = 1;
        Integer intObiekt = 1;
        System.out.println("int     -> Integer    | " + intPrymityw + " -> " + intObiekt);

        long longPrymityw = 1L;
        Long longObiekt = 1L;
        System.out.println("long    -> Long       | " + longPrymityw + " -> " + longObiekt);

        double doublePrymityw = 1.0;
        Double doubleObiekt = 1.0;
        System.out.println("double  -> Double     | " + doublePrymityw + " -> " + doubleObiekt);

        float floatPrymityw = 1.0f;
        Float floatObiekt = 1.0f;
        System.out.println("float   -> Float      | " + floatPrymityw + " -> " + floatObiekt);

        boolean booleanPrymityw = true;
        Boolean booleanObiekt = true;
        System.out.println("boolean -> Boolean    | " + booleanPrymityw + " -> " + booleanObiekt);

        char charPrymityw = 'A';
        Character charObiekt = 'A';
        System.out.println("char    -> Character  | " + charPrymityw + " -> " + charObiekt);

        byte bytePrymityw = 1;
        Byte byteObiekt = 1;
        System.out.println("byte    -> Byte       | " + bytePrymityw + " -> " + byteObiekt);

        short shortPrymityw = 1;
        Short shortObiekt = 1;
        System.out.println("short   -> Short      | " + shortPrymityw + " -> " + shortObiekt);
    }
}
