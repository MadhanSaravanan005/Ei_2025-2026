package src;

public class WalkingStrategy implements TravelStrategy {
    @Override
    public void travelToWork() {
        System.out.println("Traveling to work by Walking.");
    }
}
