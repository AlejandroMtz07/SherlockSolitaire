package Models;

import java.util.ArrayList;
import java.util.List;

public class DiscardDeck {

    List<Card> discardDeck;

    public DiscardDeck() {
        discardDeck = new ArrayList<Card>();
    }

    //TODO Add method send discarded cars to the deck
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

    public String toString(){
        return "Discard deck cards: "+((getDiscardDeck()==null)?"Nothin":getDiscardDeck());
    }

}
