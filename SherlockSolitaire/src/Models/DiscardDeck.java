package Models;

import java.util.ArrayList;
import java.util.List;

public class DiscardDeck {

    List<Card> discardDeck;

    public DiscardDeck() {
        discardDeck = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        discardDeck.add(card);
    }

    /*
    * Method that takes a position and return the corresponding card
    */
    public Card extractCard(int index) {
        return discardDeck.remove(index);
    }


    public List<Card> getDiscardDeck() {
        return discardDeck;
    }

    @Override
    public String toString(){
        return "Discard deck cards: "+((getDiscardDeck().isEmpty())?"Nothin":getDiscardDeck());
    }

}
