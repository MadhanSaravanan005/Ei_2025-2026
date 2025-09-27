import src.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter movie name: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter number of seats: ");
        int seats = scanner.nextInt();

        MovieTicket booking = new ProxyMovieTicketBooking();
        booking.bookTicket(movieName, seats);

        scanner.close();
    }
}
