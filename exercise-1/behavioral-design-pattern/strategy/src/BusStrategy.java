package src;

public class BusStrategy implements TravelStrategy {
    @Override
    public void travelToWork() {
        System.out.println("Traveling to work by Bus.");
    }
}
