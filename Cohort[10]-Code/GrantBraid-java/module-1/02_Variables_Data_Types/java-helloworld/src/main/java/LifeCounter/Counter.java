package LifeCounter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Counter extends JFrame implements ActionListener {

   private JButton upCounter2;
   private JButton downCounter2;
   private JLabel first;
   private JLabel count;
   private JLabel count2;
   private JButton upCounter;
   private JButton downCounter;
   private JButton reset;
   private JButton roll;
   String whoFirst = "";
   int countClick = 20;
   int xsize = 800;
   int ysize = 550;
   int countClick2 = 20;
   
   public static void main(String[] args) {
	   Counter c = new Counter();
	   c.setVisible(true);
   }
	
   public Counter () {
	   setLayout(null);
	   setSize(xsize,ysize);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	   first = new JLabel(whoFirst);
	   count = new JLabel(""+countClick);
	   count2 = new JLabel(""+countClick2);
	   upCounter = new JButton("Count Up");
	   downCounter = new JButton("Count Down");
	   reset = new JButton("Reset");
	   roll = new JButton("Roll");
	   upCounter2 = new JButton("Count Up");
	   downCounter2 = new JButton("Count Down");
	   
	   count.setBounds(xsize/4-30,ysize/2-60,120,50);
	   count2.setBounds(xsize*3/4-30,ysize/2-60,120,50);
	   downCounter.setBounds(xsize/2 -130-20,ysize-60,130,30);
	   downCounter2.setBounds(xsize - 130-20,ysize-60,130,30);
	   upCounter.setBounds(20,ysize-60,130,30);
	   upCounter2.setBounds(xsize/2 +20,ysize-60,130,30);
	   reset.setBounds(xsize/2-65,ysize-100,130,30);
	   roll.setBounds(xsize/2-65, ysize-150,130,30);
	   first.setBounds(10,10,xsize,50);
	   
	   downCounter.addActionListener(this);
	   downCounter2.addActionListener(this);
	   upCounter.addActionListener(this);
	   upCounter2.addActionListener(this);
	   reset.addActionListener(this);
	   roll.addActionListener(this);
	   
	   count.setFont (count.getFont ().deriveFont (60.0f));
	   count2.setFont (count.getFont ().deriveFont (60.0f));
	   first.setFont(first.getFont().deriveFont(30.0f));
	   
	   
	   add(reset);
	   add(count);
	   add(count2);
	   add(upCounter);
	   add(downCounter);
	   add(roll);
	   add(first);
	   add(upCounter2);
	   add(downCounter2);
   }
 
  public void actionPerformed(ActionEvent e) {
	  if (e.getSource() == roll) {
		  
		  int playerOne = 0;
		  int playerTwo = 0;
		  while (playerOne == playerTwo) {
			  playerOne = (int)(Math.random()*6) + 1;
			  playerTwo = (int)(Math.random()*6) + 1;
		  }
		  if (playerOne > playerTwo) {
			  first.setText("Player One goes first");
		  } else {
			  first.setText("Player Two goes first");
		  }
	  }
	  
	  if (e.getSource() == upCounter2) {
		  countClick2 += 1;
		  count2.setText(""+countClick2);
		  first.setText("");
	  }
	  
	  if (e.getSource() == downCounter2) {
		  countClick2 -= 1;
		  count2.setText(""+countClick2);
		  first.setText("");
	  }
	  
	  if (e.getSource() == upCounter) {
		  countClick += 1;
		  count.setText(""+countClick);
		  first.setText("");
		  
	  }
	  if (e.getSource() == downCounter) {
		  countClick -= 1;
		  count.setText(""+countClick);
		  first.setText("");
	  }
	  
	  if (e.getSource() == reset) {
		  countClick2 = 20;
		  countClick = 20;
		  count2.setText(""+countClick2);
		  count.setText("" + countClick);
		  first.setText("");
	  }
  }
   
}