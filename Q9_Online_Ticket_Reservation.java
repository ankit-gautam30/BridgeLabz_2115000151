import java.util.*;

class Ticket {
    int ticketID;
    String customerName, movieName, seatNumber, bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket last;

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
    }

    public void removeTicket(int ticketID) {
        if (last == null) return;
        Ticket current = last, prev = null;
        do {
            if (current.next.ticketID == ticketID) {
                current.next = current.next.next;
                if (last.ticketID == ticketID) last = current;
                return;
            }
            current = current.next;
        } while (current != last);
    }

    public void displayTickets() {
        if (last == null) return;
        Ticket temp = last.next;
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != last.next);
    }

    public void searchTicket(String searchTerm) {
        if (last == null) return;
        Ticket temp = last.next;
        do {
            if (temp.customerName.equalsIgnoreCase(searchTerm) || temp.movieName.equalsIgnoreCase(searchTerm)) {
                System.out.println("Found Ticket - ID: " + temp.ticketID + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName);
                return;
            }
            temp = temp.next;
        } while (temp != last.next);
    }

    public int countTickets() {
        if (last == null) return 0;
        int count = 0;
        Ticket temp = last.next;
        do {
            count++;
            temp = temp.next;
        } while (temp != last.next);
        return count;
    }
}

public class Q9_Online_Ticket_Reservation {
    public static void main(String[] args) {
        TicketReservationSystem trs = new TicketReservationSystem();
        trs.addTicket(101, "Aman", "Inception", "A1", "10:00 AM");
        trs.addTicket(102, "Baman", "Interstellar", "B2", "1:00 PM");
        trs.addTicket(103, "Chahat", "Dunkirk", "C3", "4:00 PM");
        trs.displayTickets();
        trs.removeTicket(102);
        trs.displayTickets();
        trs.searchTicket("Inception");
        System.out.println("Total Tickets: " + trs.countTickets());
    }
}
