package com.tambola;
public class RowWin implements WinCondition {
    private final int rowIndex;

    public RowWin(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    @Override
    public boolean checkWin(Ticket ticket) {
        return ticket.isRowComplete(rowIndex);
    }
}
