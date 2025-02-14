package tambola;

import java.util.*;

class Ticket {
    private final int[][] numbers;
    private final boolean[][] marked;

    public Ticket(int[][] numbers) {
        this.numbers = numbers;
        this.marked = new boolean[numbers.length][numbers[0].length];
    }

    public void markNumber(int number) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] == number) {
                    marked[i][j] = true;
                }
            }
        }
    }

    public boolean isFullHouse() {
        for (boolean[] row : marked) {
            for (boolean mark : row) {
                if (!mark) return false;
            }
        }
        return true;
    }
}

class TambolaGame {
    private final List<Ticket> tickets = new ArrayList<>();
    private final Set<Integer> drawnNumbers = new HashSet<>();
    private final Random random = new Random();
    
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    
    public int drawNumber() {
        int number;
        do {
            number = random.nextInt(90) + 1;
        } while (drawnNumbers.contains(number));
        drawnNumbers.add(number);
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
}

public class Tambola {
    public static void main(String[] args) {
        TambolaGame game = new TambolaGame();
        
        Ticket ticket1 = new Ticket(new int[][] {{1, 16, 31}, {46, 61, 76}, {5, 20, 35}});
        Ticket ticket2 = new Ticket(new int[][] {{2, 17, 32}, {47, 62, 77}, {6, 21, 36}});
        
        game.addTicket(ticket1);
        game.addTicket(ticket2);
        
        while (!game.checkWinner()) {
            int drawn = game.drawNumber();
            System.out.println("Number drawn: " + drawn);
        }
        System.out.println("We have a winner!");
    }
}
