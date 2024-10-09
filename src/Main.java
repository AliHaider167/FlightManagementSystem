import java.util.*;

public class Main {
    public static void main(String[] args) {
        AirportManagement airportManagement = new AirportManagement("Allama Iqbal International Airport", "Lahore", "Defence Area");

        int choice;
        boolean flag = true;
        ArrayList<Passengers> passengers = new ArrayList<>();
        ArrayList<AirplaneEmployee> airplaneEmployees = new ArrayList<>();
        ArrayList<AirportEmployee> airportEmployees = new ArrayList<>();
        ArrayList<Runway> runways = new ArrayList<>();

        Scanner sin = new Scanner(System.in);

        do {
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~                USER MANU                ~~~~~~~~~~~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            System.out.println("Press 01 For Admin");
            System.out.println("Press 02 For Passenger ");
            System.out.println("Press 03 To Exit");
            System.out.print("Choice : ");
            choice = sin.nextInt();
            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

            switch (choice) {
                case 1:
                    do {
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("~~~~~~~~~~~               ADMIN MANU                ~~~~~~~~~~~");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        System.out.println("Press 1 to Add Flight Details");
                        System.out.println("Press 2 to Add Passenger");
                        System.out.println("Press 3 to Add Employees");
                        System.out.println("Press 4 to See Details");
                        System.out.println("Press 5 to Exit");
                        System.out.print("Choice : ");
                        choice = sin.nextInt();
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        sin.nextLine();

                        switch (choice) {
                            case 1:
                                System.out.print("Enter the Flight Id : ");
                                String fId = sin.nextLine();
                                System.out.print("Enter the Flight Name : ");
                                String fName = sin.nextLine();
                                System.out.print("Enter the Flight Capacity : ");
                                double capacity = sin.nextDouble();
                                sin.nextLine();
                                System.out.print("Enter the Flight Starting Time : ");
                                String startTime = sin.nextLine();
                                System.out.print("Enter the Flight Reaching Time : ");
                                String reachTime = sin.nextLine();
                                System.out.print("Enter the Flight Source : ");
                                String source = sin.nextLine();
                                System.out.print("Enter the Flight destination : ");
                                String destination = sin.nextLine();
                                System.out.print("Enter the Flight Price : ");
                                double price = sin.nextDouble();
                                sin.nextLine();
                                System.out.print("Enter the Runway Number for Flight : ");
                                String runwayNumber = sin.nextLine();

                                NoticeBoard note = new NoticeBoard(fName, fId, reachTime, destination, startTime, source);
                                airportManagement.noticeBoards.add(note);

                                // Adding a runway
                                Runway runway = new Runway(runwayNumber, fName, true);
                                runways.add(runway);

                                System.out.println("\nTICKET DETAILS\n");
                                System.out.print("Enter the Ticket Id : ");
                                String tId = sin.nextLine();

                                // Adding ticket
                                TicketCounter ticket = new TicketCounter(tId, null, source, destination, price, fId);
                                airportManagement.tickets.add(ticket);

                                // Adding a flight
                                Flight flight = new Flight(note, capacity, price, runway);
                                airportManagement.flights.add(flight);

                                System.out.println("Flight Has Been Added Successfully");
                                break;

                            case 2:
                                System.out.println("\nPASSENGER DETAILS:");
                                System.out.print("Enter Passenger ID: ");
                                String passengerId = sin.next();
                                System.out.print("Enter Passenger Name: ");
                                String passengername = sin.next();
                                System.out.print("Enter Flight ID: ");
                                String flightId = sin.next();

                                boolean ticketFound = false;
                                for (TicketCounter t : airportManagement.tickets) {
                                    if (t.getFlightId().equals(flightId)) {
                                        System.out.print("Enter Passenger Age: ");
                                        int age = sin.nextInt();
                                        System.out.print("Enter Luggage ID: ");
                                        String luggageId = sin.next();
                                        System.out.print("Enter Number of Luggage: ");
                                        int noOfLuggage = sin.nextInt();
                                        sin.nextLine();
                                        System.out.print("Enter Luggage Details: ");
                                        String luggageDetails = sin.nextLine();
                                        System.out.print("Enter Luggage Status: ");
                                        String luggageStatus = sin.nextLine();

                                        Luggage l = new Luggage(luggageId, noOfLuggage, luggageDetails, luggageStatus);

                                        Passengers p = new Passengers(passengerId, passengername, age, t.getTicketId(), l);
                                        passengers.add(p);
                                        t.SetID(passengerId);
                                        t.BookTicket(t);
                                        System.out.println("Passenger Added Successfully.");
                                        ticketFound = true;
                                        break;
                                    }
                                }

                                if (!ticketFound) {
                                    System.out.println("Flight ID not found. Cannot add passenger.");
                                }
                                break;

                            case 3:
                                System.out.print("Enter Employee Name : ");
                                String Name = sin.nextLine();
                                System.out.print("Enter Employee ID : ");
                                String sId = sin.nextLine();
                                System.out.print("Enter the Employee Salary : ");
                                double salary = sin.nextDouble();
                                sin.nextLine();

                                System.out.println("Press 1 to add Airport Employee : ");
                                System.out.println("Press 2 to Add Airplane Employee : ");
                                System.out.print("CHOICE : ");
                                choice = sin.nextInt();
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                                sin.nextLine();

                                switch (choice) {
                                    case 1:
                                        System.out.print("Enter Designation : ");
                                        String designation = sin.nextLine();
                                        System.out.print("Enter Department : ");
                                        String department = sin.nextLine();
                                        System.out.println("Enter 1 to Assign Passenger : ");
                                        System.out.print("Choice : ");
                                        choice = sin.nextInt();
                                        sin.nextLine();

                                        if (choice == 1) {
                                            System.out.println("Enter Passenger Id : ");
                                            String pId = sin.nextLine();
                                            for (Passengers p : passengers) {
                                                if (pId.equals(p.getPassengerId())) {
                                                    AirportEmployee e = new AirportEmployee(sId, Name, salary, designation, department);
                                                    p.setAirportEmployee(e);
                                                    e.setPassenger(p);
                                                    airportEmployees.add(e);
                                                    p.Details();
                                                    System.out.println("Airport Employee assigned to Passenger.");
                                                }
                                            }
                                        } else {
                                            for (AirportEmployee em : airportEmployees) {
                                                em.Details();
                                            }
                                            System.out.println("Invalid Choice.");
                                        }

                                        break;
                                    case 2:
                                        System.out.print("Enter Designation: ");
                                        String design = sin.nextLine();

                                        System.out.println("Enter 1 to Assign Passenger: ");
                                        System.out.print("Choice: ");
                                        choice = sin.nextInt();
                                        sin.nextLine();

                                        if (choice == 1) {
                                            System.out.print("Enter Passenger Id: ");
                                            String pId = sin.nextLine();
                                            boolean passengerFound = false;

                                            for (Passengers p : passengers) {
                                                if (pId.equals(p.getPassengerId())) {
                                                    AirplaneEmployee e = new AirplaneEmployee(sId, Name, salary, design, p);
                                                    airplaneEmployees.add(e);
                                                    p.Details();
                                                    System.out.println("Airport Employee assigned to Passenger.");
                                                    passengerFound = true;
                                                    break;
                                                }
                                            }

                                            if (!passengerFound) {
                                                System.out.println("Passenger ID not found.");
                                            }
                                        } else {
                                            System.out.println("Invalid Choice.");
                                        }
                                        break;

                                    default:
                                        System.out.println("Invalid Choice.");
                                        break;
                                }
                                break;

                            case 4:
                                airportManagement.Open();
                                break;

                            case 5:
                                break;

                            default:
                                System.out.println("Invalid Choice.");
                                break;
                        }

                    } while (choice != 5);
                    break;

                case 2:

                    do {
                        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("~~~~~~~~~~~              PASSENGER MANU               ~~~~~~~~~~~");
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        System.out.println("Press 1 to Book Ticket : ");
                        System.out.println("Press 2 to See Details : ");
                        System.out.println("Press 3 to Exit");
                        System.out.print("Choice : ");
                        choice = sin.nextInt();
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                        sin.nextLine();

                        switch(choice){
                            case 1:

                                System.out.print("Enter Your Id : ");
                                String cId = sin.nextLine();
                                boolean flag1 = false;

                                for(Passengers p : passengers)
                                {
                                    if(cId.equals(p.getPassengerId()))
                                    {
                                        flag1 = true;
                                        System.out.print("Enter Ticket Id : ");
                                        String tId = sin.nextLine();
                                        for(TicketCounter t : airportManagement.tickets)
                                        {

                                            if(tId.equals(t.getTicketId()))
                                            {
                                                p.setTicket(t);
                                                System.out.println("Passenger Has Booked a Ticket.");
                                            }
                                        }
                                    }
                                }


                                break;
                            case 2:

                                for(Passengers p : passengers)
                                {
                                    p.Details();
                                }

                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid Choice.");
                                break;

                        }

                    }while(choice != 3);
                    break;

                case 3:
                    System.out.println("\nAirPort Employees Data : \n");

                    for(AirportEmployee e : airportEmployees)
                    {
                        e.Details();
                    }
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

                    System.out.println("\nAirPlane Employees Data : \n");

                    for(AirplaneEmployee e : airplaneEmployees)
                    {
                        e.Details();
                    }
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

                    System.out.println("\nPassengers Data : \n");

                    for(Passengers p : passengers)
                    {
                        p.Details();
                    }
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

                    airportManagement.Open();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

                    flag = false;
                    break;

                default:
                    System.out.println("Invalid Choice.");
                    break;
            }

        } while (flag);
    }
}