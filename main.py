class RailwayReservationSystem:
    def __init__(self):
        self.trains = {
            101: {"name": "Express Train", "seats": 5, "price": 500},
            102: {"name": "Superfast Train", "seats": 3, "price": 800},
            103: {"name": "Rajdhani Express", "seats": 4, "price": 1200},
        }
        self.bookings = {}

    def view_trains(self):
        print("\nAvailable Trains:")
        for train_no, details in self.trains.items():
            print(f"Train No: {train_no}, Name: {details['name']}, Seats Available: {details['seats']}, Price: ₹{details['price']}")

    def book_ticket(self):
        self.view_trains()
        train_no = int(input("\nEnter Train Number to Book: "))
        if train_no in self.trains and self.trains[train_no]["seats"] > 0:
            name = input("Enter Passenger Name: ")
            seats = int(input("Enter Number of Seats: "))
            if seats <= self.trains[train_no]["seats"]:
                self.trains[train_no]["seats"] -= seats
                pnr = len(self.bookings) + 1
                self.bookings[pnr] = {"name": name, "train": self.trains[train_no]["name"], "seats": seats, "amount": seats * self.trains[train_no]["price"]}
                print(f"\nBooking Successful! PNR Number: {pnr}, Total Fare: ₹{self.bookings[pnr]['amount']}")
            else:
                print("\nNot enough seats available.")
        else:
            print("\nInvalid Train Number or No Seats Available!")

    def cancel_ticket(self):
        pnr = int(input("\nEnter PNR Number to Cancel: "))
        if pnr in self.bookings:
            train_name = self.bookings[pnr]["train"]
            seats = self.bookings[pnr]["seats"]
            for train_no, details in self.trains.items():
                if details["name"] == train_name:
                    self.trains[train_no]["seats"] += seats
                    break
            del self.bookings[pnr]
            print("\nTicket Cancelled Successfully!")
        else:
            print("\nInvalid PNR Number!")

    def view_bookings(self):
        print("\nCurrent Bookings:")
        if not self.bookings:
            print("No bookings available.")
        else:
            for pnr, details in self.bookings.items():
                print(f"PNR: {pnr}, Name: {details['name']}, Train: {details['train']}, Seats: {details['seats']}, Fare: ₹{details['amount']}")

    def run(self):
        while True:
            print("\nRailway Reservation System")
            print("1. View Trains")
            print("2. Book Ticket")
            print("3. Cancel Ticket")
            print("4. View Bookings")
            print("5. Exit")
            choice = input("Enter your choice: ")

            if choice == "1":
                self.view_trains()
            elif choice == "2":
                self.book_ticket()
            elif choice == "3":
                self.cancel_ticket()
            elif choice == "4":
                self.view_bookings()
            elif choice == "5":
                print("\nThank you for using the Railway Reservation System!")
                break
            else:
                print("\nInvalid choice! Please try again.")

# Run the Railway Reservation System
system = RailwayReservationSystem()
system.run()






Railway Reservation System
1. View Trains
2. Book Ticket
3. Cancel Ticket
4. View Bookings
5. Exit
Enter your choice: 1

Available Trains:
Train No: 101, Name: Express Train, Seats Available: 5, Price: ₹500
Train No: 102, Name: Superfast Train, Seats Available: 3, Price: ₹800
Train No: 103, Name: Rajdhani Express, Seats Available: 4, Price: ₹1200

Enter Train Number to Book: 101
Enter Passenger Name: John
Enter Number of Seats: 2

Booking Successful! PNR Number: 1, Total Fare: ₹1000
