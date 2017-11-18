import java.util.*;
import java.awt.Rectangle;

public class part {

  private String name = "";
  private int level = 0;
  private Rectangle area;
  private String line = "";

  public void createPart(String name, int level, Rectangle area, String line) {
    this.name = name;
    this.level = level;
    this.area = area;
    this.line = line;
  }

  public String getName(){
    return this.name;
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
