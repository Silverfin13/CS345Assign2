import java.util.*;
import java.awt.Rectangle;

public class take {

  private String setName = "";
  private int number = 0;
  private Rectangle area;

  public void createTake(String setName, int number, Rectangle area) {
    this.setName = setName;
    this.number = number;
    this.area = area;
  }

  public String getSetName(){
    return this.setName;
  }

  public int getNumber(){
    return this.number;
  }

  public Rectangle getArea(){
    return this.area;
  }
}
