import javax.swing.*;
import javax.swing.event.*;

import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Tic2 implements ActionListener{
	JButton b[];
	int count=0;
	String t="";
	JFrame f;
	Tic2(){
		JFrame f=new JFrame("tic tac toe game");
		try{
			JButton b[]=new JButton[9];
		f.setSize(500, 500);
		f.setLayout(new GridLayout(3,3));
		f.setVisible(true);
		f.add(b[ 9]);
		b[9].addActionListener(this); }catch(Exception e){}
		
	}
	public void actionPerformed(ActionEvent e){
		count++;
		if((count%2)==0){
			String t="X";

		}
		else if((count%2)==1)
		{
			String t="0";
		}
		else if(e.getSource()== b[0]){
			b[0].setText(t);
			b[0].setEnabled(false);
			
		}
		else if(e.getSource()== b[1]){
			b[1].setText(t);
			b[1].setEnabled(false);
			
		}
		else if(e.getSource()== b[2]){
			b[2].setText(t);
			b[2].setEnabled(false);
			
		}
		else if(e.getSource()== b[3]){
			b[3].setText(t);
			b[3].setEnabled(false);
			
		}
		else if(e.getSource()== b[4]){
			b[4].setText(t);
			b[4].setEnabled(false);
			
		}
		else if(e.getSource()== b[5]){
			b[5].setText(t);
			b[5].setEnabled(false);
			
		}
		else if(e.getSource()== b[6]){
			b[6].setText(t);
			b[6].setEnabled(false);
			
		}
		else if(e.getSource()== b[7]){
			b[7].setText(t);
			b[7].setEnabled(false);
			
		}
		else if(e.getSource()== b[8]){
			b[8].setText(t);
			b[8].setEnabled(false);
			
		}
		if((b[0].getText() == b[1].getText()) && (b[1].getText() == b[2].getText()) && (b[0].getText() != null)){
			JOptionPane.showMessageDialog(f,"win");
	    	
	    }
		else if((b[3].getText() == b[4].getText()) && (b[4].getText() == b[5].getText()) && (b[3].getText() != null)){
			JOptionPane.showMessageDialog(f,"win");
	    	
	    }
		else if((b[6].getText() == b[7].getText()) && (b[7].getText() == b[8].getText()) && (b[6].getText() != null)){
			JOptionPane.showMessageDialog(f,"win");
	    	
	    }
		else if((b[0].getText() == b[3].getText()) && (b[3].getText() == b[5].getText()) && (b[0].getText() != null)){
			JOptionPane.showMessageDialog(f,"win");
	    	
	    }
		else if((b[1].getText() == b[4].getText()) && (b[4].getText() == b[7].getText()) && (b[1].getText() != null)){
			JOptionPane.showMessageDialog(f,"win");
	    	
	    }
		else if((b[2].getText() == b[5].getText()) && (b[5].getText() == b[8].getText()) && (b[2].getText() != null)){
			JOptionPane.showMessageDialog(f,"win");
	    	
	    }
		else if((b[0].getText() == b[4].getText()) && (b[4].getText() == b[8].getText()) && (b[4].getText() != null)){
			JOptionPane.showMessageDialog(f,"win");
	    	
	    }
		else if((b[2].getText() == b[4].getText()) && (b[4].getText() == b[6].getText()) && (b[2].getText() != null)){
			JOptionPane.showMessageDialog(f,"win");
	    	
	    }
		else{
			JOptionPane.showMessageDialog(f,"draw");
			
		}
		
		
		
		
		}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new Tic2();
        
        
        
     
        
        
	}

}
