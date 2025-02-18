package com.dp.tambola;

import com.dp.FullHouseWinningCondition;
import com.dp.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FullHouseWinningConditionTest {

    @Test
    void testFullHouseWinningCondition() {
        Player player = new Player("Alice");
        FullHouseWinningCondition condition = new FullHouseWinningCondition();

        // Mark all numbers for player to simulate a win
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                player.getTicket().markNumber(player.getTicket().getTicket()[row][col]);
            }
        }

        // Check that the player wins
        assertTrue(condition.hasPlayerWon(player));
    }
}
