import java.util.*;


public class GameSetup {

    private int numberPlayers = 0;
    private int boardSetup = 0;
    private int sceneShots = 0;
    private int sceneCards = 0;
    private int numDays = 0;
    public ArrayList<Player> players = new ArrayList<Player>();
    public ArrayList<String> colors = new ArrayList<String>();
    public LinkedList<Player> playersList = new LinkedList<Player>();

    public void GameSetup() {
        setNumPlayers();
        setSceneShots(sceneShots);
        setSceneCards(sceneCards);
    }

    public String findPlayerColor(){
      int number = (int) (Math.random() * colors.size());
      String color = colors.get(number);
      colors.remove(number);
      return color;
    }

    public void addColors() {
      colors.add("Red");
      colors.add("Blue");
      colors.add("Yellow");
      colors.add("Orange");
      colors.add("Green");
      colors.add("Purple");
      colors.add("Black");
      colors.add("White");
    }

    public int getNumDays(){
        return this.numDays;
    }

    public void createPlayerList(int numPlayers){
      addColors();
      // create an arraylist of players based on the number of players
      if ((numPlayers == 2) || (numPlayers == 3)) {
        for (int i = 0; i < numPlayers; i++) {
          String color = findPlayerColor();
          Player p = new Player(1,0,0,color,"Trailers",false);
          players.add(p);
          playersList.add(p);
        }
      } else if (numPlayers == 4){
        for (int i = 0; i < numPlayers; i++) {
          String color = findPlayerColor();
          Player p = new Player(1,0,0,color,"Trailers",false);
          players.add(p);
          playersList.add(p);
        }
      } else if (numPlayers == 5){
        for (int i = 0; i < numPlayers; i++) {
            String color = findPlayerColor();
            Player p = new Player(1,0,3,color,"Trailers",false);
            players.add(p);
            playersList.add(p);
        }
      } else if (numPlayers == 6){
        for (int i = 0; i < numPlayers; i++) {
            String color = findPlayerColor();
            Player p = new Player(1,0,4,color,"Trailers",false);
            players.add(p);
            playersList.add(p);
        }
      } else {
        for (int i = 0; i < numPlayers; i++) {
            String color = findPlayerColor();
            Player p = new Player(2,0,0,color,"Trailers",false);
            players.add(p);
            playersList.add(p);
        }
      }
      // make first player turn be true
      Player firstPlayer = players.get(0);
      firstPlayer.setTurn(true);
      players.set(0, firstPlayer);
      // playersList.set(0,firstPlayer);
    }

    public void setNumPlayers(){
        Scanner userInput = new Scanner(System.in);
        boolean val = false;
        // user input for number of players
        do {
          System.out.print("Please enter number of players: ");
          if (userInput.hasNextInt()) {
            int numPlayers = userInput.nextInt();
            if (numPlayers >= 2 && numPlayers <= 8) {
              this.numberPlayers = numPlayers;
              val = true;
            } else {
              System.out.println("Wrong number of players!\n");
            }
          } else if ((userInput.next().toLowerCase()) == "quit") {
            return;
          } else {
            System.out.println("Not a valid integer!\n");
          }
        } while (val == false);
        // set number of days
        if ((this.numberPlayers >= 2) && (this.numberPlayers <= 3)) {
          this.numDays = 3;
        } else {
          this.numDays = 4;
        }
        //Player player = new Player();
        createPlayerList(this.numberPlayers);
    }

    public void setSceneShots(int sceneshots) {
        this.sceneShots = sceneshots;
    }

    public void setSceneCards(int sceneCards) {
      this.sceneCards = sceneCards;
    }
}
