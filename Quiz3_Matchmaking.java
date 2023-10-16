import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Quiz3_Matchmaking {
    public static void main(String[] args) {
        Random random = new Random();
        Queue<String> playerQueue = new LinkedList<>();
        int gamesMade = 0;
        int gameCounter = 1;

        while (gamesMade < 10) {
            // Simulate adding random players to the queue
            int playersToAdd = random.nextInt(7) + 1;

            System.out.println("Enqueuing " + playersToAdd + " players for Game " + gameCounter + ":");

            for (int i = 0; i < playersToAdd; i++) {
                playerQueue.offer("Player " + (i + 1));
                System.out.println("Player " + (i + 1) + " has been enqueued.");
            }

            // Check if there are enough players to start a game
            while (playerQueue.size() >= 5) {
                System.out.println("Game " + gameCounter + " Started!");
                for (int i = 0; i < 5; i++) {
                    String player = playerQueue.poll();
                    System.out.println("Player " + player + " has been dequeued.");
                }
                gamesMade++;
                gameCounter++;
            }

            System.out.println("Turn ended");
            System.out.println(" ");
        }

        System.out.println("10 games have been successfully made. Program terminated.");
    }
}
