import java.util.*;

public class Card {

    public String cardName = "";
    public String cardImg = "";
    public int budget = 0;
    public int sceneNumber = 0;
    public String sceneDescription = "";
    public ArrayList<part> parts = new ArrayList<part>();
    public String currentRoom = "";

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
    // public int shotsFilmed() {
    //
    //     return this.shotsFilmed;
    // }
    //
    // public int decrementShotCount() {
    //     this.shotsFilmed--;
    //     return this.shotsFilmed;
    // }
    //
    //
    //
    // public static void displayInfo() {
    //     //System.out.println(currentCard.sceneName + "is currently shooting " + currentCard.getName());
    // }
    //
    //
    // public static boolean rolesAvailable(Role[] roles){
    //     return false;
    // }
    //
    //
    // public static void shootScene(int rank) {
    //
    //     // show information about the scene
    //     displayInfo();
    //
    //     //Role[] cardRoles = currentCard.getScenes();
    //     //System.out.println("The budget for this scene is:" + scene.getBudget() + " million dollars, and has " + shotsFilmed + " shots left.");
    //     //System.out.println("These are roles on the card:");
    //     // for(Role role : cardRoles) {
    //     //     if(!(role.getName().equals("0"))) {
    //     //         roleAvailable = true;
    //     //     }
    //     // }
    //     // if(!roleAvailable){
    //     //     System.out.println("There are no roles available");
    //     // }
    //     //
    //     // System.out.println("These are extra roles you can take:");
    //     // roleAvailable = false;
    //     // for(Role role: roomRoles) {
    //     //     if((role.getName().equals("0"))) {
    //     //         roleAvailable = true;
    //     //     }
    //     // }
    //     // if(!roleAvailable){
    //     //     System.out.println("There are no extra roles you can take!");
    //     // }
    // }
    //
    //
    // private static void endScene(int[] diceOutcomes, boolean scenesAvailable) {
    //     // Role[] cardRoles = getCardRoles();
    //     //
    //     // for(Role role : cardRoles) {
    //     //     if(role.getTaken()){
    //     //         role.removePlayer();
    //     //     }
    //     // }
    //     //
    //     // for(Role role : roomRoles) {
    //     //     if(role.getTaken()){
    //     //         role.removePlayer();
    //     //     }
    //     // }
    //     // distributeEarnings(diceOutcomes);
    //     // checklastScene();
    // }
    //
    // public static void distributeEarnings(int[] diceOutcomes) {
    //     // if (currentCard.isARoleTaken()) {
    //     //     System.out.println(" Distributing Earnings for roles");
    //     //     Role[] cardRoles = getCardRoles();
    //     //     for (int i = 0; i < diceOutcomes.length; i++) {
    //     //         if (cardRoles[i % cardRoles.length].getTaken()) {
    //     //             cardRoles[i % cardRoles.length].giveBonus(diceOutcomes[i]);
    //     //         }
    //     //     }
    //     // }
    // }
    //
    // // determine if scene just shot was the last scene
    // public static void checklastScene(){
    //     if(scenesAvailable == 0){
    //         //EndGame.determineWinner();
    //     }else{
    //         scenesAvailable--;
    //     }
    // }
}
