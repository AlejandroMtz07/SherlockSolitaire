import Models.Board;
import Models.Deck;
import Models.Hand;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Hand hand = new Hand();
        board.giveCards(hand);
        System.out.println(hand.getCardsInHand());
        System.out.println(hand.numberOfSameTypeCards());

    }
}