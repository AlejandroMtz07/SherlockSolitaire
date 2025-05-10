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
    public void addCard(Card card,DiscardDeck discardDeck,Player player) {
        crimeSceneCards.add(card);
        if(areTwoCardsOfAnyValue()){
            discardDeck.addCard(card);
            crimeSceneCards.remove(card);
            player.makeAWound();
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
    public boolean areTwoCardsOfAnyValue() {
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

    /*
    * TODO
    *  Make a method that check which power is activated
    * */
    public String checkPower(){
        if(areTwoCardsOfInvestigation(Numbers.ONE)){
            return "Move a card to the office from the crime scene";
        }
        if(areTwoCardsOfInvestigation(Numbers.TWO)){
            return "Threat";
        }
        if(areTwoCardsOfInvestigation(Numbers.THREE)){
            return "Move a card to the crime scene to the office";
        }
        if(areTwoCardsOfInvestigation(Numbers.FOUR)){
            return "Take a card of the discard";
        }
        return "Nothin";
    }



    /*
    * Method that reset the number of cards placed in the crime scene
    */
    public void resetCardsPlaced() {
        cardsPlaced = 0;
    }

    public String toString(){
        return "Crime scene cards: \n"+((getCrimeSceneCards()==null)?"Nothin":getCrimeSceneCards());
    }

    public List<Card> getCrimeSceneCards() {
        return crimeSceneCards;
    }

    public int getCardsPlaced() {
        return cardsPlaced;
    }

    public void setCardsPlaced(int cardsPlaced) {
        this.cardsPlaced = cardsPlaced;
    }
}
