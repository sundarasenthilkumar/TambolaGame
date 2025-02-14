package tambola;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TambolaGameTest {
    private TambolaGame game;
    private Ticket ticket;

    @BeforeEach
    void setUp() {
        game = new TambolaGame();
        ticket = new Ticket(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        game.addTicket(ticket);
    }

    @Test
    void testDrawNumber() {
        int drawn = game.drawNumber();
        assertTrue(drawn >= 1 && drawn <= 90);
    }

    @Test
    void testMarkNumber() {
        ticket.markNumber(5);
        assertFalse(ticket.isFullHouse());
    }

    @Test
    void testWinningCondition() {
        for (int i = 1; i <= 9; i++) {
            ticket.markNumber(i);
        }
        assertTrue(ticket.isFullHouse());
    }

    @Test
    void testGameFlow() {
        TambolaGame newGame = new TambolaGame();
        Ticket testTicket = new Ticket(new int[][] {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}});
        newGame.addTicket(testTicket);

        while (!newGame.checkWinner()) {
            newGame.drawNumber();
        }
        assertTrue(newGame.checkWinner());
    }

    @Test
    void testMultipleTicketsWinning() {
        TambolaGame newGame = new TambolaGame();
        Ticket ticket1 = new Ticket(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Ticket ticket2 = new Ticket(new int[][] {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}});
        newGame.addTicket(ticket1);
        newGame.addTicket(ticket2);

        for (int i = 1; i <= 90; i++) {
            newGame.drawNumber();
        }
        assertTrue(newGame.checkWinner());
    }
}
