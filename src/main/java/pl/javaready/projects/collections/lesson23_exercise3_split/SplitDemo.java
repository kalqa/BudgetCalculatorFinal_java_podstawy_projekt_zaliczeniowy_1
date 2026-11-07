package pl.javaready.projects.collections.lesson23_exercise3_split;

public class SplitDemo {

    public static void main(String[] args) {
        String text = "ala ma kota";

        // split cuts a String into pieces at every separator and returns an array of Strings
        String[] words = text.split(" ");

        System.out.println(words.length);   // 3
        System.out.println(words[0]);       // ala
        System.out.println(words[1]);       // ma
        System.out.println(words[2]);       // kota

        // an array can be walked with for-each, just like a list
        for (String word : words) {
            System.out.println(word);
        }

        // the separator can be any text, for example a comma
        String[] countries = "PL,DE,PL,FR".split(",");
        System.out.println(countries.length);   // 4

        // the original String is not changed
        System.out.println(text);   // ala ma kota
    }
}
