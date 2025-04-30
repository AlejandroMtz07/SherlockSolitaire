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
        this.cardType = Colors.ANSI_GREEN+"Letter"+Colors.ANSI_RESET;
        this.letterValue = letter;
    }
    public Card(Numbers number){
        this.cardType = Colors.ANSI_BLUE+"Number"+Colors.ANSI_RESET;
        this.numberValue = number;
    }

    public String getCardType() {
        return cardType;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Card card = (Card) object;
        return letterValue == card.letterValue && numberValue == card.numberValue;
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
        return this.cardType+" "+((this.letterValue==null)?numberValue:letterValue);
    }

}
