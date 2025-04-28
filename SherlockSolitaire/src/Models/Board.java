package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Card> cards;
    private List<Card> discards;
    private Deck deck;


    public Board() {
        cards = new ArrayList<>();
        discards = new ArrayList<>();
        deck = new Deck();
    }

    public void giveCards(Hand hand){
        hand.setCardsInHand(deck.getCards().subList(0,4));
    }


}
