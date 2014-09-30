package eluball;


import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Timer;
import java.util.TimerTask;

//public void changeSize
//public boolean 
//what class and go inside method


@SuppressWarnings("serial")
public class Elusiveball extends JPanel implements MouseMotionListener, MouseListener { 
	private static int w = 100 ;
	private static int h = 100 ;
	private static int positionX = 100 ;
	private static int positionY  = 100 ;
	private static JFrame _frame;
	private static MyTimerTask _timer_task;
	private static Timer _timer;
	private static int directionX = 10;
	private static int directionY = 2;
	private static long _interval = 30;
	
	 private class MyTimerTask extends TimerTask {
		private Elusiveball _ball;
		//private JFrame _frame;
		
		public MyTimerTask(Elusiveball ball, JFrame frame) {
			_ball = ball;
			_frame = frame;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Random rand = new Random();
    		
		
			
			
    		if (positionX < 0 || positionX > _frame.getSize().width-w || positionY < 0 || positionY > _frame.getSize().height-h ) {
    			
    			System.out.println("Edge---");
    			if (positionX < w)
    				positionX = w;
    			else if (positionX > _frame.getSize().width-w)
    				positionX = _frame.getSize().width-w;
    			else if (positionY < h)
    				positionY = h;
    			else if (positionY >_frame.getSize().height-h)
    				positionY = _frame.getSize().height-h;
    			
    			int rand2 = rand.nextInt(40)-20;
    			int rand3 = rand.nextInt(40)-20;
    			
    			if (rand2 < 0){
    				directionX = directionX * -1;
    			}
    			
    			if (rand3 < 0){
    			 	directionY = directionY * -1;
    			}
    			//directionX = rand.nextInt(40);
    			//directionY= rand.nextInt(40);
    		}
    		positionX= positionX-directionX; //rand.nextInt(20)-10;//rand.nextInt(1000 - h);
    		positionY= positionY-directionY;
    		
    			 
    		
    		
//rand.nextInt(20)-10;//rand.nextInt(700 - w);
    		
    		_ball.removeMouseMotionListener(_ball);
    		_ball.removeMouseListener(_ball);
    		_frame.remove(_ball);
    		_frame.add(_ball);
    		repaint();
    		_frame.pack();
    		_ball.addMouseListener(_ball);
        	_ball.addMouseMotionListener(_ball);
		}
	 }
	 
    public Elusiveball (JFrame frame){
    	_frame = frame;
    	this.addMouseListener(this);
    	this.addMouseMotionListener(this);
    	
    	this.timerStart(_interval);
    	
    	//init dirX/Y
    	Random rand = new Random();
    	directionX = rand.nextInt(40)-20 ;
		directionY= rand.nextInt(40)-20;
   
    }

    @Override
	public void paint(Graphics g){
    	super.paint(g);
    	g.drawOval(positionX,positionY, w, h);
    	
    }
 
    @Override
    public void mouseDragged(MouseEvent arg0) {
    	//System.out.println("drag");
    	/*
    	if((arg0.getX() - w/2- positionX)*(arg0.getX() - w/2-positionX) + (arg0.getY() - h/2 - positionY)*(arg0.getY() - h/2 - positionY) <= w*h/4){
    		
    	
    		System.out.println("Start timer");
    		//System.out.println("Over");
    		
    		_timer.cancel();
    		
    		int g =	JOptionPane.showConfirmDialog(null, "Game Over, Wanna Continue?");	

    		if( g == JOptionPane.NO_OPTION ){
    			_frame.setVisible(true); 
    			_frame.dispose(); 
    		}
    		else if( g == JOptionPane.CANCEL_OPTION || g == JOptionPane.YES_OPTION){
    			//restart timrt
    			_timer_task = new MyTimerTask(this,_frame);
    	    	_timer = new Timer(true);
    	    	_timer.scheduleAtFixedRate(_timer_task, 0, 5*100);
    			return;
    		}
    	}
    	*/
    }
    

    

    @Override
    public void mouseMoved(MouseEvent arg0) {
    	//System.out.println("mouseMoved");
    	/*
    	if((arg0.getX() - w/2- positionX)*(arg0.getX() - w/2-positionX) + (arg0.getY() - h/2 - positionY)*(arg0.getY() - h/2 - positionY) <= w*h/4){
    		
    		
    		
    		Random rand = new Random();
    		positionX  =  rand.nextInt(1000 - h);
    		positionY  =  rand.nextInt(700 - w);
    		this.removeMouseMotionListener(this);
    		this.removeMouseListener(this);
    		_frame.remove(this);
    		_frame.add(this);
    		repaint();
    		_frame.pack();
    		this.addMouseListener(this);
        	this.addMouseMotionListener(this);
    	}
    	*/
    }

  
    @Override
    public void mouseClicked(MouseEvent arg0) {
    	if((arg0.getX() - w/2- positionX)*(arg0.getX() - w/2-positionX) + (arg0.getY() - h/2 - positionY)*(arg0.getY() - h/2 - positionY) <= w*h/4){
    		
        	
    		System.out.println("Start timer");
    		//System.out.println("Over");
    		
    		_timer.cancel();
    		
    		int g =	JOptionPane.showConfirmDialog(null, "Game Over, Wanna Continue?");	

    		if( g == JOptionPane.NO_OPTION ){
    			_frame.setVisible(true); 
    			_frame.dispose(); 
    		}
    		else if( g == JOptionPane.CANCEL_OPTION || g == JOptionPane.YES_OPTION){
    			//restart timrt
    			this.timerStart(_interval);
    			
    			
    		}
    	}
    }

    private void timerStart(long second) {
    	_timer_task = new MyTimerTask(this,_frame);
    	_timer = new Timer(true);
    	_timer.scheduleAtFixedRate(_timer_task, 0, second);
		return;
    }
    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    	// TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    	// TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    	// TODO Auto-generated method stub
    }
}