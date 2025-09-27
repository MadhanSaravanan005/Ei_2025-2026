package src;

public class ProxyMovieTicketBooking implements MovieTicket {

    private RealMovieTicketBooking realBooking;
    private int maxSeatsAllowed = 5; // access control example

    public ProxyMovieTicketBooking() {
        this.realBooking = new RealMovieTicketBooking();
    }

    @Override
    public void bookTicket(String movieName, int seats) {
        if (seats <= 0) {
            System.out.println("Invalid number of seats.");
            return;
        }
        if (seats > maxSeatsAllowed) {
            System.out.println("Cannot book more than " + maxSeatsAllowed + " seats through proxy.");
            return;
        }
        System.out.println("Booking via agent (proxy)...");
        realBooking.bookTicket(movieName, seats);
    }
}
