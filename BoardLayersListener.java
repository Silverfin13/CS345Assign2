/*

   Deadwood GUI helper file
   Author: Moushumi Sharmin
   This file shows how to create a simple GUI using Java Swing and Awt Library
   Classes Used: JFrame, JLabel, JButton, JLayeredPane

*/


import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.*;
import java.awt.Rectangle;


public class BoardLayersListener extends JFrame {

  // Private Attributes

  // JLabels
  JLabel boardlabel;
  JLabel cardlabel;
  JLabel cardlabelJail;
  JLabel playerlabel;
  JLabel mLabel;

  //JButtons
  JButton bAct;
  JButton bRehearse;
  JButton bMove;
  JButton bTakeRole;
  JButton bRankUp;
  JButton bEndTurn;

  // JLayered Pane
  JLayeredPane bPane;
  JPanel panelStatus;

  // Constructor

  public BoardLayersListener() {

       // Set the title of the JFrame
       super("Deadwood");
       // Set the exit option for the JFrame
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       //asks for number of players
       String[] options = new String[] {"2", "3", "4", "5", "6", "7", "8"};
       int option =  JOptionPane.showOptionDialog(null, "Choose a number of players", "Message",
       JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
       null, options, options[0]);

       if (option != JOptionPane.CLOSED_OPTION) {
           System.out.println(options[option]);
       } else {
           System.out.println("No option selected");
       }

       // Create the JLayeredPane to hold the display, cards, dice and buttons

       bPane = getLayeredPane();
    //    bPane.setOpaque(true);
    //    bPane.setBackground(Color.red);

       // Create the deadwood board
        boardlabel = new JLabel();
        ImageIcon icon =  new ImageIcon("images/board.jpg");
        boardlabel.setIcon(icon);
        boardlabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());

       // Add the board to the lowest layer
       bPane.add(boardlabel, new Integer(0));

       // Set the size of the GUI
       setSize(icon.getIconWidth()+200,icon.getIconHeight());

     // Create the board for status of player
       panelStatus = new JPanel();
       panelStatus.setLayout(null);
       panelStatus.setBounds(icon.getIconWidth()+10,390,450,500);
       panelStatus.setBackground(Color.WHITE);

      addCards();

       // Add a dice to represent a player.
       // Role for Crusty the prospector. The x and y co-ordiantes are taken from Board.xml file
       playerlabel = new JLabel();
       ImageIcon pIcon = new ImageIcon("images/r2.png");
       playerlabel.setIcon(pIcon);
       //playerlabel.setBounds(114,227,pIcon.getIconWidth(),pIcon.getIconHeight());
       playerlabel.setBounds(114,227,46,46);
       bPane.add(playerlabel,new Integer(3));

       // Create the Menu for action buttons
       mLabel = new JLabel("MENU");
       mLabel.setBounds(icon.getIconWidth()+40,0,100,20);
       bPane.add(mLabel,new Integer(2));

       // Create Action buttons
       bAct = new JButton("ACT");
       bAct.setBackground(Color.white);
       bAct.setBounds(icon.getIconWidth()+10, 40,120, 40);
       bAct.addMouseListener(new boardMouseListener());

       bRehearse = new JButton("REHEARSE");
       bRehearse.setBackground(Color.white);
       bRehearse.setBounds(icon.getIconWidth()+10,100,120, 40);
       bRehearse.addMouseListener(new boardMouseListener());

       bMove = new JButton("MOVE");
       bMove.setBackground(Color.white);
       bMove.setBounds(icon.getIconWidth()+10,160,120, 40);
       bMove.addMouseListener(new boardMouseListener());

       bTakeRole = new JButton("TAKE ROLE");
       bTakeRole.setBackground(Color.white);
       bTakeRole.setBounds(icon.getIconWidth()+10,220,120, 40);
       bTakeRole.addMouseListener(new boardMouseListener());

