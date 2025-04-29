package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    private List<Card> cardsInHand;

    public Hand() {
        cardsInHand = new ArrayList<>();
    }


    //Method that return true if there are three cards of the same type
    public boolean areThreeCardsOfTheSameType(){
        return (cardsInHand.stream().filter(card->card.getCardType().equals("Number")).count() == 3)||
                (cardsInHand.stream().filter(card->card.getCardType().equals("Letter")).count() == 3);
    }

    //Method that checks if the card types are all the same
    public boolean areAllTheSameType(){
        return (cardsInHand.stream().filter(card->card.getCardType().equals("Number")).count()==4)||
                (cardsInHand.stream().filter(card->card.getCardType().equals("Letter")).count()==4);
    }

    @Override
    public String toString() {
        return "Cards in hand: \n" + cardsInHand;
    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(List<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }
}
