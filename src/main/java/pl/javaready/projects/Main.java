package pl.javaready.projects;

public class Main {

    public static void main(String[] args) {
        Elevator passengerElevator = new Elevator();
        System.out.println(passengerElevator.getMaxCapacity());
        System.out.println(passengerElevator.canBoard(400, 80));
    }
}
