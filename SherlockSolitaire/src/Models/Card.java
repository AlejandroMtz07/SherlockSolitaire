package Models;


import Enums.Letters;
import Enums.Numbers;

public class Card {
    private final String cardType;
    private Letters letterValue;
    private Numbers numberValue;

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

    public String toString(){
        return this.cardType+" "+((this.letterValue==null)?numberValue:letterValue);
    }

}
