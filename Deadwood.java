import java.util.*;
import java.io.Console;

public class Deadwood extends GameSetup {

    //public static ArrayList<Player> players;
    public static LinkedList<Player> playersList;
    public static int numSceneLeft;
    public static HashMap<String,ArrayList> setNeighbors;
    public static ArrayList<Card> cards;
    public static int scenesLeft = 10;

    public static void main(String[] args) {

        ParseFile.parseCards();
        ParseFile.parseBoard();

        cards = ParseFile.cards;

        int numDays = 0;
        numSceneLeft = 0;
        GameSetup game = new GameSetup();
        game.GameSetup();
        numDays = game.getNumDays();
        ArrayList<Player> players = game.players;
        //You can move, work or upgrade
        //playerAct();
        int i = 1;
        while(i < numDays+1) {
            System.out.println("There are " + numDays + " days left.");
            while(scenesLeft != 1) {
                // iterate through player turns
                for(int a = 0; a < players.size(); a++) {
                    if(players.get(a).getTurn()) {
                      startTurn(players.get(a));
                        // make the next players turn be true
                        if (a+1 < players.size()){
                          players.get(a+1).setTurn(true);
                        } else {
                          players.get(0).setTurn(true);
                        }
                    }
                }
                numSceneLeft--;
            }
            i++;
        }

        //for loop for how many days left

    }

    public static void startTurn(Player currentPlayer) {
      //  Scanner userInput = new Scanner(System.in);
       boolean val = false;
       // user input for number of players
       do {
         System.out.printf("\nIt is now %s turn. What would you like to do? \n", currentPlayer.getPlayer());
         System.out.println("Your options are: who, where, move (room), work (part), upgrade $ level, upgrade cr level, rehearse, act, and end");
         Console console = System.console();
         String input = console.readLine();
         String[] inputArray;
         if (input.contains(" ")){
           inputArray = input.split(" ");
           input = inputArray[0];
         } else {
           inputArray = new String[3];
         }
         if (inputArray.length > 3) {
           System.out.println("Not a valid input, try again.");
         } else {
           switch(input) {
             case "who":
                 System.out.println(currentPlayer.getPlayer());
               break;
             case "where":
                 System.out.println(currentPlayer.getPlayerPosition());
               break;
             case "move":
                 Move move = new Move();
                 move.move(currentPlayer, inputArray);
               break;
             case "work":
               work(currentPlayer, inputArray[1]);
               break;
             case "upgrade":
               if ((inputArray[1] == "$") || (inputArray[1] == "cr")){
                 try {
                   String valueType = inputArray[1];
                   int level = Integer.parseInt(inputArray[2]);
                   castingOffice(currentPlayer, valueType, level);
                 } catch (NumberFormatException e) {
                     System.out.println("Invalid level. Try again.");
                     System.out.println("Your options are: who, where, move (room), work (part), upgrade $ level, upgrade cr level, rehearse, act, and end");
                 }
               } else {
                 System.out.println("Not a valid input, try again.");
                 System.out.println("Your options are: who, where, move (room), work (part), upgrade $ level, upgrade cr level, rehearse, act, and end");
               }
               break;
             case "rehearse":
               playerRehearse(currentPlayer);
               break;
             case "act":
               playerAct(currentPlayer);
               break;
             case "end":
                 currentPlayer.setTurn(false);
                 val = true;
               break;
             default:
               System.out.println("Not a valid input, try again.");
               break;
           }
         }
       } while (val == false);
     }

    public static void playerRehearse(Player currentPlayer) {
    }

    public static void  castingOffice(Player currentPlayer, String valueType, int level) {
    }

    public static void work(Player currentPlayer, String role) {
    }

