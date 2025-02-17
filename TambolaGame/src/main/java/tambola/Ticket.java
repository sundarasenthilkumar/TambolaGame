package tambola;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Ticket {
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

    public static Ticket generateRandomTicket() {
        Random random = new Random();
        int[][] numbers = new int[3][5];
        Set<Integer> usedNumbers = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int num;
                do {
                    num = random.nextInt(90) + 1;
                } while (usedNumbers.contains(num));
                numbers[i][j] = num;
                usedNumbers.add(num);
            }
        }
        return new Ticket(numbers);
    }


}
