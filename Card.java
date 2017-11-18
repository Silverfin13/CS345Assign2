import java.util.*;

public class Card {

    public String cardName = "";
    public String cardImg = "";
    public int budget = 0;
    public int sceneNumber = 0;
    public String sceneDescription = "";
    public ArrayList<part> parts = new ArrayList<part>();
    public String currentRoom = "";
    public boolean flipped = false;
    public boolean finished = false;

    public void createCard(String cardName, String cardImg, int budget, int sceneNumber,  String sceneDescription, ArrayList<part> parts, String currentRoom) {
      this.cardName = cardName;
      this.cardImg = cardImg;
      this.budget = budget;
      this.sceneNumber = sceneNumber;
      this.sceneDescription = sceneDescription;
      this.parts = parts;
      this.currentRoom = currentRoom;
    }

    public String getCardName() {
        return this.cardName;
    }

    public boolean getFlipped() {
        return this.flipped;
    }

    public boolean getFinished() {
        return this.finished;
    }

    public String getCardImg() {
        return this.cardImg;
    }

    public int getBudget() {
        return this.budget;
    }

    public int getSceneNumber() {
        return this.sceneNumber;
    }

    public String getSceneDescription() {
        return this.sceneDescription;
    }

    public ArrayList<part> getCardParts() {
        return this.parts;
    }

    public String getCurrentRoom() {
        return this.currentRoom;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
