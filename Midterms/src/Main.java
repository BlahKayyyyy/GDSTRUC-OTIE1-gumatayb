import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Player Hand, Player Deck, & Discard Pile
        CardStack playerDeck = new CardStack(30);
        CardStack playerHand = new CardStack(30);
        CardStack discardPile = new CardStack(30);

        // Player Deck with 30 cards
        for (int i = 1; i <= 30; i++) {
            playerDeck.push(new Card("Card#" + i));
        }

        System.out.println("Card Game Started!");
        System.out.println("The program ends when the player deck is emptied.\n");

        int turnCount = 1;

        // Ends when player has empty deck
        while (!playerDeck.isEmpty()) {
            System.out.println("----------------------------------------");
            System.out.println("--- Turn " + turnCount + " ---");

            // Random command
            int commandType = random.nextInt(3) + 1;
            int x = random.nextInt(5) + 1;

            switch (commandType) {
                case 1: // Draw x cards from deck to hand
                    System.out.println("Command: Draw " + x + " card(s) from the deck.");
                    for (int i = 0; i < x; i++) {
                        if (playerDeck.isEmpty()) {
                            System.out.println("  -> Deck is empty! Cannot draw anymore.");
                            break;
                        }
                        Card drawn = playerDeck.pop();
                        playerHand.push(drawn);
                        System.out.println("  -> Drew: " + drawn.getName());
                    }
                    break;

                case 2: // Discard x cards from hand to discard pile
                    System.out.println("Command: Discard " + x + " card(s) from your hand.");
                    for (int i = 0; i < x; i++) {
                        if (playerHand.isEmpty()) {
                            System.out.println("  -> Hand is empty! No cards to discard.");
                            break;
                        }
                        Card discarded = playerHand.pop();
                        discardPile.push(discarded);
                        System.out.println("  -> Discarded: " + discarded.getName());
                    }
                    break;

                case 3: // Get x cards from the discarded pile back to player hand
                    System.out.println("Command: Get " + x + " card(s) from the discarded pile.");
                    for (int i = 0; i < x; i++) {
                        if (discardPile.isEmpty()) {
                            System.out.println("  -> Discard pile is empty! No cards to retrieve.");
                            break;
                        }
                        Card retrieved = discardPile.pop();
                        playerHand.push(retrieved);
                        System.out.println("  -> Retrieved from discard: " + retrieved.getName());
                    }
                    break;
            }

            // Display info
            System.out.println("\n--- Round Status ---");
            System.out.print("• List of cards currently holding (Hand): ");
            if (playerHand.isEmpty()) {
                System.out.println("[Empty]");
            } else {
                playerHand.printStack();
                System.out.println();
            }
            System.out.println("• Number of remaining cards in player deck: " + playerDeck.size());
            System.out.println("• Number of cards in the discarded pile: " + discardPile.size());

            if (playerDeck.isEmpty()) {
                break;
            }


            System.out.print("\nPress Enter to proceed to the next turn...");
            scanner.nextLine();
            turnCount++;
        }

        System.out.println("Game Over! The player deck has been emptied.");

        scanner.close();
    }
}