//public class Runway extends Abstraction {
//    private String runwayNumber;
//    private String flightName;
//    private boolean occupiedStatus;
//
//    public Runway(String runwayNumber, String flightName, boolean occupiedStatus) {
//        this.runwayNumber = runwayNumber;
//        this.flightName = flightName;
//        this.occupiedStatus = occupiedStatus;
//    }
//    @Override
//    public void Details(){
//        System.out.println("Runway Number : " + this.runwayNumber);
//        System.out.println("Flight Name : " + this.flightName);
//        System.out.println("Occupied Status : " + this.occupiedStatus);
//    }
//}

public class Runway {
    private String runwayNumber;
    private String flightName;
    private boolean isAvailable;

    public Runway(String runwayNumber, String flightName, boolean isAvailable) {
        this.runwayNumber = runwayNumber;
        this.flightName = flightName;
        this.isAvailable = isAvailable;
    }

    public String getRunwayNumber() {
        return runwayNumber;
    }

    public void setRunwayNumber(String runwayNumber) {
        this.runwayNumber = runwayNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
