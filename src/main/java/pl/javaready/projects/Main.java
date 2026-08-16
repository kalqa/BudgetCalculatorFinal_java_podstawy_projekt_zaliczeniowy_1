package pl.javaready.projects;

public class Main {

    public static void main(String[] args) {
        Mug smallMug = new Mug(250);
        Mug bigMug = new Mug(400);

        System.out.println(smallMug.canFill(200));         // true
        System.out.println(smallMug.remainingSpace(200));  // 50

        System.out.println(bigMug.canFill(380));            // true
        System.out.println(bigMug.remainingSpace(380));     // 20

        // smallMug.capacityMl = 500; <- to nawet się nie skompiluje
    }
}
