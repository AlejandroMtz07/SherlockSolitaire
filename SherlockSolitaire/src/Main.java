
import Models.*;

public class Main {

    public static void main(String[] args) {
        //Instancing all the necessary classes
        Board board = new Board();
        Hand hand = new Hand();
        Office office = new Office();
        CrimeScene crimeScene = new CrimeScene();
        DiscardDeck discardDeck = new DiscardDeck();

        //Making tests
        board.giveCards(hand);
        System.out.println(hand);
        //Adding cards to the crime scene
        board.addCrimeSceneCard(crimeScene,hand,discardDeck,0);
        System.out.println(crimeScene);
        board.addCrimeSceneCard(crimeScene,hand,discardDeck,0);
        System.out.println(crimeScene);
        board.addCrimeSceneCard(crimeScene,hand,discardDeck,0);
        System.out.println(crimeScene);
        board.addCrimeSceneCard(crimeScene,hand,discardDeck,0);

        //Printing the
        System.out.println(crimeScene);
        System.out.println(discardDeck);


    }
}