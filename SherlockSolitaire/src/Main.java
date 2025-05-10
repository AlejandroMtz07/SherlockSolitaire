
import Models.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Instancing all the necessary classes
        Board board = new Board();
        Hand hand = new Hand();
        Office office = new Office();
        CrimeScene crimeScene = new CrimeScene();
        DiscardDeck discardDeck = new DiscardDeck();
        Player player = new Player("Juanito","M.");

        board.giveCards(hand);
        System.out.println(hand);




    }
}