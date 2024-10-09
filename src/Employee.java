import java.util.*;
public class Employee {
    private String employeeId;
    private String employeeName;
    private double employeeSalary;
    private ArrayList<Passengers> assignedPassengers;

    public Employee(String employeeId, String employeeName, double employeeSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.assignedPassengers = new ArrayList<>();
    }

    public void assignPassenger(Passengers passenger) {
        this.assignedPassengers.add(passenger);
    }

    public void Details() {
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Employee Salary : " + employeeSalary);
        System.out.println("Assigned Passengers: ");
        for (Passengers p : assignedPassengers) {
            System.out.println("- Passenger ID: " + p.getPassengerId() + ", Passenger Name: " + p.getPassengerName());
        }
    }
}
