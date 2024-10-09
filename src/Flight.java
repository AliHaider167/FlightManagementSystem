public class Flight {
    private NoticeBoard notice;
    private double capacity;
    private double price;
    private Runway runway;

    public Flight(NoticeBoard notice, double capacity, double price, Runway runway) {
        this.notice = notice;
        this.capacity = capacity;
        this.price = price;
        this.runway = runway;
    }

    public void Details() {
        System.out.println("Flight Name : " + notice.getFlightName());
        System.out.println("Flight ID : " + notice.getFlightId());
        System.out.println("Flight Capacity : " + this.capacity);
        System.out.println("Flight Price : " + this.price);
        System.out.println("Flight Runway : " + this.runway.getRunwayNumber());
    }
}
