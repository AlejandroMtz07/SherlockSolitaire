package Models;


import Colors.Colors;
import java.util.*;


public class Office {

    private final List<Card> fristRow;
    private final List<Card> secondRow;
    private final List<Card> thirdRow;
    private final List<Card> fourthRow;
    private int cardsPlaced;

    public Office() {
        fristRow = new ArrayList<>();
        secondRow = new ArrayList<>();
        thirdRow = new ArrayList<>();
        fourthRow = new ArrayList<>();
        cardsPlaced = 0;
    }

    //TODO Add input validations
    public void addCardToARow(Card card, int column) {
        switch (column) {
            case 1 -> {
                if (areTheFirstCardTypeIncorrect(card)) break;
                fristRow.add(card);
            }
            case 2 -> {
                if (areTheFirstCardTypeIncorrect(card)) break;
                secondRow.add(card);
            }
            case 3 -> {
                if (areTheFirstCardTypeIncorrect(card)) break;
                thirdRow.add(card);
            }
            case 4 -> {
                if (areTheFirstCardTypeIncorrect(card)) break;
                fourthRow.add(card);
            }
            default -> {
            }
        }
    }

    /*
    * Method that checks if are two cards of the same value in any column
    */
    public boolean areTwoCardsInAnyColumn(){
        return areTwoCardsOfTheSameValue(getFirstRow())||
                areTwoCardsOfTheSameValue(getSecondRow())||
                areTwoCardsOfTheSameValue(getThirdRow())||
                areTwoCardsOfTheSameValue(getFourthRow());
    }

    /*
    * Method that checks if are two cards of the same value in the list passed by argument
    * This method is used to check if are two cards of the same Letter value
    * */
    private boolean areTwoCardsOfTheSameValue(List<Card> column){
        Set<Card> cardChecker = new HashSet<>();
        for (Card card : column) {
            if(!cardChecker.add(card)){
                return true;
            }
        }
        return false;
    }

    //Method that checks if the first card in the office is a number
    public boolean areTheFirstCardTypeIncorrect(Card card){
        return fristRow.isEmpty() && card.getCardType().equals(Colors.ANSI_GREEN+"Letter"+Colors.ANSI_RESET);
    }

    /*
    * Method that checks if are two cards of same value in any column using areTwoCardsTogether method
    * following the pattern of Letter - Number - Letter - Number*/
    public boolean checkCardPattern(){
        return areTwoCardsTogether(getFirstRow())||
                areTwoCardsTogether(getSecondRow())||
                areTwoCardsTogether(getThirdRow())||
                areTwoCardsTogether(getFourthRow());
    }

    //Method that checks if are two cards of the same type together
    private boolean areTwoCardsTogether(List<Card> column){
        if(column == null || column.size() <2){
            return false;
        }

        Iterator<Card> iterator = column.iterator();
        while(iterator.hasNext()){
            Card card = iterator.next();
            if(card.getCardType().equals(iterator.next().getCardType())){
                return true;
            }
        }
        return false;
    }
    /*
    * Method that resets the number of cards placed in the office
    */
    public void resetCardsPlaced(){
        cardsPlaced = 0;
    }


    @Override
    public String toString() {
        return "Cards in Office: \n"
                +(getFirstRow().isEmpty()?"[Nothin]": getFirstRow())
                +(getSecondRow().isEmpty()?" [Nothin]":getSecondRow())
                +(getThirdRow().isEmpty()?" [Nothin]":getThirdRow())
                +(getFourthRow().isEmpty()?" [Nothin]":getFourthRow());
    }

    public List<Card> getFirstRow() {
        return fristRow;
    }

    public List<Card> getSecondRow() {
        return secondRow;
    }

    public List<Card> getThirdRow() {
        return thirdRow;
    }

    public List<Card> getFourthRow() {
        return fourthRow;
    }


    public int getCardsPlaced() {
        return cardsPlaced;
    }

    public void setCardsPlaced(int cardsPlaced) {
        this.cardsPlaced = cardsPlaced;
    }
}
