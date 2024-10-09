class AirportEmployee {
    private String employeeId;
    private String employeeName;
    private double salary;
    private String designation;
    private String department;

    public Passengers p;

    public AirportEmployee(String employeeId, String employeeName, double salary, String designation, String department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.designation = designation;
        this.department = department;
    }

    public void setPassenger(Passengers passenger) {
        this.p = passenger;
    }

    public void Details() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Salary : " + salary);
        System.out.println("Designation : " + designation);
        System.out.println("Department : " + department);
        if (p != null) {
            p.Details();
        }
    }
}