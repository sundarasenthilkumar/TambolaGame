package com.tambola;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TambolaGameTest {
    private TambolaGame game;
    private Player player;

    @BeforeEach
    void setUp() {
        game = new TambolaGame();
        player = new Player("TestPlayer");
        game.addPlayer(player);
        game.addWinCondition(new FullHouseWin());
    }

    @Test
    void testDrawNumber() {
        int drawn = game.drawNumber();
        assertTrue(drawn >= 1 && drawn <= 90);
    }

    @Test
    void testMarkNumber() {
        player.getTicket().markNumber(5);
        assertFalse(player.getTicket().isFullHouse());
    }

    @Test
    void testWinningCondition() {
        Ticket ticket = player.getTicket();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                ticket.markNumber(ticket.numbers[i][j]);
            }
        }
        assertTrue(ticket.isFullHouse());
    }
}
