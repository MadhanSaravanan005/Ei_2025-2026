package src;

public class RealMovieTicketBooking implements MovieTicket {

    @Override
    public void bookTicket(String movieName, int seats) {
        System.out.println(seats + " ticket(s) booked successfully for " + movieName + " at the theater counter.");
    }
}
