package pl.javaready.projects;

// Klasa czysto narzedziowa (TOOL/UTIL) - nie przechowuje zadnego stanu,
// tylko liczy. To jeden z niewielu przypadkow, kiedy static faktycznie
// ma sens (lekcja 02.11): nie ma tu "obiektu", ktorego wlasciwoscia
// mialaby byc ta liczba - to czysta funkcja matematyczna.
public class MathUtils {

    private static final double DECIMAL_PLACES = 100.0;

    public static double percentage(double part, double whole) {
        if (whole == 0) {
            return 0.0;
        }
        return (part / whole) * 100.0;
    }

    public static double round(double value) {
        return Math.round(value * DECIMAL_PLACES) / DECIMAL_PLACES;
    }
}
