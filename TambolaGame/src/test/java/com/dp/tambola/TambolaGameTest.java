package com.dp.tambola;

import com.dp.FullHouseWinningCondition;
import com.dp.Player;
import com.dp.TambolaGame;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TambolaGameTest {

    @Test
    void testGameFlow() {
        TambolaGame game = new TambolaGame(new FullHouseWinningCondition());
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        game.addPlayer(player1);
        game.addPlayer(player2);

        // Start the game
        game.startGame();

        // Call some numbers and test if the players are updated
        game.callNextNumber();  // This will call number 1
        game.callNextNumber();  // This will call number 2

        // Check if game proceeds correctly (no winners yet)
        assertFalse(player1.hasWon());
        assertFalse(player2.hasWon());

        // Simulate marking all numbers for player1 to win
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                player1.getTicket().markNumber(player1.getTicket().getTicket()[row][col]);
            }
        }

        // Check if player1 wins after ticket completion
        assertTrue(player1.hasWon());
        assertFalse(player2.hasWon());  // Player2 shouldn't have won yet
    }

    @Test
    void testFullHouseWinningCondition() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        TambolaGame game = new TambolaGame(new FullHouseWinningCondition());

        game.addPlayer(player1);
        game.addPlayer(player2);

        // Simulate game start and calling numbers
        game.startGame();
        game.callNextNumber();  // Call 1
        game.callNextNumber();  // Call 2
        game.callNextNumber();  // Call 3

        // Mark all numbers for player1 to win
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                player1.getTicket().markNumber(player1.getTicket().getTicket()[row][col]);
            }
        }

        // Check that player1 has won
       // assertTrue(player1.hasWon());
        assertFalse(player2.hasWon());  // Player2 should not have won
    }
}
