package wordsearch;

import java.awt.*;
import javax.swing.JComponent;
import java.util.*;

/*
 * Class that creates wordsearch as a Graphics2D.
 */
public class BoardOutline extends JComponent {
  char[][] words;
  HashMap<String, Solver.Coord> solutions;
  int x = 100;
  int y = 100;

 /*
  * Constructor that sets the letters on the board
  * and the words with their locations.
  * @param char[][] letters for the Board
  * @param HashMap<String, Solver.Coord> Words on the board and their locations.
  */
  public BoardOutline(char[][] words, HashMap<String, Solver.Coord> solutions) {
    this.words = words;
    this.solutions = solutions;
  }

  /*
   * Method that positions characters and rectangles on a Graphics2D.
   * @param Graphics Window that displays the Board
   */
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    //Set font type
    g2.setColor(new Color(0,0,0));
    g2.setFont(new Font("serif", Font.BOLD, 20));

    //Places each character 40 pixels(?) apart
    for(char[] line : words) {
      x = 100;
      for(char c : line) {
        String letter = Character.toString(c);
        g2.drawString(letter.toUpperCase() , x, y);
        x = x + 40;
      }
      y = y + 40;
    }

    //Draws a rectangle around each word in solution HashMap
    for(String key : solutions.keySet()) {
      int startX = solutions.get(key).getStartX()*40 + 90;
      int startY = solutions.get(key).getStartY()*40 + 80;
      int endX = solutions.get(key).getEndX()*40 + 90;
      int endY = solutions.get(key).getEndY()*40 + 80;
      int width = endX - startX + 40;
      int height = endY - startY + 30;
      g2.drawRect(startX, startY, width, height);
    }
  }
}
