public class Act{
    int sceneRank = 0;
    int sceneNumber = 0;
    int playerRank = 0;
    int playerNumber = 0;
    int fame = 0;
    int money = 0;
    boolean actOnorOff = false;

    public Act(int sceneRank, int sceneNumber, int playerRank, int playerNumber, int fame, int money, boolean actOnorOff) {
        this.sceneRank = sceneRank;
        this.sceneNumber = sceneNumber;
        this.playerRank = playerRank;
        this.playerNumber = playerNumber;
        this.fame = fame;
        this.money = money;
        this.actOnorOff = actOnorOff;
    }

    public void actOnCard(int dieValue, int budgetMovie) {
        if(actOnorOff){
            if(dieValue >= budgetMovie){
                System.out.println("You succeeded in acting off card! You will get 2 fame");
                successOnCard();
            } else {
                System.out.println("You failed in acting on card! You earn nothing");
                failureOnCard();
            }
        }
    }

    public void actOffCard(){
        if(!actOnorOff){
            if(dieValue >= budgetMovie){
                System.out.println("You succeeded in acting off card! You will get 1 money and 1 fame");
                successOffCard();
            } else {
                System.out.println("You failed in acting off card! You still earn 1 money");
                failureOffCard();
            }
        }
    }

    public void successOnCard(){
        sceneRank = sceneRank + 1;
        fame = fame + 2;
    }

    public void failureOnCard(){
        //get nothing
        return;
    }

    public void successOffCard(){
        sceneRank = sceneRank + 1;
        money = money + 1;
        fame = fame + 1;
    }

    public void failureOffCard(){
        money = money + 1;
    }
}
