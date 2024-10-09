public class Luggage {
    private String luggageId;
    private int noOfLuggage;
    private String luggageDetails;
    private String status;

    public Luggage(String luggageId, int noOfLuggage, String luggageDetails, String status) {
        this.luggageId = luggageId;
        this.noOfLuggage = noOfLuggage;
        this.luggageDetails = luggageDetails;
        this.status = status;
    }

    public void Details() {
        System.out.println("Luggage ID : " + luggageId);
        System.out.println("Number of Luggage : " + noOfLuggage);
        System.out.println("Luggage Details : " + luggageDetails);
        System.out.println("Luggage Status : " + status);
    }
}

