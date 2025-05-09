package Models;

import Enums.Letters;
import Enums.Numbers;

import java.util.ArrayList;
import java.util.List;

public class CrimeScene {

    private final List<Card> crimeSceneCards;
    private int cardsPlaced;


    public CrimeScene(){
        crimeSceneCards = new ArrayList<>();
        cardsPlaced = 0;
    }

    /*
    * Method that adds a card in the CrimeScene list checking if exist another card
    * with the same value in the crimeSceneCards list
    */
    public void addCard(Card card,DiscardDeck discardDeck) {
        crimeSceneCards.add(card);
        if(areTwoCardsOfAnyType()){
            discardDeck.addCard(card);
            crimeSceneCards.remove(card);
        }
    }

    /*
    * Method that checks if are two cards of the investigation in the crime scene
    * using Java streams and counting the number of cards
    */
    private boolean areTwoCardsOfInvestigation(Numbers number) {
        return crimeSceneCards
                .stream()
                .filter(card->{
                    if(card.getNumberValue()==null) return false;
                    return  card.getNumberValue().equals(number);
                })
                .count()==2;
    }

    /*
    * Method that checks if are two cards of Threat in the crimeScene card list
    * using java stream and counting if are two
    * if there are two cards of threat returns true otherwise returns false
    */
    private boolean areTwoCardsOfThreat(Letters letter) {
        return crimeSceneCards
                .stream()
                .filter(card -> {
                    if (card.getLetterValue() == null) return false;
                    return card.getLetterValue().equals(letter);
                })
                .count()==2;
    }

    /*
    * Method that use the areTwoCardsOfThreat and areTwoCardsOfInvestigation methods
    * and returns false if there aren't two cards of the same value
    */
    public boolean areTwoCardsOfAnyType() {
        return (areTwoCardsOfInvestigation(Numbers.ONE)||
                areTwoCardsOfInvestigation(Numbers.TWO)||
                areTwoCardsOfInvestigation(Numbers.THREE)||
                areTwoCardsOfInvestigation(Numbers.FOUR)
                        ||(areTwoCardsOfThreat(Letters.A)
                        ||areTwoCardsOfThreat(Letters.B)
                        ||areTwoCardsOfThreat(Letters.C)
                        ||areTwoCardsOfThreat(Letters.D))
        );
    }

    public String toString(){
        return "Crime scene cards: "+((getCrimeSceneCards()==null)?"Nothin":getCrimeSceneCards());
    }

    public List<Card> getCrimeSceneCards() {
        return crimeSceneCards;
    }

    public int getCardsPlaced() {
        return cardsPlaced;
    }
}
