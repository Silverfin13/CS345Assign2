import java.util.*;
import java.awt.Rectangle;

public class Room {

      public String name = "";
      /* extra parts in room */
      public ArrayList<partExtra> parts = new ArrayList<partExtra>();
      /* number of shot markers */
      public int numOfTakes = 0;
      public int currNumTakes = 0;
      /* for each day, new card comes in room */
      public Card card;

      Rectangle cardArea;

      ArrayList<take> takes = new ArrayList<take>();

      public ArrayList<String> neighbors = new ArrayList<String>();

      public void createRoom(String name, ArrayList<partExtra> parts, int numOfTakes, int currNumTakes, ArrayList<String> neighbors, Rectangle cardArea, ArrayList<take> takes) {
        this.name = name;
        this.parts = parts;
        this.numOfTakes = numOfTakes;
        this.currNumTakes = currNumTakes;
        this.neighbors = neighbors;
        this.cardArea = cardArea;
        this.takes = takes;
      }

      public void setCard(Card newCard){
          this.card = newCard;
      }

      public Card getCard() {
          return this.card;
      }

      public String getName() {
          return this.name;
      }

      public ArrayList<partExtra> getParts() {
          return this.parts;
      }

      public int getNumofTakes() {
          return this.numOfTakes;
      }

      public ArrayList<String> getNeighbors() {
          return this.neighbors;
      }

      public Rectangle getCardArea() {
          return this.cardArea;
      }

      public ArrayList<take> getTakes() {
          return this.takes;
      }

      public void setNumofTakes(int numOfTakes) {
          this.numOfTakes = numOfTakes;
      }

 }
