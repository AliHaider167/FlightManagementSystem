import java.util.*;
public class AirportManagement {
    private String airportName;
    private String cityName;
    private String area;

    public ArrayList<Flight> flights;
    public ArrayList<NoticeBoard> noticeBoards;
    public ArrayList<TicketCounter> tickets;

    public AirportManagement(String airportName, String cityName, String area) {
        this.airportName = airportName;
        this.cityName = cityName;
        this.area = area;

        flights = new ArrayList<>();
        noticeBoards = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public void Open() {
        System.out.println("Airport Name: " + airportName);
        System.out.println("City: " + cityName);
        System.out.println("Area: " + area);

        System.out.println("\n----- Flights -----");
        for (Flight flight : flights) {
            flight.Details();
            System.out.println();
        }

        System.out.println("\n----- Tickets -----");
        for (TicketCounter ticket : tickets) {
            ticket.Details();
            System.out.println();
        }

        System.out.println("\n----- Notice Boards -----");
        for (NoticeBoard notice : noticeBoards) {
            notice.Details();
            System.out.println();
        }
    }
}
