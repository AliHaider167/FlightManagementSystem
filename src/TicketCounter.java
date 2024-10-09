public class TicketCounter {
    private String ticketId;
    private String passengerId;
    private String source;
    private String destination;
    private double price;
    private String flightId;

    public TicketCounter(String ticketId, String passengerId, String source, String destination, double price, String flightId) {
        this.ticketId = ticketId;
        this.passengerId = passengerId;
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.flightId = flightId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void SetID(String ticketId){
        this.passengerId = ticketId;
    }

    public void BookTicket(TicketCounter ticket) {
        System.out.println("Ticket successfully booked for Passenger ID: " + ticket.passengerId);
        System.out.println("Flight ID: " + ticket.flightId);
        System.out.println("Ticket ID: " + ticket.ticketId);
        System.out.println("From " + ticket.source + " to " + ticket.destination);
        System.out.println("Price: " + ticket.price);
    }

    public void Details() {
        System.out.println("Ticket ID : " + ticketId);
        System.out.println("Passenger ID : " + passengerId);
        System.out.println("Source : " + source);
        System.out.println("Destination : " + destination);
        System.out.println("Price : " + price);
        System.out.println("Flight ID : " + flightId);
    }
}
