import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(2); // 2 parking slots

        Runnable carTask = () -> parkingLot.parkCar(Thread.currentThread().getName());

        Thread car1 = new Thread(carTask, "Car-1");
        Thread car2 = new Thread(carTask, "Car-2");
        Thread car3 = new Thread(carTask, "Car-3");
        Thread car4 = new Thread(carTask, "Car-4");

        car1.start();
        car2.start();
        car3.start(); // This car has to wait for a slot
        car4.start(); // This car has to wait for a slot
    }
}


class ParkingLot {
    private final Semaphore semaphore;

    public ParkingLot(int slots) {
        this.semaphore = new Semaphore(slots);
    }

    public void parkCar(String carName) {
        try {
            semaphore.acquire(); // Acquiring a permit
            System.out.println(carName + " has occupied a parking slot.");
            Thread.sleep(2000); // Simulating parking time
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(carName + " has left the parking.");
            semaphore.release(); // Releasing a permit
        }
    }
}