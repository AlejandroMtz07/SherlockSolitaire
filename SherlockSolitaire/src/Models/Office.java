package Models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Office {

    List<Card> fristRow;
    List<Card> secondRow;
    List<Card> thirdRow;
    List<Card> fourthRow;

    public Office() {
        fristRow = new ArrayList<>();
        secondRow = new ArrayList<>();
        thirdRow = new ArrayList<>();
        fourthRow = new ArrayList<>();
    }

    public void addCardToARow(Card card,int column) {
        switch (column) {
            case 1:
                fristRow.add(card);
                break;
            case 2:
                secondRow.add(card);
                break;
            case 3:
                thirdRow.add(card);
                break;
            case 4:
                fourthRow.add(card);
                break;
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    //Method that checks if are two cards of same type in any column using areTwoCardsTogether method
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

    //TODO Add the logic to print the list correctly, adding line breaks for every element
    private String columnPrinter(List<Card> column){
        return column.stream().map("- %s"::formatted).collect(Collectors.joining("\n"));
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

}
