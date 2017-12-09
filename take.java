import java.util.*;
import java.awt.Rectangle;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.event.*;

public class take {

  private String setName = "";
  private int number = 0;
  private Rectangle area;
  public JLabel takelabel;

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

  public void setTake(JLabel takelabel){
    this.takelabel = takelabel;
  }

  public JLabel getTake(){
    return this.takelabel;
  }

}
