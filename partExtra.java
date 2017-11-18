import java.util.*;
import java.awt.Rectangle;

public class partExtra {

  private String partName = "";
  private String setName = "";
  private int level = 0;
  private Rectangle area;
  private String line = "";

  public void createPartExtra(String partName, String setName, int level, Rectangle area, String line) {
    this.partName = partName;
    this.setName = setName;
    this.level = level;
    this.area = area;
    this.line = line;
  }

  public String getPartName(){
    return this.partName;
  }

  public String getSetName(){
    return this.setName;
  }

  public int getLevel(){
    return this.level;
  }

  public Rectangle getArea(){
    return this.area;
  }

  public String getLine(){
    return this.line;
  }
}
