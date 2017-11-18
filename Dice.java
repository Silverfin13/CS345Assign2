import java.lang.*;
import java.util.*;


public class Dice {

    //die1 is rankdie
    //die2 is a regular die to get dice value along with die1.
    // private static int die1 = 0;
    // private static int die2 = 0;
    // private static int diceValue = 0;
    // private static int whichPlayer = 0;
    // private static int rankDie = 0;

    // public Dice(int player) {
    //     whichPlayer = player;
    // }

    public ArrayList<Integer> rollDice(int numDice) {
        ArrayList<Integer> descionDice = new ArrayList<Integer>();
        int roll;
        while (numDice != 0){
          roll = (int)(Math.random()*6) + 1;
          descionDice.add(roll);
          numDice--;
        }
        Collections.sort(descionDice, Collections.reverseOrder());
        return descionDice;
    }

    public int actRollDice() {
        int roll = (int)(Math.random()*6) + 1;
        return roll;
    }


}
