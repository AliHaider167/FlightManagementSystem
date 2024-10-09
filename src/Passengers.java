class Passengers {
    private String passengerId;
    private String passengerName;
    private int age;
    private String ticketId;
    private Luggage luggage;
    private TicketCounter ticket;

    public AirplaneEmployee airplaneEmployee;
    public AirportEmployee airportEmployee;

    public Passengers(String passengerId, String passengerName, int age, String ticketId, Luggage luggage) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.age = age;
        this.ticketId = ticketId;
        this.luggage = luggage;
        this.ticket = null;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setTicket(TicketCounter ticket) {
        this.ticket = ticket;
    }

    public void setAirportEmployee(AirportEmployee airportEmployee) {
        this.airportEmployee = airportEmployee;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void Details() {
        System.out.println("Passenger ID : " + passengerId);
        System.out.println("Passenger Name : " + passengerName);
        System.out.println("Age : " + age);
        this.luggage.Details();

        if (ticket != null) {
            System.out.println("Ticket ID : " + ticket.getTicketId());
            System.out.println("Flight ID : " + ticket.getFlightId());
        } else {
            System.out.println("No ticket assigned.");
        }

        if (this.airplaneEmployee != null) {
            this.airplaneEmployee.Details();
        }
        if (this.airportEmployee != null) {
            this.airportEmployee.Details();
        }
    }

}