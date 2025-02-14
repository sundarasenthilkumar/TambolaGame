package com.tambola;
import java.util.*;

public class TambolaGame {
    private final List<Player> players = new ArrayList<>();
    private final Set<Integer> drawnNumbers = new HashSet<>();
    private final Random random = new Random();
    private final List<WinCondition> winConditions = new ArrayList<>();
    
    public void addPlayer(Player player) {
        players.add(player);
    }
    
    public void addWinCondition(WinCondition condition) {
        winConditions.add(condition);
    }
    
    public int drawNumber() {
        int number;
        do {
            number = random.nextInt(90) + 1;
        } while (drawnNumbers.contains(number));
        drawnNumbers.add(number);
        for (Player player : players) {
            player.getTicket().markNumber(number);
        }
        return number;
    }
    
    public boolean checkWinner() {
        for (Player player : players) {
            for (WinCondition condition : winConditions) {
                if (condition.checkWin(player.getTicket())) {
                    System.out.println(player.getName() + " has won!");
                    return true;
                }
            }
        }
        return false;
    }
}
