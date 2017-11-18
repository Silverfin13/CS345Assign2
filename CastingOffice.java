import java.util.*;
import java.awt.Rectangle;

public class CastingOffice {

    int money = 0;
    int fame = 0;
    //int playerNumber = 0;
    String whichPlayer = "";
    int rank = 0;
    boolean rehearseMarker = false;
    Rectangle officeArea;
    ArrayList<String> neighbors = new ArrayList<String>();
    //Player player;

    // public CastingOffice(int money, int fame, String whichPlayer, int rank, boolean rehearseMarker){
    //     this.money = money;
    //     this.fame = fame;
    //     this.whichPlayer = whichPlayer;
    //     this.rank = rank;
    //     this.rehearseMarker = rehearseMarker;
    //     //this.player = new player(0,0,0,"","",false);
    // }

    public boolean checkPlayerRank() {
        if(this.rank >=1 && this.rank <=6){
            return true;
        } else{
            return false;
        }
    }

    public String getWhichPlayer(){
        return this.whichPlayer;
    }

    public int getRank(){
        return this.rank;
    }

    public void setArea(Rectangle officeArea){
      this.officeArea = officeArea;
    }

    public void setNeighbors(ArrayList<String> neighbors){
      this.neighbors = neighbors;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public int getMoney(){
        return this.money;
    }

    public int getFame(){
        return this.fame;
    }

    public void upgradeRankWithFame() {

        switch(this.rank){
            case 1:
                if(this.fame >=5) {
                    takeFame(5);
                    setRank(2);
                }
                break;
            case 2:
                if(this.fame >=10) {
                    takeFame(10);
                    setRank(3);
                }
                break;
            case 3:
                if(this.fame >=15){
                    takeFame(15);
                    setRank(4);
                }
                break;
            case 4:
                if(this.fame >=20){
                    takeFame(20);
                    setRank(5);
                }
                break;
            case 5:
                if(this.fame >=25){
                    takeFame(25);
                    setRank(6);
                }
                break;
        }
    }

    public void upgradeRankWithMoney() {
        switch(this.rank){
            case 1:
                if(this.money >= 4){
                    takeMoney(4);
                    setRank(2);
                } else{
                    System.out.println("To rank up to 2, you need at least 4 dollars");
                }
                break;
            case 2:
                if(this.money >= 10){
                    takeMoney(10);
                    setRank(3);
                }else{
                    System.out.println("To rank up to 3, you need at least 10 dollars");
                }
                break;
            case 3:
                if(this.money >= 18){
                    takeMoney(18);
                    setRank(4);
                }else{
                    System.out.println("To rank up to 4, you need at least 18 dollars");
                }
                break;
            case 4:
                if(this.money >= 28){
                    takeMoney(28);
                    setRank(5);
                }else{
                    System.out.println("To rank up to 5, you need at least 28 dollars");
                }
                break;
            case 5:
                if(this.money >= 40) {
                    takeMoney(40);
                    setRank(6);
                }else{
                    System.out.println("To rank up to 6, you need at least 40 dollars");
                }
                break;
        }
    }

    public void takeMoney(int subtractMoney) {
        this.money = this.money - subtractMoney;
    }

    public void takeFame(int subtractFame) {
        this.fame = this.fame - subtractFame;
    }

    public void upgradeByRehearseMarker() {
        if(this.rehearseMarker){
            this.rank = this.rank+1;
        }
    }

    public boolean askIfUpgrade() {
        boolean getOutOfLoop = false;
        String answer = "";
        while(!getOutOfLoop){
            Scanner input = new Scanner(System.in);
            System.out.println("If you want to upgrade, type in y. Else if you don't want, type in n\n");
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

    public String howToUpgrade() {
        boolean getOutOfLoop = false;
        String fameOrDollar = "";
        System.out.println("Would you like to use fame or dollar to rank up? Type in f or d.\n");
        while(!getOutOfLoop){
            Scanner input = new Scanner(System.in);
            fameOrDollar = input.next();
            if(!fameOrDollar.toLowerCase().equals("f") || !fameOrDollar.toLowerCase().equals("d")){
                System.out.println("Type in f or d. I ain't got no time to mess with you");
            } else {
                getOutOfLoop = true;
            }
        }
        return fameOrDollar;
    }

}
