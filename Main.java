import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main
{
    public static void main(String[] args)
    {
        CardStack playerDeck = new CardStack();
        CardStack discardedPile = new CardStack();

        // Create and shuffle the player's deck with 30 cards
        //Tarot Cards from Cult of the Lamb
        List<Card> allCards = new ArrayList<>();
        String[] TarotCards = {"The Hearts I Tarot Card", "The Hearts II Tarot Card", "The Hearts III Tarot Card", "Weeping Moon Tarot Card",
                "Nature's Boon Tarot Card", "The Lovers I Tarot Card", "The Lovers II Tarot Card", "All Seeing Sun Tarot Card", "True Sight Tarot Card",
        "Telescope Tarot Card", "Hands of Rage Tarot Card", "The Burning Dead Tarot Card", "Diseased Heart Tarot Card"}; // I think that will be all for now

        for (int i = 0; i < 30; i++)
        {
            String CustomCardName = TarotCards[i % TarotCards.length]; // Reuse names of Tarot cards
            Card card = new Card(CustomCardName);
            allCards.add(card);
        }
        playerDeck.addAll(allCards);
        playerDeck.shuffle();

        // Game loop
        while (!playerDeck.isEmpty())
        {
            {
                int randomCommand = new Random().nextInt(3);

                switch (randomCommand)
                {
                    case 0:
                        int numDraw = new Random().nextInt(5) + 1; // Randomly draw 1 to 5 cards
                        System.out.println("DRAWING " + numDraw + " Cards.");
                        for (int j = 0; j < numDraw && !playerDeck.isEmpty(); j++)
                        {
                            Card drawnCard = playerDeck.pop();
                            System.out.println("DRAWN Cards: " + drawnCard.getName());
                        }
                        break;
                    case 1:
                        int numDiscard = new Random().nextInt(5) + 1; // Commands given at Random Value between 1-5 (Discard a Card)
                        System.out.println("DISCARDED " + numDiscard + " Cards.");
                        for (int j = 0; j < numDiscard && !playerDeck.isEmpty(); j++)
                        {
                            Card discardedCard = playerDeck.pop();
                            discardedPile.push(discardedCard);
                            System.out.println("DISCARDED: " + discardedCard.getName());
                        }
                        break;
                    case 2:
                        int numGet = new Random().nextInt(5) + 1; // Commands given at Random Value between 1-5 (Discarded Pile)
                        System.out.println("Getting " + numGet + " cards from the discarded pile.");
                        for (int j = 0; j < numGet && !discardedPile.isEmpty(); j++)
                        {
                            Card retrievedCard = discardedPile.pop();
                            playerDeck.push(retrievedCard);
                            System.out.println("CARDS RETRIEVED: " + retrievedCard.getName());
                        }
                        break;
                }
            }

            // Display game info after each round
            System.out.println("CURRENT HAND of the Player: " + playerDeck.size() + " Tarot cards");
            System.out.println("REMAINING CARD IN DECK: " + playerDeck.size());
            System.out.println("Number of cards in the DISCARDED PILE: " + discardedPile.size());
            System.out.println();
        }


        System.out.println("Deck is empty. Game over!");
    }
}
