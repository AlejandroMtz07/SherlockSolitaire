package Models;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "Cards in Office: \n"
                +(getFristRow().isEmpty()?"[Nothin]":getFristRow())
                +(getSecondRow().isEmpty()?" [Nothin]":getSecondRow())
                +(getThirdRow().isEmpty()?" [Nothin]":getThirdRow())
                +(getFourthRow().isEmpty()?" [Nothin]":getFourthRow());
    }

    public List<Card> getFristRow() {
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
