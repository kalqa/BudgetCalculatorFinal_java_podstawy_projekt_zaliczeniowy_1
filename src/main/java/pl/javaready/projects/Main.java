package pl.javaready.projects;

public class Main {

    public static void main(String[] args) {
        Elevator passengerElevator = new Elevator();
        Elevator freightElevator = new Elevator();

        System.out.println(passengerElevator.describeLoad(320));            // 320/400 kg
        System.out.println(passengerElevator.canBoard(320, 90));            // false - 410 > 400
        System.out.println(passengerElevator.remainingCapacity(320));       // 80

        System.out.println(freightElevator.describeLoad(600));              // 600/1000 kg
        System.out.println(freightElevator.canBoard(600, 90));              // true - 690 <= 1000
        System.out.println(freightElevator.isOverloaded(1050));             // true

        // passengerElevator.maxLoadKg = 1000; <- to nawet się nie skompiluje
    }
}
