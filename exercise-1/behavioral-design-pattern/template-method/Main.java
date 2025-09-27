import src.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Game to Play:");
        System.out.println("1. Football");
        System.out.println("2. Cricket");

        int choice = scanner.nextInt();

        Game game;
        if (choice == 1) {
            game = new Football();
        } else if (choice == 2) {
            game = new Cricket();
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        game.play();
        scanner.close();
    }
}
