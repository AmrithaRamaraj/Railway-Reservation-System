#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_TICKETS 10

// Structure to store passenger details
struct Ticket {
    int ticket_id;
    char name[50];
    int age;
    char train_name[50];
    char source[50];
    char destination[50];
};

// Global array to store ticket bookings
struct Ticket tickets[MAX_TICKETS];
int ticket_count = 0;

// Function to book a ticket
void bookTicket() {
    if (ticket_count >= MAX_TICKETS) {
        printf("Sorry, no more tickets available!\n");
        return;
    }

    struct Ticket newTicket;
    newTicket.ticket_id = ticket_count + 1;
    
    printf("Enter passenger name: ");
    scanf(" %[^\n]", newTicket.name);

    printf("Enter passenger age: ");
    scanf("%d", &newTicket.age);

    printf("Enter train name: ");
    scanf(" %[^\n]", newTicket.train_name);

    printf("Enter source station: ");
    scanf(" %[^\n]", newTicket.source);

    printf("Enter destination station: ");
    scanf(" %[^\n]", newTicket.destination);

    tickets[ticket_count] = newTicket;
    ticket_count++;

    printf("\nTicket booked successfully! Ticket ID: %d\n\n", newTicket.ticket_id);
}

// Function to display all booked tickets
void displayTickets() {
    if (ticket_count == 0) {
        printf("No tickets booked yet.\n");
        return;
    }

    printf("\n--- Ticket List ---\n");
    for (int i = 0; i < ticket_count; i++) {
        printf("Ticket ID: %d\n", tickets[i].ticket_id);
        printf("Passenger Name: %s\n", tickets[i].name);
        printf("Age: %d\n", tickets[i].age);
        printf("Train: %s\n", tickets[i].train_name);
        printf("Source: %s\n", tickets[i].source);
        printf("Destination: %s\n", tickets[i].destination);
        printf("----------------------\n");
    }
}

// Function to cancel a ticket
void cancelTicket() {
    if (ticket_count == 0) {
        printf("No tickets to cancel.\n");
        return;
    }

    int ticket_id;
    printf("Enter Ticket ID to cancel: ");
    scanf("%d", &ticket_id);

    int found = 0;
    for (int i = 0; i < ticket_count; i++) {
        if (tickets[i].ticket_id == ticket_id) {
            found = 1;
            for (int j = i; j < ticket_count - 1; j++) {
                tickets[j] = tickets[j + 1];  // Shift tickets
            }
            ticket_count--;
            printf("Ticket ID %d has been canceled successfully!\n", ticket_id);
            break;
        }
    }

    if (!found) {
        printf("Ticket ID not found.\n");
    }
}

// Main function
int main() {
    int choice;

    while (1) {
        printf("\n=== Railway Reservation System ===\n");
        printf("1. Book Ticket\n");
        printf("2. View Booked Tickets\n");
        printf("3. Cancel Ticket\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                bookTicket();
                break;
            case 2:
                displayTickets();
                break;
            case 3:
                cancelTicket();
                break;
            case 4:
                printf("Thank you for using the Railway Reservation System!\n");
                exit(0);
            default:
                printf("Invalid choice! Please try again.\n");
        }
    }

    return 0;
}







=== Railway Reservation System ===
1. Book Ticket
2. View Booked Tickets
3. Cancel Ticket
4. Exit
Enter your choice: 1



