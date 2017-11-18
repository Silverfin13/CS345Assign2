public class Rehearse {
    
    int sceneNumber = 0;
    boolean rehearseMarker = true;
    int playerNumber = 0;
    int diceValue = 0;
    int reheaseValue = 0;
    
    public Rehearse(){}
    
    public int actingRoleValue(){
        return 0;
    }
    
    public int increaseRehearseValue(int rehearseValue){
        if(scene.getBudget() > rehearseValue){
            rehearseValue++;
            System.out.println("You have rehearsed for the role. Your rehearsal value is now: " + rehearseValue + ".");
        }else{
            forceActing(rehearseValue);
        }
     return rehearseValue;
    }
    
    public void forceActing(int rehearseValue){
        System.out.println("You have rehearsed extensively, you may now act, your rehearsal value is: " + rehearseValue + ".");
        // call acting
    
    }
    
}
