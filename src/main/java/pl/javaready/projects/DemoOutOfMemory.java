package pl.javaready.projects;

import java.util.ArrayList;
import java.util.List;

// Odpal z malym limitem sterty, zeby szybko zobaczyc efekt:
// java -Xmx64m -cp target/classes pl.javaready.projects.DemoOutOfMemory
public class DemoOutOfMemory {

    public static void main(String[] args) {
        List<int[]> zjadacz = new ArrayList<>();
        int licznik = 0;

        while (true) {
            zjadacz.add(new int[1_000_000]);
            licznik++;
            System.out.println("obiektów na liście: " + licznik);
        }
    }
}
