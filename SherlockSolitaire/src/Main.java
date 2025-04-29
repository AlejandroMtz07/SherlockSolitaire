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
        board.addOfficeCard(office,hand,0,1);
        board.addOfficeCard(office,hand,0,5);
        System.out.println(office);

    }
}