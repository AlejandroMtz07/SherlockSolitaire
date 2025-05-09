package Models;


public class Board {

    private final Deck deck;


    public Board() {
        deck = new Deck();
    }

    //Method that gives to the hand 4 cards
    public void giveCards(Hand hand){
        hand.setCardsInHand(deck.getCards().subList(0,4));
    }

    //Method that gives to the hand the last card in the cards deck
    public void giveOneCard(Hand hand){
        hand.getCardsInHand().add(deck.getCards().getLast());
    }

    //Method that add one card to the crimeScene list using the position of the cards in the hand
    public void addCrimeSceneCard(CrimeScene crimeScene, Hand hand,DiscardDeck discardDeck, int cardPosition){
        crimeScene.addCard(hand.getCardsInHand().get(cardPosition),discardDeck);
        hand.getCardsInHand().remove(cardPosition);
    }
    /*
    * Method that checks if the card selected is correct and put it into the office list
    */
    public void addOfficeCard(Office office,Hand hand,int cardPosition, int columnNumber){
        office.addCardToARow(hand.getCardsInHand().get(cardPosition),columnNumber);
        hand.getCardsInHand().remove(cardPosition);
    }

    /*
    * Method that checks if two cards were placed in the office
    */
    public boolean twoWerePutInTheOffice(Office office){
        return office.getCardsPlaced()==2;
    }

    /*
    * Method that checks if two cards were placed in the crime scene
    */
    public boolean twoWerePutInTheCrimeScene(CrimeScene crimeScene){
        return crimeScene.getCardsPlaced()==2;
    }

    //TODO Make validations of how many cards were placed in the office and the crime scene

}
