package Models;

public class Player {

    private String name;
    private String lastName;
    private int woundsQuantity;


    public Player(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.woundsQuantity = 0;
    }

    //This method make a wound to the player if he doesn't follow the game rules
    public void makeAWound(){
        woundsQuantity = woundsQuantity + 1;
    }

    /*
    * Method that checks if the player has lost the game
    */
    public boolean isGameOver(){
        return woundsQuantity == 3;
    }

    public int getWoundsQuantity(){
        return woundsQuantity;
    }

}
