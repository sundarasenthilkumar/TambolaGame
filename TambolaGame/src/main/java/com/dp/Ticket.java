package com.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Ticket {
    private int[][] ticket;
    private boolean[][] marked;  // To track marked numbers
    private static final int ROWS = 3;
    private static final int COLS = 5;

    public Ticket() {
        ticket = new int[ROWS][COLS];
        marked = new boolean[ROWS][COLS];
        generateTicket();
    }

    // Generates the ticket with numbers in the specified format
    private void generateTicket() {
        Random rand = new Random();

        // We will keep track of the available numbers for each column range
        List<Integer> columnNumbers[] = new List[COLS];
        columnNumbers[0] = new ArrayList<>();  // Numbers between 1-9
        columnNumbers[1] = new ArrayList<>();  // Numbers between 10-19
        columnNumbers[2] = new ArrayList<>();  // Numbers between 20-29
        columnNumbers[3] = new ArrayList<>();  // Numbers between 30-39
        columnNumbers[4] = new ArrayList<>();  // Numbers between 40-49

        // Fill column numbers
        for (int i = 1; i <= 9; i++) columnNumbers[0].add(i);
        for (int i = 10; i <= 19; i++) columnNumbers[1].add(i);
        for (int i = 20; i <= 29; i++) columnNumbers[2].add(i);
        for (int i = 30; i <= 39; i++) columnNumbers[3].add(i);
        for (int i = 40; i <= 49; i++) columnNumbers[4].add(i);

        // Randomly place numbers in the ticket grid
        for (int col = 0; col < COLS; col++) {
            Collections.shuffle(columnNumbers[col]);  // Shuffle the numbers for randomness
            for (int row = 0; row < ROWS; row++) {
                ticket[row][col] = columnNumbers[col].get(row);  // Assign number to the ticket
            }
        }
    }

    // Mark the number when it's called
    public void markNumber(int number) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (ticket[row][col] == number) {
                    marked[row][col] = true;
                }
            }
        }
    }

    // Check if the ticket is complete (i.e., all numbers are marked)
    public boolean isTicketComplete() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (!marked[row][col]) {
                    return false;  // Return false if any number is not marked
                }
            }
        }
        return true;  // All numbers are marked
    }

    // Return the ticket as a 2D array of numbers
    public int[][] getTicket() {
        return ticket;
    }

    // Print the ticket for display purposes
    public void printTicket() {
        System.out.println("Ticket:");
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(ticket[row][col] + "\t");
            }
            System.out.println();
        }
    }

    // Return the marked status of the ticket (for testing)
    public boolean[][] getMarked() {
        return marked;
    }
}
