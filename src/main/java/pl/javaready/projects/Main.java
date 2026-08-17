package pl.javaready.projects;

public class Main {

    public static void main(String[] args) {
        ElevatorBad passengerElevator = new ElevatorBad();

        System.out.println(passengerElevator.describeLoad(320));
        System.out.println(passengerElevator.isOverloaded(320));
        System.out.println(passengerElevator.canBoard(320, 90));
        System.out.println(passengerElevator.remainingCapacity(320));
        System.out.println(passengerElevator.isOverloadAlarm(399));
        System.out.println(passengerElevator.isFull(8));
        System.out.println(passengerElevator.doorsShouldClose(12));
    }
}
