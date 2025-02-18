package com.dp;

import java.util.*;

public class TambolaGame extends Observable {
    private Queue<Integer> numbersCalled;
    private boolean gameInProgress;
    private List<Player> players;
    private WinningCondition winningCondition;
    private boolean gameEnded;

    public TambolaGame(WinningCondition winningCondition) {
        this.numbersCalled = new LinkedList<>();
        this.gameInProgress = false;
        this.players = new ArrayList<>();
        this.winningCondition = winningCondition;
        this.gameEnded = false; // Initially, the game has not ended
    }

    // Add players to the game
    public void addPlayer(Player player) {
        players.add(player);
        addObserver(player);  // Add player as an observer
    }

    // Start the game by adding numbers
    public void startGame() {
        gameInProgress = true;
        // Add numbers 1 to 10 for simplicity
        for (int i = 1; i <= 10; i++) {
            numbersCalled.add(i);
        }
        setChanged();  // Mark the game as changed to notify observers
    }

    // Call the next number and notify players
    public void callNextNumber() {
        if (numbersCalled.isEmpty() || gameEnded) {
            // Stop the game if numbers are exhausted or a player has won
            gameInProgress = false;
            System.out.println("Game Over!");
            return;
        }

        int number = numbersCalled.poll();
        System.out.println("Calling number: " + number);
        setChanged();
        notifyObservers(number);

        // Check if any player has won after each number is called
        checkForWinners();
    }

    // Check for winners after each number is called
    private void checkForWinners() {
        for (Player player : players) {
            if (winningCondition.hasPlayerWon(player) && !player.hasWon()) {
                player.notifyWinner();  // Notify the winner
                gameEnded = true;  // Mark the game as ended
                return;  // Stop checking for other winners once one has won
            }
        }
    }

    // Check if the game is in progress
    public boolean isGameInProgress() {
        return gameInProgress;
    }
}

