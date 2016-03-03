package blackjack;

import blackjack.Utils.SUIT;
import blackjack.Utils.RANK;
import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author ANI
 */

public class Deck {

    int deckSize = 52;
    Stack<Card> deck = new Stack<Card>();

    public Deck() {
        initPack();
    }

    public void initPack() {
        for (int i = 0; i < SUIT.values().length; i++) {
            for (int j = 0; j < RANK.values().length; j++) {
                deck.push(Card.createCard(i, j));
            }
        }
        Collections.shuffle(deck);
    }

    // Draws one card and retunrns it, 
    //if there no cards left it will return null
    public Card drawCard(boolean faceUp) {
        if (deck.size() > 0) {
            Card newCard = deck.pop();
            if (faceUp) {
                newCard.reveal();
            }
            return newCard;
        } else {
            return null;
        }
    }

    // Default drawOne
    public Card drawCard() {
        return drawCard(true);
    }

    public void reshuffle() {
        initPack();
    }

}
