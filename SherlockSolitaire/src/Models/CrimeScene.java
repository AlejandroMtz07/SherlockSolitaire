package Models;

import Enums.Letters;
import Enums.Numbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CrimeScene {

    List<Card> crimeSceneCards;


    public CrimeScene(){
        crimeSceneCards = new ArrayList<Card>();
    }

    //Method that adds a card in the CrimeScene list
    public void addCard(Card card) {
        crimeSceneCards.add(card);
    }

    //Method that checks if are two cards of the same value in the crime scene
    private boolean areTwoCardsOfInvestigation(Numbers number) {
        return crimeSceneCards
                .stream()
                .filter(card->{
                    if(card.getNumberValue()==null) return false;
                    return  card.getNumberValue().equals(number);
                })
                .count()>=2;
    }

    //Method that checks if are two cards of Threat in the crime scene
    private boolean areTwoCardsOfThreat(Letters letter) {
        return crimeSceneCards
                .stream()
                .filter(card -> {
                    if (card.getLetterValue() == null) return false;
                    return card.getLetterValue().equals(letter);
                })
                .count()>=2;
    }
    //Method that validate if there are two cards of any type in the crime scene
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
}
