package pl.javaready.projects;

public class Main {

    public static void main(String[] args) {
        Engine engine = new Engine(150);
        Car car = new Car("Toyota Corolla", engine);

        car.startCar();
        System.out.println(car);
    }
}
