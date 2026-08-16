package pl.javaready.projects;

public class Pizza {

    private String size; // "S", "M", "L"
    private int toppingsCount;

    public Pizza(String size, int toppingsCount) {
        this.size = size;
        this.toppingsCount = toppingsCount;
    }

    public String getSize() {
        return size;
    }

    public int getToppingsCount() {
        return toppingsCount;
    }
}
