package src;

public class CarStrategy implements TravelStrategy {
    @Override
    public void travelToWork() {
        System.out.println("Traveling to work by Car.");
    }
}
