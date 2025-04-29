package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Deck deck;


    public Board() {
        deck = new Deck();
    }

    //Method that gives to the hand 4 cards
    public void giveCards(Hand hand){
        hand.setCardsInHand(deck.getCards().subList(0,4));
    }

    //Method that gives to the hand the last card in the cards deck
    public void giveACard(Hand hand){
        hand.getCardsInHand().add(deck.getCards().getLast());
    }

    //Method that add one card to the crimeScene list using the position of the cards in the hand
    public void addCrimeSceneCard(CrimeScene crimeScene, Hand hand, int cardPosition){
        crimeScene.addCard(hand.getCardsInHand().get(cardPosition));
        hand.getCardsInHand().remove(cardPosition);
    }
    //Method that checks if the card selected is correct and put it into the office list
    public void addOfficeCard(Office office,Hand hand,int cardPosition, int columnNumber){
        office.addCardToARow(hand.getCardsInHand().get(cardPosition),columnNumber);
        hand.getCardsInHand().remove(cardPosition);
    }

}
