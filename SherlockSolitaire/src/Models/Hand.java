package Models;

import Enums.Letters;
import Enums.Numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    private List<Card> cardsInHand;

    public Hand() {
        cardsInHand = new ArrayList<>();
    }


    //Method that return true if there are three cards of the same value
    public boolean areThreeCardsOfTheSameValue(){
        return (areThreeCardsOfNumber(Numbers.ONE)||
                areThreeCardsOfNumber(Numbers.TWO)||
                areThreeCardsOfNumber(Numbers.THREE)||
                areThreeCardsOfNumber(Numbers.FOUR)||
                        (areThreeCardsOfLetter(Letters.A)||
                        areThreeCardsOfLetter(Letters.B)||
                        areThreeCardsOfLetter(Letters.C)||
                        areThreeCardsOfLetter(Letters.D))
        );
    }

    /*
    * Method that checks if are three cards of the same number value
    */
    private boolean areThreeCardsOfNumber(Numbers number) {
        return cardsInHand
                .stream()
                .filter(card->{
                    if(card.getNumberValue()==null) return false;
                    return  card.getNumberValue().equals(number);
                })
                .count()==3;
    }
    /*
     * Method that checks if are three cards of the same letter value
    */
    private boolean areThreeCardsOfLetter(Letters letter) {
        return cardsInHand
                .stream()
                .filter(card->{
                    if(card.getLetterValue()==null) return false;
                    return  card.getLetterValue().equals(letter);
                })
                .count()==3;
    }


    //Method that checks if the card types are all the same
    public boolean areAllTheSameType(){
        return (cardsInHand.stream().filter(card->card.getCardType().equals("Number")).count()==4)||
                (cardsInHand.stream().filter(card->card.getCardType().equals("Letter")).count()==4);
    }

    /*
    * Method that dispose all the cards if all are of the same type or three al of the same value
    */

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
