import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MainClass extends JFrame implements ActionListener
{
	private WalkingMan man;
	private ArrayList<Ball> list = new ArrayList<Ball>();
	private int i = 0;
	
	public MainClass() 
	{
		setBounds(300,300,500, 600);
		setLayout(null);
		
		int x = 0;
		int y = 0;
		
		man = new WalkingMan(x,y);
		
		add(man);
		
		
		
		this.addKeyListener(new KeyListener()
				{

					@Override
					public void keyTyped(KeyEvent e) 
					{
						
						
					}

					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_A) 
						{
								man.setDx(-3);
						}
						else if(e.getKeyCode() == KeyEvent.VK_W) 
						{
								man.setDy(-3);
						}
						else if(e.getKeyCode() == KeyEvent.VK_D) 
						{
								man.setDx(3);
						}
						else if(e.getKeyCode() == KeyEvent.VK_S) 
						{
							
								man.setDy(3);
							
							
						}
						
						if (e.getKeyCode() == KeyEvent.VK_SPACE) 
						{
							Ball ball = new Ball(man.getX(),man.getY());
							list.add(ball);
							
							list.get(i).setLocation(man.getX(),man.getY());
							add(list.get(i));
							i++;
							
							 
						}
						repaint();
					}

					@Override
					public void keyReleased(KeyEvent e) 
					{
						if (e.getKeyCode() == KeyEvent.VK_A) 
						{
							man.setDx(0);
						}
						else if(e.getKeyCode() == KeyEvent.VK_W) 
						{
							man.setDy(0);
						}
						else if(e.getKeyCode() == KeyEvent.VK_D) 
						{
							man.setDx(0);
						}
						else if(e.getKeyCode() == KeyEvent.VK_S) 
						{
							man.setDy(0);
						}
						repaint();
						
					}
			
				});
		
		
		Timer t1 = new Timer(50,this);
		t1.start();
	
		//man.setFocusable(false);
		//setFocusable(false);
		
		setVisible(true);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

	

	public void actionPerformed (ActionEvent arg0) 
	{
		man.update();
		repaint();
		
		for(int i = 0; i < list.size(); i++) 
		{
			list.get(i).update();
			
			if (list.get(i).getX() >= getWidth() ) 
			{
				remove(list.get(i));
				list.remove(i);
				
			}
		}
		
		if (man.getX() < 0) 
		{
			man.setLocation(0, man.getY());
		}
		
		if (man.getX() > getWidth()-50) 
		{
			man.setLocation(getWidth()-50, man.getY());
		}
		
		if(man.getY() < 0) 
		{
			man.setLocation(man.getX(), 0);
		}
		
		if(man.getY() > getHeight()-90) 
		{
			man.setLocation(man.getX(), getHeight()-90);
		}
		
		repaint();
	}
	
	public static void main(String[] args) 
	{
		new MainClass();

	}
}
