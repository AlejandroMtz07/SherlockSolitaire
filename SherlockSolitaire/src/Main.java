
import Models.Board;
import Models.CrimeScene;
import Models.Hand;
import Models.Office;

public class Main {

    public static void main(String[] args) {
        //Instancing all the necessary classes
        Board board = new Board();
        Hand hand = new Hand();
        Office office = new Office();
        CrimeScene crimeScene = new CrimeScene();

        //Making tests
        board.giveCards(hand);
        System.out.println(hand);
        //Adding cards to the crime scene
        board.addCrimeSceneCard(crimeScene,hand,0);
        board.addCrimeSceneCard(crimeScene,hand,0);
        board.addCrimeSceneCard(crimeScene,hand,0);
        board.addCrimeSceneCard(crimeScene,hand,0);

        System.out.println(crimeScene);
        System.out.println("Are two cards of the same value in the crime scene: "+crimeScene.areTwoCardsOfAnyType());

    }
}