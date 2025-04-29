import Models.Board;
import Models.Hand;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Hand hand = new Hand();
        board.giveCards(hand);
        System.out.println(hand.areAllTheSameType());
        if(board.addOfficeCard(hand,0)){
            System.out.println("Card added");
            board.giveACard(hand);
        }else{
            System.out.println("No card found");
        }
        System.out.println("Crime scene cards: "+board.getOfficeCards());
        System.out.println("Hand cards: "+hand.getCardsInHand());

    }
}