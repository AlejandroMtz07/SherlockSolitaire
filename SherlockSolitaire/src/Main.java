
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
        Player player;

        //Scanner
        Scanner sc = new Scanner(System.in);

        boolean gameOver = true;

        while (gameOver) {
            System.out.println("Enter your name");
            String name = sc.nextLine();
            System.out.println("Enter your last name");
            String lastName = sc.nextLine();
            player = new Player(name, lastName);
            board.giveCards(hand);
            System.out.println("Your hand: "+hand);

        }


    }
}