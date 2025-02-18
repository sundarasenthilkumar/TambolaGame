package com.dp.tambola;

import com.dp.Player;
import com.dp.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayerTicket() {
        Player player = new Player("Alice");
        Ticket ticket = player.getTicket();

        // Ensure the player has a ticket
        assertNotNull(ticket);

        // Verify that the ticket is not complete initially
        assertFalse(ticket.isTicketComplete());
    }

    @Test
    void testMarkingNumbers() {
        Player player = new Player("Alice");
        Ticket ticket = player.getTicket();

        // Mark some numbers
        ticket.markNumber(ticket.getTicket()[0][0]);
        ticket.markNumber(ticket.getTicket()[1][1]);

        // Verify that the numbers are marked
        assertTrue(ticket.getMarked()[0][0]);
        assertTrue(ticket.getMarked()[1][1]);
    }

    @Test
    void testPlayerWin() {
        Player player = new Player("Alice");
        Ticket ticket = player.getTicket();

        // Mark all numbers on the ticket
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                ticket.markNumber(ticket.getTicket()[row][col]);
            }
        }

        // Verify that the ticket is complete
        assertTrue(ticket.isTicketComplete());
    }
}
