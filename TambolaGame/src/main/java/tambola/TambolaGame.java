package tambola;



import com.tambola.Player;
import com.tambola.WinCondition;

import java.util.*;

class TambolaGame {
    public static final int BOUND = 100;
    private final List<Ticket> tickets = new ArrayList<>();
    private final Set<Integer> drawnNumbers = new HashSet<>();
    private final Random random = new Random();
    private final List<WinCondition> winConditions = new ArrayList<>();
    private final List<Player> players = new ArrayList<>();
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addWinCondition(WinCondition condition) {
        winConditions.add(condition);
    }
    public int drawNumber() {
        int number;
        do {
            number = random.nextInt(BOUND) + 1;
        } while (drawnNumbers.contains(number));
        drawnNumbers.add(number);
//        for (Player player : players) {
//            player.getTicket().markNumber(number);
//        }
        for (Ticket ticket : tickets) {
            ticket.markNumber(number);
        }
        return number;
    }

    public boolean checkWinner() {
        for (Ticket ticket : tickets) {
            if (ticket.isFullHouse()) {
                return true;
            }
        }
        return false;
    }

//    public boolean checkWinner() {
//        for (Player player : players) {
//            for (WinCondition condition : winConditions) {
//                if (condition.checkWin(player.getTicket())) {
//                    System.out.println(player.getName() + " has won!");
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}