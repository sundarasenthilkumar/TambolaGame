package com.dp;

public class TambolaMain {
    public static void main(String[] args) {
        // Create a new game with FullHouseWinningCondition
        TambolaGame game = new TambolaGame(new FullHouseWinningCondition());

        // Create players
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        // Add players to the game
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Start the game
        game.startGame();

        // Call numbers
        for (int i = 0; i < 12; i++) {  // Try calling 12 numbers (even though we have only 10)
            game.callNextNumber();
            try {
                Thread.sleep(1000);  // Wait for 1 second between number calls
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
