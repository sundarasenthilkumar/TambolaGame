package com.tambola;
public class Player {
    private final String name;
    private final Ticket ticket;
    
    public Player(String name) {
        this.name = name;
        this.ticket = Ticket.generateRandomTicket();
    }
    
    public String getName() {
        return name;
    }
    
    public Ticket getTicket() {
        return ticket;
    }
}
