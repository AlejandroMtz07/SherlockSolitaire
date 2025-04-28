package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {

    private List<Card> cardsInHand;

    public Hand() {
        cardsInHand = new ArrayList<>();
    }

    public long numberOfSameTypeCards(){
        return cardsInHand.stream().filter(card->card.getCardType().equals("Number")).count();
    }




    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void setCardsInHand(List<Card> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }
}
