package com.tambola;
public class Tambola {
    public static void main(String[] args) {
        TambolaGame game = new TambolaGame();
        
        game.addPlayer(new Player("Alice"));
        game.addPlayer(new Player("Bob"));
        
        game.addWinCondition(new FullHouseWin());
        game.addWinCondition(new RowWin(0)); // First row win
        game.addWinCondition(new RowWin(1)); // Middle row win
        game.addWinCondition(new RowWin(2)); // Last row win
        
        while (!game.checkWinner()) {
            int drawn = game.drawNumber();
            System.out.println("Number drawn: " + drawn);
        }
    }
}