       bRankUp = new JButton("RANK UP");
       bRankUp.setBackground(Color.white);
       bRankUp.setBounds(icon.getIconWidth()+10,280,120, 40);
       bRankUp.addMouseListener(new boardMouseListener());

       bEndTurn = new JButton("END TURN");
       bEndTurn.setBackground(Color.white);
       bEndTurn.setBounds(icon.getIconWidth()+10,340,120, 40);
       bEndTurn.addMouseListener(new boardMouseListener());


       // Place the action buttons in the top layer
       bPane.add(bAct, new Integer(2));
       bPane.add(bRehearse, new Integer(2));
       bPane.add(bMove, new Integer(2));
       bPane.add(bTakeRole, new Integer(2));
       bPane.add(bRankUp, new Integer(2));
       bPane.add(bEndTurn, new Integer(2));

  }


  public void addCards(){

      ParseFile parse = new ParseFile();
      HashMap<String,Room> rooms = parse.rooms;
      for (String key: rooms.keySet()){
        // System.out.println(key);
        Room currRoom = rooms.get(key);
        if (key != "trailer"){
            Card currCard = currRoom.getCard();
            // System.out.printf("RoomName: %s \nCardName: %s\n",currRoom.getName(), currCard.getCardName());
            Rectangle roomArea = currRoom.getCardArea();
            placeCards(currCard, currRoom.getCardArea());
            placeCardBacks(currRoom.getCardArea());
        }
      }
/*
      // Add a scene card to this room
      cardlabel = new JLabel();
      ImageIcon trainBack =  new ImageIcon("images/backOfCard.png");
      cardlabel.setIcon(trainBack);
      // x+4 and y-4
      cardlabel.setBounds(21,69,trainBack.getIconWidth(),trainBack.getIconHeight());
      cardlabel.setOpaque(true);
      // Add the card to the lower layer
      bPane.add(cardlabel, new Integer(1));
*/

  }

  public void placeCards(Card card, Rectangle cardArea){
      // Add a scene card to this room
      cardlabel = new JLabel();
      ImageIcon cardImage =  new ImageIcon("images/" + card.getCardImg());
      cardlabel.setIcon(cardImage);
      // x+4 and y-4
      cardlabel.setBounds((int)cardArea.getX(),(int)cardArea.getY(),cardImage.getIconWidth(),cardImage.getIconHeight());
      cardlabel.setOpaque(true);
      // Add the card to the lower layer
      bPane.add(cardlabel, new Integer(2));

  }

  public void placeCardBacks(Rectangle cardArea){
      // Add a scene card to this room
      cardlabel = new JLabel();
      ImageIcon cardBack =  new ImageIcon("images/backOfCard.png");
      cardlabel.setIcon(cardBack);
      // x+4 and y-4
      cardlabel.setBounds((int)cardArea.getX()+4,(int)cardArea.getY()-4,cardBack.getIconWidth(),cardBack.getIconHeight());
      cardlabel.setOpaque(true);
      // Add the card to the lower layer
      bPane.add(cardlabel, new Integer(3));

  }

  // This class implements Mouse Events

  class boardMouseListener implements MouseListener {

      // Code for the different button clicks
      public void mouseClicked(MouseEvent e) {

         if (e.getSource()== bAct){
            System.out.println("Acting is Selected\n");
         }
         else if (e.getSource()== bRehearse){
            System.out.println("Rehearse is Selected\n");
         }
         else if (e.getSource()== bMove){
            System.out.println("Move is Selected\n");
         }
         else if (e.getSource()== bTakeRole){
            System.out.println("TakingRole is Selected\n");
         }
         else if (e.getSource()== bRankUp){
            System.out.println("Rank Up is Selected\n");
         }
         else if (e.getSource()== bEndTurn){
            System.out.println("End Turn is Selected\n");
         }
      }
      public void mousePressed(MouseEvent e) {
      }
      public void mouseReleased(MouseEvent e) {
      }
      public void mouseEntered(MouseEvent e) {
      }
      public void mouseExited(MouseEvent e) {
      }
   }
}
