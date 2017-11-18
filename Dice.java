import java.lang.*;

public class Dice {

    //die1 is rankdie
    //die2 is a regular die to get dice value along with die1.
    private static int die1 = 0;
    private static int die2 = 0;
    private static int diceValue = 0;
    private static int whichPlayer = 0;
    private static int rankDie = 0;

    // public Dice(int player) {
    //     whichPlayer = player;
    // }

    public void rollDice() {
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
        diceValue = die1+die2;
    }

    public int getDiceValue(){
        return diceValue;
    }

    public int getRankDie(){
        return die1;
    }


}
