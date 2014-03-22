package tictactoe;

import javax.swing.ImageIcon;

class Player
{
   private String name;
   private int score,turn;
   private ImageIcon icon;
   
   public Player(String name)
   {
	  this.name = name;
	  this.score = 0;
	  this.turn = 0;
   }
   
   public String getName()
   {
	   return name;
   }
  
   public void gameWon()
   {
	   score++;
   }
   
   public int getScore()
   {
	   return score;
   }
   public void setIcon(ImageIcon icon)
   {
	   this.icon = icon;
   }
   public ImageIcon getIcon()
   {
	   return icon;
   }
   public int getTurn()
   {
	   return turn;
   }
   public void turnPlus()
   {
	   turn++;
   }
   public void setTurn(int turn)
   {
	   this.turn = turn;
   }
   
}
