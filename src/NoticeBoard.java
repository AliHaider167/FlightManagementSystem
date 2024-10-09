public class NoticeBoard {
    private String flightName;
    private String flightId;
    private String reachingTime;
    private String destination;
    private String startingTime;
    private String source;

    public NoticeBoard(String flightName, String flightId, String reachingTime, String destination, String startingTime, String source) {
        this.flightName = flightName;
        this.flightId = flightId;
        this.reachingTime = reachingTime;
        this.destination = destination;
        this.startingTime = startingTime;
        this.source = source;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getFlightId() {
        return flightId;
    }

    public void Details() {
        System.out.println("Flight Name : " + this.flightName);
        System.out.println("Flight ID : " + this.flightId);
        System.out.println("Reaching Time : " + this.reachingTime);
        System.out.println("Destination : " + this.destination);
        System.out.println("Starting Time : " + this.startingTime);
        System.out.println("Source : " + this.source);
    }
}
