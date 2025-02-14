package com.tambola;
public class FullHouseWin implements WinCondition {
    @Override
    public boolean checkWin(Ticket ticket) {
        return ticket.isFullHouse();
    }
}
