package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    private List<Card> cardsInHand;

    public Hand() {
        cardsInHand = new ArrayList<>();
    }

    //Method that count the number of cards of the same Number type
    public long numberOfNumberTypeCards(){
        return cardsInHand.stream().filter(card->card.getCardType().equals("Number")).count();
    }

    //Method that count the number of cards of the same Letter type
    public long numberOfLetterTypeCards(){
        return cardsInHand.stream().filter(card->card.getCardType().equals("Letter")).count();
    }

    //Method that checks if the card types are all the same
    public boolean areAllTheSameType(){
        return (cardsInHand.stream().filter(card->card.getCardType().equals("Number")).count()==4)||
                (cardsInHand.stream().filter(card->card.getCardType().equals("Letter")).count()==4);
    }

    //Method that return the card selected and put it in the board
    public Card putCardInBoard(int cardPosition){
        return cardsInHand.get(cardPosition);
    }

    //



    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(List<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }
}
