package src;

public class Traveler {
    private TravelStrategy strategy;

    public void setStrategy(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public void goToWork() {
        if (strategy == null) {
            System.out.println("No travel strategy selected.");
        } else {
            strategy.travelToWork();
        }
    }
}
