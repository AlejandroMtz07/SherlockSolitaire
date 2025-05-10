package Models;


import Colors.Colors;
import Enums.Letters;
import Enums.Numbers;

import java.util.Objects;

public class Card {
    private final String cardType;
    private Letters letterValue;
    private Numbers numberValue;

    //TODO Check if we want to add colors for each card type

    public Card(Letters letter){
        this.cardType = "Letter";
        this.letterValue = letter;
    }
    public Card(Numbers number){
        this.cardType = "Number";
        this.numberValue = number;
    }

    public String getCardType() {
        return cardType;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Card card = (Card) object;
        if(this.letterValue != null && card.letterValue != null){
            return this.letterValue == card.letterValue;
        }
        if(this.numberValue != null && card.numberValue != null){
            return this.numberValue == card.numberValue;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(letterValue, numberValue);
    }

    public Letters getLetterValue() {
        return letterValue;
    }
    public Numbers getNumberValue() {
        return numberValue;
    }
    public String toString(){
        return this.cardType+" "+((this.letterValue==null)?
                Colors.ANSI_BLUE+numberValue+Colors.ANSI_RESET:
                Colors.ANSI_GREEN+letterValue+Colors.ANSI_RESET);
    }

}
