public class Player {

    public int rank = 0;
    public int money = 0;
    public int fame = 0;
    public String whichPlayer = "";
    public boolean moved = false;
    // Player position: Trailers,CastingOffice,SceneRoom, or Role
    public String playerPosition = "trailer";
    public boolean turn = true;

    public Player(int rank, int money, int fame, String whichPlayer, String playerPosition, boolean turn){
        this.rank = rank;
        this.money = money;
        this.fame = fame;
        this.whichPlayer = whichPlayer;
        this.playerPosition = playerPosition;
        this.turn = turn;
    }

    public void setRank(int playerRank){
        this.rank = playerRank;
    }

    public void setMoved(boolean val){
      this.moved = val;
    }

    public void setMoney(int playerMoney){
        this.money = playerMoney;
    }

    public void setFame(int playerFame){
        this.fame = playerFame;
    }

    public void setTurn(boolean turn){
        this.turn = turn;
    }

    public void setPlayer(String playerWhich) {
        this.whichPlayer = playerWhich;
    }

    public void setPlayerPosition(String playerPosition){
        this.playerPosition = playerPosition;
    }

    public int getRank(){
        return this.rank;
    }

    public boolean getMoved(){
      return this.moved;
    }

    public int getMoney(){
        return this.money;
    }

    public int getFame(){
        return this.fame;
    }

    public String getPlayer() {
        return this.whichPlayer;
    }

    public String getPlayerPosition() {
        return this.playerPosition;
    }

    public boolean getTurn(){
        return this.turn;
    }

    /*
    choose movement()
    choose role()
    act or rehearse()
    endturn()
    */


}
