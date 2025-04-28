package Models;

import Enums.Letters;
import Enums.Numbers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        this.createDeck();
        this.shuffleDeck();
    }

    private void createDeck(){
        for(int i=0;i<3;i++){
            for(Letters letter : Letters.values()){
                cards.add(new Card(letter));
            }
        }
        for(int j=0;j<7;j++){
            for(Numbers number : Numbers.values()){
                cards.add(new Card(number));
            }
        }
    }
    private void shuffleDeck(){
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }
}
