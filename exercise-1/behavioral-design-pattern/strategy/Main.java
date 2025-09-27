
import src.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Traveler traveler = new Traveler();

        System.out.println("Choose your travel mode: 1. Car  2. Bus  3. Walking");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> traveler.setStrategy(new CarStrategy());
            case 2 -> traveler.setStrategy(new BusStrategy());
            case 3 -> traveler.setStrategy(new WalkingStrategy());
            default -> System.out.println("Invalid choice.");
        }

        traveler.goToWork();
        scanner.close();
    }
}
