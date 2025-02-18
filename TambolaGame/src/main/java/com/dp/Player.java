package com.dp;

import java.util.Observable;
import java.util.Observer;
public class Player implements Observer {
    private String name;
    private Ticket ticket;
    private boolean hasWon;

    public Player(String name) {
        this.name = name;
        this.ticket = new Ticket();  // Each player gets a ticket
        this.hasWon = false;
        ticket.printTicket();  // Print the ticket when player is created
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof TambolaGame) {
            int numberCalled = (int) arg;
            ticket.markNumber(numberCalled);  // Mark the number on the ticket
            System.out.println(name + " received number " + numberCalled);

            // Check if the player has won
            if (!hasWon && ticket.isTicketComplete()) {
                hasWon = true;
                notifyWinner();
            }
        }
    }

    public Ticket getTicket() {
        return ticket;
    }

    public boolean hasWon() {
        return hasWon;
    }

    public String getName() {
        return name;
    }

    public void notifyWinner() {
        System.out.println(name + " has completed their ticket and WON the game!");
    }
}
