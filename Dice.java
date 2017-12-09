import java.lang.*;
import java.util.*;


public class Dice {


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
