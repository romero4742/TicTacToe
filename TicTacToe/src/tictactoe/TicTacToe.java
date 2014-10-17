package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Game finished summer 2012
 */

public class TicTacToe 
{
	
	public static void main (String [] args)
    {
	   try
	   {
          GameFrame g = new GameFrame();
          g.setVisible(true);
          g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      g.setTitle("Tic-Tac-Toe");
	      g.setSize(500,500);
	      g.setResizable(false);
	   }
       catch(Exception e)
 	   {
	 	  e.printStackTrace();
  	   }
   }
}


class GameFrame extends JFrame implements ActionListener
{
    //North of main panel
	private JPanel northCenterPanel, northPanel;
	private JLabel titleLabel, player1FieldLabel, player2FieldLabel;
	private JTextField player1TextField, player2TextField;
	private JButton enterPlayersBttn;
	
	
	//East of main panel
	@SuppressWarnings("rawtypes")
	private JComboBox iconOption;
	private JPanel eastPanel;
	private JLabel player1Label,drawLabel,player2Label;
	private JTextField player1PointsField, drawPointsField, player2PointsField,player2IconField;
	private int player1Points, drawPoints, player2Points;
	private Player player1, player2;
	
	//South of main panel
	private JPanel southPanel;
	private JButton resetBttn;
	
	//Center of main panel
	private JPanel centerPanel;
	private JButton bttn1, bttn2, bttn3,bttn4,bttn5,bttn6,bttn7,bttn8,bttn9;
    
    //starting player fields
    private boolean player1Start, player2Start; 
    
    //X and O images
    private ImageIcon XIcon, OIcon;
	
	/*
	 * Creates the mainframe calling all the methods required to display the game.
	 * From  here the next code is called by the user pressing OK
	 * 
	 */
	
	public GameFrame()
	{
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tictactoe.png")));
			north();
			south();
			east();
			center();
			setLayout(new BorderLayout());
			add(northPanel, BorderLayout.NORTH);
			add(eastPanel, BorderLayout.EAST);
			add(southPanel, BorderLayout.SOUTH);
			add(centerPanel, BorderLayout.CENTER);

	}
	
	/*
	 * Creates the north of the mainpanel
	 */
	public void north()
	{
        northPanel = new JPanel(new BorderLayout());
        titleLabel = new JLabel("Tic-Tac-Toe",JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD|Font.ITALIC,20));
        titleLabel.setForeground(Color.BLUE);
		northCenterPanel = new JPanel(new GridLayout(3,2));
		player1FieldLabel =new JLabel("Player 1:");
		player1TextField = new JTextField(15);
		player2FieldLabel = new JLabel("Player 2:");
		player2TextField = new JTextField(15);
		enterPlayersBttn = new JButton("Enter");
		enterPlayersBttn.addActionListener(this);
		
