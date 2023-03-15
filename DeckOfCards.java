import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards
{
    private List<Card> deck;

    public DeckOfCards() {
        deck = new ArrayList<>();
        for (String suit : Card.suits) {
            for (String rank : Card.ranks) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public List<Card>[] deal(int numPlayers, int numCards) {
        if (numPlayers * numCards > deck.size()) {
            throw new IllegalArgumentException("Not enough cards in the deck.");
        }
        List<Card>[] players = new List[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            players[i] = new ArrayList<>();
        }
        for (int j = 0; j < numCards; j++) {
            for (int i = 0; i < numPlayers; i++) {
                players[i].add(deck.remove(0));
            }
        }
        return players;
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        List<Card>[] players = deck.deal(4, 9);
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ": " + players[i]);
        }
    }
}

class Card {
    public static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
