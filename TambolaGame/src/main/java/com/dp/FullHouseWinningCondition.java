package com.dp;

public class FullHouseWinningCondition implements WinningCondition {
    @Override
    public boolean hasPlayerWon(Player player) {
        // Check if the player's ticket is complete (all numbers marked)
        return player.getTicket().isTicketComplete();
    }
}
