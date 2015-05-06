import java.util.*;


class Deck {
    // create possible card combinations
    public final String[] SUITS = { "H", "D", "C", "S" };
    public final String[] RANKS = { "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2" };

    // maximum number of cards
    public final int deckLength = SUITS.length * RANKS.length;
    public List<String> fullDeck = new ArrayList<>();

    public Deck() {
        for(int i = 0; i < SUITS.length; i++) {
            for(int j = 0; j < RANKS.length; j++) {
                fullDeck.add(RANKS[j] + SUITS[i]);
            }
        }
   }

    public Deck(List<String> fullDeck) {
        this.fullDeck = fullDeck;
        for(int i = 0; i < SUITS.length; i++) {
            for(int j = 0; j < RANKS.length; j++) {
                fullDeck.add(RANKS[j] + SUITS[i]);
            }
        }
    }

    public List<String> shuffle(List<String> fullDeck) {
        this.fullDeck = fullDeck;
        Collections.shuffle(fullDeck);
        return fullDeck;
    }

    // this was mainly used for testing purposes
    // to ensure shuffling was indeed taking place
    public void showDeck(List<String> fullDeck) {
        this.fullDeck = fullDeck;
        for(int i = 0; i < deckLength; i++) {
            System.out.printf("%s ",fullDeck.get(i));
        }
    }
}

class Hands extends Deck {

    public String[] hand = new String[2];
    Random random = new Random();

    // select 2 cards to distribute to player
    public String[] getHand(List<String> fullDeck) {
        super.fullDeck = fullDeck;
        for(int i = 0; i < this.hand.length; i++) {
            this.hand[i] = fullDeck.get(random.nextInt(super.deckLength));
        }
        return this.hand;
    }

    // show player hand
    public void showHand() {
        for(int i = 0; i < this.hand.length; i++) {
            System.out.printf("%s ", this.hand[i]);

        }
    }
}

