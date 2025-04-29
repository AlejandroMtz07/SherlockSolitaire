package Models;

import java.util.ArrayList;
import java.util.List;

public class CrimeScene {

    List<Card> crimeSceneCards;


    public CrimeScene(){
        crimeSceneCards = new ArrayList<Card>();
    }

    public boolean addCard(Card card) {
        return crimeSceneCards.add(card);
    }


    public List<Card> getCrimeSceneCards() {
        return crimeSceneCards;
    }
}
