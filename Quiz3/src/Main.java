import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayQueue queue = new ArrayQueue(5);

        int gamesCreated = 0;
        int nextPlayerId = 1;

        System.out.println("Matchmaking Simulation");
        System.out.println("Goal: Create 10 games (5 players per game). Press [ENTER] to advance each turn.\n");

        while (gamesCreated < 10) {
            System.out.print("Press [ENTER] to start the next turn...");
            scanner.nextLine();

            // Every turn players will be enqueued for matchmaking
            int x = random.nextInt(7) + 1;
            System.out.println("\n--- Turn Action ---");
            System.out.println("Enqueueing " + x + " new players...");

            for (int i = 0; i < x; i++) {
                String playerName = "Player_" + nextPlayerId;
                int playerRating = random.nextInt(1000) + 1;

                Player newPlayer = new Player(nextPlayerId, playerName, playerRating);
                queue.enqueue(newPlayer);
                nextPlayerId++;
            }

            // Print the current queue status
            queue.printQueue();
            System.out.println("Total players in queue: " + queue.size());

            // Game starts when at least 5 players are in the queue, dequeue the first 5
            while (queue.size() >= 5) {
                gamesCreated++;
                System.out.println("\n[Match Found! Starting Game #" + gamesCreated + "]:");

                for (int p = 0; p < 5; p++) {
                    Player matchedPlayer = queue.dequeue();
                    System.out.println(" -> Dequeued for match: " + matchedPlayer);
                }

                System.out.println("Successful games created: " + gamesCreated + "/10\n");
                
                if (gamesCreated >= 10) {
                    break;
                }
            }

            if (gamesCreated >= 10) {
                break;
            }

            System.out.println("----------------------------------------");
        }

        System.out.println("\nSimulation Complete!");
        System.out.println("Successfully created all 10 games[cite: 1]!");
        scanner.close();
    }
}