    public static void playerAct(Player currentPlayer) {
        //Player currentPlayer = playersList.remove(0);
        System.out.println("Current player is " + currentPlayer.getPlayer());

        /*
            player is not in a role or casting office: case 1
                -> player is in  a scene room, then ask if they want to take a role
            or currently in a role: case 2
            or in the casting office: case 3
        */

        /* Current player is in casting office */
        if(currentPlayer.getPlayerPosition().equals("CastingOffice")) {
            //ask first if player wants to upgrade
            CastingOffice castingOffice = new CastingOffice();
            boolean askUpgrade = castingOffice.askIfUpgrade();
            if(askUpgrade) {
                String fameOrDollar = castingOffice.howToUpgrade();
                if(fameOrDollar.equals("f")) {
                    castingOffice.upgradeRankWithFame();
                } else if(fameOrDollar.equals("d")) {
                    castingOffice.upgradeRankWithMoney();
                }
                //user wants to move => find a adjacent room
            } else if(!askUpgrade) {
                if(Move.askIfMoving()) {
                    //reset player position

                    // Move.adjacentSets also has String currentSet has 2nd parameter
                    //currentPlayer.setPlayerPosition(Move.adjacentSets(setNeighbors));
                    //create a act project and ask if he wants to act on the card or off the card
                    if(AskActOnorOff()){
                        //act on card
                        //roll dice

                    } else {

                    }
                } else if(!Move.askIfMoving()) {
                    endTurn(currentPlayer);
                }
            }


        /* Current player is in scene room */
        } else if(currentPlayer.getPlayerPosition().equals("SceneRoom")) {
            //need to ask if he wants to take a role.
            boolean getOutOfLoop = false;
            String answer = "";
            System.out.println("Do you want to take on a role?\n");
            while(!getOutOfLoop){
                Scanner input = new Scanner(System.in);
                answer = input.next();
                if(!answer.toLowerCase().equals("y") || !answer.toLowerCase().equals("n")){
                    System.out.println("Type in y or n. I ain't got no time to mess with you");
                } else {
                    getOutOfLoop = true;
                }
            }
            if(answer.equals("y")){
                //scene.shootScene(playerRank);

                String sceneAnswer = "";
                System.out.println("would you like to rehearse for the film or act?");
                System.out.println("Type rehearse or act");
                Scanner input = new Scanner(System.in);
                sceneAnswer = input.next();
                if(!answer.toLowerCase().equals("y") || !answer.toLowerCase().equals("n")){
                    System.out.println("Please use your hands on the keyboard");
                } else {
                    getOutOfLoop = true;
                }

                if(sceneAnswer.equals("rehearse")){
                    //rehearse;

                }else{
                    AskActOnorOff();
                }

            }else if(answer.equals("n")){
                System.out.println("would you like to skip your turn or move?");
                System.out.println("Type skip or move");
            }



        } else if(currentPlayer.getPlayerPosition().equals("Role")) {
            System.out.println("It is not possible to move until you have completed our role");
            // act

        }
    }

    public static void endTurn(Player player) {
        player.setTurn(false);
        playersList.add(player);
    }

    public static void playerStatus(Player player){
        //System.out.println("Player name: " + player.getName());
        System.out.println("Player's current rank: " + player.getRank());
        System.out.println("Player money: " + player.getMoney());
        System.out.println("Player fame: " + player.getFame());
    }

    public static boolean AskActOnorOff() {
        boolean getOutOfLoop = false;
        String answer = "";
        System.out.println("If you want to act on card, type in y. Otherwise, if you want to act off card, type in n\n");
        while(!getOutOfLoop){
            Scanner input = new Scanner(System.in);
            answer = input.next();
            if(!answer.toLowerCase().equals("y") || !answer.toLowerCase().equals("n")){
                System.out.println("Type in y or n. I ain't got no time to mess with you");
            } else {
                getOutOfLoop = true;
            }
        }

        if(answer.toLowerCase().equals("y")){
            return true;
        } else if(answer.toLowerCase().equals("n")){
            return false;
        }
        return false;
    }
}
