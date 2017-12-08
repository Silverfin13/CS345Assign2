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

    public ArrayList<Player> GameSetup() {
        setNumPlayers();
        setSceneCards();
        return this.players;
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
      colors.add("Pink");
      colors.add("Cyan");
      colors.add("Violet");
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
          Player p = new Player(1,0,0,color,"trailer",false);
          players.add(p);
          playersList.add(p);
        }
      } else if (numPlayers == 4){
        for (int i = 0; i < numPlayers; i++) {
          String color = findPlayerColor();
          Player p = new Player(1,0,0,color,"trailer",false);
          players.add(p);
          playersList.add(p);
        }
      } else if (numPlayers == 5){
        for (int i = 0; i < numPlayers; i++) {
            String color = findPlayerColor();
            Player p = new Player(1,0,3,color,"trailer",false);
            players.add(p);
            playersList.add(p);
        }
      } else if (numPlayers == 6){
        for (int i = 0; i < numPlayers; i++) {
            String color = findPlayerColor();
            Player p = new Player(1,0,4,color,"trailer",false);
            players.add(p);
            playersList.add(p);
        }
      } else {
        for (int i = 0; i < numPlayers; i++) {
            String color = findPlayerColor();
            Player p = new Player(2,0,0,color,"trailer",false);
            players.add(p);
            playersList.add(p);
        }
      }
      // make first player turn be true
      Player firstPlayer = players.get(0);
      firstPlayer.setTurn(true);
      players.set(0, firstPlayer);

    }

    public void setNumPlayers(){
        int numPlayers = BoardLayersListener.askNumPlayers();
        this.numberPlayers = numPlayers;
        // set number of days
        if ((this.numberPlayers >= 2) && (this.numberPlayers <= 3)) {
          this.numDays = 3;
        } else {
          this.numDays = 4;
        }
        createPlayerList(this.numberPlayers);
    }

    public void setSceneCards() {
      Board board = new Board();
      board.setBoard();
      board.placeCards();
    }
}