		northCenterPanel.add(player1FieldLabel);
		northCenterPanel.add(player1TextField);
		northCenterPanel.add(player2FieldLabel);
		northCenterPanel.add(player2TextField);
		northCenterPanel.add(new JPanel());
		northCenterPanel.add((enterPlayersBttn));
		northPanel.add(northCenterPanel,BorderLayout.CENTER);
		northPanel.add(titleLabel,BorderLayout.NORTH);
	}
	
	/**
	 * builds the south part of the main panel which includes the reset button
	 */
	
	public void south()
	{
		southPanel = new JPanel();
		resetBttn = new JButton("New Game");
		resetBttn.addActionListener(this);
		southPanel.add(resetBttn);
	}
	
	/*
	 * Has all components located on the east(right) side of the main panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void east()
	{
		eastPanel = new JPanel(new GridLayout(3,3));
		player1Label = new JLabel("Player 1");
		drawLabel = new JLabel("Draw");
		player2Label = new JLabel("Player 2");
		player1PointsField = new JTextField(3);
		player1PointsField.setPreferredSize(new Dimension(60,35));
		drawPointsField = new JTextField(3);
		drawPointsField.setPreferredSize(new Dimension(60,35));
		player2PointsField = new JTextField(3);
		player2PointsField.setPreferredSize(new Dimension(60,35));
		String [] icons = {"X","O"};
		iconOption = new JComboBox(icons);
		player1PointsField.setEditable(false);
		drawPointsField.setEditable(false);
		player2PointsField.setEditable(false);
		//creates a panel for label1
		JPanel player1LabelPanel = new JPanel();
		player1LabelPanel.add(player1Label);
		eastPanel.add(player1LabelPanel);
		//creates a panel for textField1
		JPanel player1PointsPanel = new JPanel();
		player1PointsPanel.add(player1PointsField);
		eastPanel.add(player1PointsPanel);
		//create a panel for player1 icon
		JPanel player1IconPanel = new JPanel();
		player1IconPanel.add(iconOption);
		eastPanel.add(player1IconPanel);
		//creates a panel for drawLabel
		JPanel drawLabelPanel = new JPanel();
		drawLabelPanel.add(drawLabel);
		eastPanel.add(drawLabelPanel);
		//creates a panel for drawPoints
		JPanel drawPointsPanel = new JPanel();
		drawPointsPanel.add(drawPointsField);
        eastPanel.add(drawPointsPanel);
        eastPanel.add(new JPanel());
		//creates a panel for label2
		JPanel player2LabelPanel = new JPanel();
		player2LabelPanel.add(player2Label);
		eastPanel.add(player2LabelPanel);
		//creates a panel for textfield2
		JPanel player2PointsPanel = new JPanel();
		player2PointsPanel.add(player2PointsField);
		eastPanel.add(player2PointsPanel);
		//creates a panel for player 2 icon set at the action listener
		JPanel player2IconPanel = new JPanel();
		player2IconField = new JTextField(2);
		player2IconField.setSize(new Dimension(100,75));
		player2IconField.setEditable(false);
		player2IconPanel.add(player2IconField);
		eastPanel.add(player2IconPanel);
		//setPoints of fields to 0 and initialize variables
		player1Points = 0;
		player2Points = 0;
		drawPoints = 0;
		player1PointsField.setText(String.valueOf(player1Points));
		drawPointsField.setText(String.valueOf(drawPoints));
		player2PointsField.setText(String.valueOf(player2Points));
	}
	
	
	/*
	 *set the components in the middle of the panel  
	 */
	
	public void center()
	{
		centerPanel = new JPanel(new GridLayout(3,3));
		bttn1 = new JButton();
		bttn2 = new JButton();
		bttn3 = new JButton();
		bttn4 = new JButton();
		bttn5 = new JButton();
		bttn6 = new JButton();
		bttn7 = new JButton();
		bttn8 = new JButton();
		bttn9 = new JButton();

		centerPanel.add(bttn1);
		centerPanel.add(bttn2);
		centerPanel.add(bttn3);
		centerPanel.add(bttn4);
		centerPanel.add(bttn5);
		centerPanel.add(bttn6);
		centerPanel.add(bttn7);
		centerPanel.add(bttn8);
		centerPanel.add(bttn9);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// Action listener for the icon selection 
		String source = (String)iconOption.getSelectedItem();
		if(source.equalsIgnoreCase("X"))
		{
			player2IconField.setText("O");
		}
		else
		{
			player2IconField.setText("X");
		}
		
		Object src = e.getSource();
		if(src == resetBttn)
			reset();
		if(src== enterPlayersBttn)
			setNames();
		if(src == bttn1)
			setButton(bttn1);
		if(src == bttn2)
			setButton(bttn2);
	    if(src == bttn3)
			setButton(bttn3);
		if(src == bttn4)
			setButton(bttn4);
		if(src == bttn5)
			setButton(bttn5);
		if(src == bttn6)
			setButton(bttn6);
		if(src == bttn7)
			setButton(bttn7);
		if(src == bttn8)
			setButton(bttn8);
		if(src == bttn9)
			setButton(bttn9);
	}
	
	
	@SuppressWarnings("static-access")
	public void reset()
	{
		dispose();
		new TicTacToe().main(null);
	}
	
	public void setNames()
	{
		if(player1TextField.getText().equals("") || player2TextField.getText().equals(""))
		{
			JOptionPane.showMessageDialog(centerPanel,"Enter a name for both players.");
		}
		else
		{
		   player1 = new Player(player1TextField.getText());
		   player2 = new Player(player2TextField.getText());
		   player1Label.setText(player1.getName());
		   player2Label.setText(player2.getName());
		   remakeNorthPanel();
		   startingPlayer();
		   initializeImages();
	       setPlayerIcons();
		   activateButtons();
		}
	}
	
	/**
	 * Method sets the icons to both players 
	 */
	public void setPlayerIcons()
	{
		if(player2IconField.getText().equalsIgnoreCase("X"))
		{
		   player2.setIcon(XIcon);
		   player1.setIcon(OIcon);
		}
	    if(player2IconField.getText().equalsIgnoreCase("o"))
	    {
	    	player2.setIcon(OIcon);
	    	player1.setIcon(XIcon);
	    }
	}

    
	public void resetBoard()
	{
		player1.setTurn(0);
		player2.setTurn(0);
		bttn1.setEnabled(true);
		bttn1.setIcon(null);
		bttn2.setEnabled(true);
		bttn2.setIcon(null);
		bttn3.setEnabled(true);
		bttn3.setIcon(null);
		bttn4.setEnabled(true);
		bttn4.setIcon(null);
		bttn5.setEnabled(true);
		bttn5.setIcon(null);
		bttn6.setEnabled(true);
		bttn6.setIcon(null);
		bttn7.setEnabled(true);
		bttn7.setIcon(null);
		bttn8.setEnabled(true);
		bttn8.setIcon(null);
		bttn9.setEnabled(true);
		bttn9.setIcon(null);
	}
	
	public void setButton(JButton b)
	{
		b.setIcon(getPlayerTurn().getIcon());
		b.setEnabled(false);
		checkDiagonalWin();
		checkVerticalWin();
		checkHorizontalWin();
		checkDraw();
	}
	
	public void checkDiagonalWin()
	{
		//player 1
		if(bttn1.getIcon()==player1.getIcon()&&bttn5.getIcon()==player1.getIcon()&&bttn9.getIcon()==player1.getIcon())
		{
		   player1PointsField.setText(String.valueOf(++player1Points));
		   changeTurn();
		   resetBoard();
		}
		if(bttn1.getIcon()==player2.getIcon()&&bttn5.getIcon()==player2.getIcon()&&bttn9.getIcon()==player2.getIcon())
		{
		   player2PointsField.setText(String.valueOf(++player2Points));
		   changeTurn();
		   resetBoard();
		}
		if(bttn7.getIcon()==player1.getIcon()&&bttn5.getIcon()==player1.getIcon()&&bttn3.getIcon()==player1.getIcon())
		{
		   player1PointsField.setText(String.valueOf(++player1Points));
		   changeTurn();
		   resetBoard();
		}
	    if(bttn7.getIcon()==player2.getIcon()&&bttn5.getIcon()==player2.getIcon()&&bttn3.getIcon()==player2.getIcon())
		{
		   player2PointsField.setText(String.valueOf(++player2Points));
		   changeTurn();
		   resetBoard();
		}
	}
	
	public void checkVerticalWin()
	{

	   if(bttn1.getIcon()==player1.getIcon()&&bttn4.getIcon()==player1.getIcon()&&bttn7.getIcon()==player1.getIcon())
	   {
		  player1PointsField.setText(String.valueOf(++player1Points));
		  changeTurn();
		  resetBoard();
	   }
	   if(bttn1.getIcon()==player2.getIcon()&&bttn4.getIcon()==player2.getIcon()&&bttn7.getIcon()==player2.getIcon())
	   {
		   player2PointsField.setText(String.valueOf(++player2Points));
		   changeTurn();
		   resetBoard();
	   }
	   if(bttn2.getIcon()==player1.getIcon()&&bttn5.getIcon()==player1.getIcon()&&bttn8.getIcon()==player1.getIcon())
	   {
		  player1PointsField.setText(String.valueOf(++player1Points));
		  changeTurn();
		  resetBoard();
	   }
	   if(bttn2.getIcon()==player2.getIcon()&&bttn5.getIcon()==player2.getIcon()&&bttn8.getIcon()==player2.getIcon())
	   {
		   player2PointsField.setText(String.valueOf(++player2Points));
		   changeTurn();
		   resetBoard();
	   }
	   if(bttn3.getIcon()==player1.getIcon()&&bttn6.getIcon()==player1.getIcon()&&bttn9.getIcon()==player1.getIcon())
	   {
		  player1PointsField.setText(String.valueOf(++player1Points));
		  changeTurn();
		  resetBoard();
	   }
	   if(bttn3.getIcon()==player2.getIcon()&&bttn6.getIcon()==player2.getIcon()&&bttn9.getIcon()==player2.getIcon())
	   {
		   player2PointsField.setText(String.valueOf(++player2Points));
		   changeTurn();
		   resetBoard();
	   }
	}
	public void checkHorizontalWin()
	{
	   if(bttn1.getIcon()==player1.getIcon()&&bttn2.getIcon()==player1.getIcon()&&bttn3.getIcon()==player1.getIcon())
		{
			player1PointsField.setText(String.valueOf(++player1Points));
			changeTurn();
			resetBoard();
		}
	   if(bttn1.getIcon()==player2.getIcon()&&bttn2.getIcon()==player2.getIcon()&&bttn3.getIcon()==player2.getIcon())
		{
		   player2PointsField.setText(String.valueOf(++player2Points));
		   changeTurn();
		   resetBoard();
		}
	   if(bttn4.getIcon()==player1.getIcon()&&bttn5.getIcon()==player1.getIcon()&&bttn6.getIcon()==player1.getIcon())
		{
			player1PointsField.setText(String.valueOf(++player1Points));
			changeTurn();
			resetBoard();
		}
	   if(bttn4.getIcon()==player2.getIcon()&&bttn5.getIcon()==player2.getIcon()&&bttn6.getIcon()==player2.getIcon())
		{
		   player2PointsField.setText(String.valueOf(++player2Points));
		   changeTurn();
		   resetBoard();
		}
	   if(bttn7.getIcon()==player1.getIcon()&&bttn8.getIcon()==player1.getIcon()&&bttn9.getIcon()==player1.getIcon())
		{
			player1PointsField.setText(String.valueOf(++player1Points));
			changeTurn();
			resetBoard();
		}
	   if(bttn7.getIcon()==player2.getIcon()&&bttn8.getIcon()==player2.getIcon()&&bttn9.getIcon()==player2.getIcon())
		{
		   player2PointsField.setText(String.valueOf(++player2Points));
		   changeTurn();
		   resetBoard();
		}
	}
	
	public void checkDraw()
	{
		if((player1.getTurn()+player2.getTurn()) == 9)
			{
			drawPointsField.setText(String.valueOf(++drawPoints));
			changeTurn();
			resetBoard();
			}
		    
	}
	
	/**
	 * changes the players turn 
	 */
	public void changeTurn()
	{
		if(player1Start)
		{
			player1Start = false;
			player2Start = true;
			JOptionPane.showMessageDialog(centerPanel,player2.getName()+" starts" );
		}
		else
		{
			player1Start = true;
			player2Start = false;
			JOptionPane.showMessageDialog(centerPanel, player1.getName()+" starts");
		}
	}
	
	/**
	 * returns the player with the next move
	 */
	public Player getPlayerTurn()
	{
		if(player1Start)
		{
		   if (player1.getTurn() != player2.getTurn())
		   {
			  player2Label.setForeground(Color.black);
			  player1Label.setForeground(Color.green);
		      player2.turnPlus();
			  return player2;
		   }
		   else
		   {
		      player1.turnPlus();
			  player1Label.setForeground(Color.black);
			  player2Label.setForeground(Color.green);
		      return player1;
		   }
		}
		if(player2Start)
		{
			if(player2.getTurn() != player1.getTurn())
			{
				player1.turnPlus();
				player1Label.setForeground(Color.black);
				player2Label.setForeground(Color.green);
				return player1;
			}
			else
			{
				player2.turnPlus();
				player2Label.setForeground(Color.black);
				player1Label.setForeground(Color.green);
				return player2;
			}
		}
		return null;
	}
	
	
	public void initializeImages()
	{
		OIcon = new ImageIcon(getClass().getClassLoader().getResource("o.jpg"));
		XIcon = new ImageIcon(getClass().getClassLoader().getResource("X.jpg"));
	}
	
	public void activateButtons()
	{
		bttn1.addActionListener(this);
		bttn2.addActionListener(this);
		bttn3.addActionListener(this);
		bttn4.addActionListener(this);
		bttn5.addActionListener(this);
		bttn6.addActionListener(this);
		bttn7.addActionListener(this);
		bttn8.addActionListener(this);
		bttn9.addActionListener(this);
	}
	
	public void startingPlayer()
	{
		int option = JOptionPane.showConfirmDialog(centerPanel,"Does "+ player1.getName()+" start?");
		if(option == 0)
		{
		   player1Start = true;
		   player1Label.setForeground(Color.GREEN);
		   player2Label.setForeground(Color.black);
		   player2Start = false;
		}
		if(option == 1)
		{
		    player1Start =false;
		    player2Start = true;
		    player2Label.setForeground(Color.GREEN);
		    player1Label.setForeground(Color.BLACK);
		}
		if(option == 2)
			reset();
	}
	
	public void remakeNorthPanel()
	{
	   northPanel.removeAll();
	   northPanel.add(titleLabel);
	   northPanel.repaint();
	}

	
}

