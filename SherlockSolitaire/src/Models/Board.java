package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Card> crimeSceneCards;
    private List<Card> officeCards;
    private Deck deck;


    public Board() {
        crimeSceneCards = new ArrayList<>();
        officeCards = new ArrayList<>();
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
    public boolean addCrimeSceneCard(Hand hand,int position){
        if(position>hand.getCardsInHand().size()){
            return false;
        }
        crimeSceneCards.add(hand.getCardsInHand().get(position));
        hand.getCardsInHand().remove(position);
        return true;
    }
    //Method that checks if the card selected is correct and put it into the office list
    public boolean addOfficeCard(Hand hand,int position){
        if(position>hand.getCardsInHand().size()){
            return false;
        }
        officeCards.add(hand.getCardsInHand().get(position));
        hand.getCardsInHand().remove(position);
        return true;
    }


    public List<Card> getCrimeSceneCards() {
        return crimeSceneCards;
    }

    public void setCrimeSceneCards(List<Card> crimeSceneCards) {
        this.crimeSceneCards = crimeSceneCards;
    }

    public List<Card> getOfficeCards() {
        return officeCards;
    }

    public void setOfficeCards(List<Card> officeCards) {
        this.officeCards = officeCards;
    }
}
