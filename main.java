import java.util.*;

class Train {
    int trainNumber;
    String trainName, source, destination;
    int seatsAvailable;

    Train(int trainNumber, String trainName, String source, String destination, int seatsAvailable) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
    }

    void displayTrainInfo() {
        System.out.println(trainNumber + " - " + trainName + " | " + source + " -> " + destination + " | Seats: " + seatsAvailable);
    }
}

class Ticket {
    int pnr;
    String passengerName;
    int trainNumber;
    
    Ticket(int pnr, String passengerName, int trainNumber) {
        this.pnr = pnr;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
    }
}

public class RailwayReservationSystem {
    static List<Train> trains = new ArrayList<>();
    static List<Ticket> tickets = new ArrayList<>();
    static int pnrCounter = 1001;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeTrains();
        while (true) {
            System.out.println("\n=== Railway Reservation System ===");
            System.out.println("1. View Train List");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Check PNR Status");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayTrains();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 4:
                    checkPNRStatus();
                    break;
                case 5:
                    System.out.println("Thank you for using the Railway Reservation System!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static void initializeTrains() {
        trains.add(new Train(101, "Express A", "Chennai", "Bangalore", 5));
        trains.add(new Train(102, "Express B", "Mumbai", "Delhi", 3));
        trains.add(new Train(103, "Express C", "Kolkata", "Hyderabad", 2));
    }

    static void displayTrains() {
        System.out.println("\nAvailable Trains:");
        for (Train train : trains) {
            train.displayTrainInfo();
        }
    }

    static void bookTicket() {
        System.out.print("\nEnter Train Number: ");
        int trainNumber = sc.nextInt();
        Train selectedTrain = null;
        
        for (Train train : trains) {
            if (train.trainNumber == trainNumber) {
                selectedTrain = train;
                break;
            }
        }

        if (selectedTrain == null) {
            System.out.println("Invalid Train Number!");
            return;
        }

        if (selectedTrain.seatsAvailable == 0) {
            System.out.println("No seats available!");
            return;
        }

        System.out.print("Enter Passenger Name: ");
        sc.nextLine();  // Consume newline
        String passengerName = sc.nextLine();

        Ticket ticket = new Ticket(pnrCounter++, passengerName, trainNumber);
        tickets.add(ticket);
        selectedTrain.seatsAvailable--;

        System.out.println("Ticket Booked Successfully! PNR: " + ticket.pnr);
    }

    static void cancelTicket() {
        System.out.print("\nEnter PNR Number to Cancel: ");
        int pnr = sc.nextInt();
        Ticket foundTicket = null;

        for (Ticket ticket : tickets) {
            if (ticket.pnr == pnr) {
                foundTicket = ticket;
                break;
            }
        }

        if (foundTicket == null) {
            System.out.println("PNR Not Found!");
            return;
        }

        tickets.remove(foundTicket);

        // Restore seat availability
        for (Train train : trains) {
            if (train.trainNumber == foundTicket.trainNumber) {
                train.seatsAvailable++;
                break;
            }
        }

        System.out.println("Ticket Canceled Successfully! PNR: " + pnr);
    }

    static void checkPNRStatus() {
        System.out.print("\nEnter PNR Number: ");
        int pnr = sc.nextInt();
        for (Ticket ticket : tickets) {
            if (ticket.pnr == pnr) {
                System.out.println("PNR Found! Passenger: " + ticket.passengerName + ", Train Number: " + ticket.trainNumber);
                return;
            }
        }
        System.out.println("PNR Not Found!");
    }
}




=== Railway Reservation System ===
1. View Train List
2. Book Ticket
3. Cancel Ticket
4. Check PNR Status
5. Exit
Enter choice: 1


101 - Express A | Chennai -> Bangalore | Seats: 5
102 - Express B | Mumbai -> Delhi | Seats: 3
103 - Express C | Kolkata -> Hyderabad | Seats: 2


Enter Train Number: 101
Enter Passenger Name: Rajesh
Ticket Booked Successfully! PNR: 1001


Enter PNR Number: 1001
PNR Found! Passenger: Rajesh, Train Number: 101

Enter PNR Number to Cancel: 1001
Ticket Canceled Successfully! PNR: 1001

Thank you for using the Railway Reservation System!
