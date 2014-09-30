package eluball;


import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Main extends JFrame  {

	public static void main(String[] args) {
		
	
	      
		JFrame frame = new JFrame("Elusive Ball");
		
		frame.setTitle( "Elusive Ball");
		frame.setSize(800 , 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
//		Timer Timer = new Timer(true);
//		Timer.SetInitialDelay(pause);
//		Timer.start();
//				
		Elusiveball a =  new Elusiveball(frame); 
		a.setPreferredSize(new Dimension(800,500));
		frame.add(a);
		
		frame.pack();
	}
}
	