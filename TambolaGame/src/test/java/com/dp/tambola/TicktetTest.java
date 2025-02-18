package com.dp.tambola;

import com.dp.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

class TicketTest {

    @Test
    void testTicketGeneration() {
        Ticket ticket = new Ticket();
        int[][] ticketNumbers = ticket.getTicket();

        // Validate that numbers are within correct ranges for each column
        for (int col = 0; col < 5; col++) {
            Set<Integer> columnNumbers = new HashSet<>();
            for (int row = 0; row < 3; row++) {
                columnNumbers.add(ticketNumbers[row][col]);
            }

            switch (col) {
                case 0:
                    assertTrue(columnNumbers.stream().allMatch(n -> n >= 1 && n <= 9));
                    break;
                case 1:
                    assertTrue(columnNumbers.stream().allMatch(n -> n >= 10 && n <= 19));
                    break;
                case 2:
                    assertTrue(columnNumbers.stream().allMatch(n -> n >= 20 && n <= 29));
                    break;
                case 3:
                    assertTrue(columnNumbers.stream().allMatch(n -> n >= 30 && n <= 39));
                    break;
                case 4:
                    assertTrue(columnNumbers.stream().allMatch(n -> n >= 40 && n <= 49));
                    break;
                default:
                    fail("Unexpected column");
            }
        }
    }

    @Test
    void testTicketCompletion() {
        Ticket ticket = new Ticket();
        assertFalse(ticket.isTicketComplete());  // Ticket should not be complete initially

        // Mark all numbers on the ticket
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                ticket.markNumber(ticket.getTicket()[row][col]);
            }
        }

        assertTrue(ticket.isTicketComplete());  // Ticket should be complete after marking all numbers
    }
}
