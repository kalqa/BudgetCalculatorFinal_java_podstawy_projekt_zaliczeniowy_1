package pl.javaready.projects;

public class Main {

    public static void main(String[] args) {
        Engine engine = new Engine(150);
        Car car = new Car("Toyota Corolla", engine);

        Engine engine2 = new Engine(350);
        Car car2 = new Car("Toyota Avensis", engine2);

        car.startCar();
        car2.startCar();

        System.out.println(car);
        System.out.println(car2);
    }
}
