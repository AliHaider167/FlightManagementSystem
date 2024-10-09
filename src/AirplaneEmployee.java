class AirplaneEmployee extends Employee {
    private String designation;
    private Passengers passenger;

    public AirplaneEmployee(String employeeId, String employeeName, double employeeSalary, String designation, Passengers passenger) {
        super(employeeId, employeeName, employeeSalary);
        this.designation = designation;
        this.passenger = passenger;
    }

    @Override
    public void Details() {
        super.Details();
        System.out.println("Designation: " + this.designation);
        if (passenger != null) {
            passenger.Details();
        } else {
            System.out.println("No passenger assigned.");
        }
    }
}