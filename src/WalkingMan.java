import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.JFrame;



	public class WalkingMan extends JComponent 
	{
		private Ellipse2D.Double head;
		private Rectangle leftArm, rightArm, leftLeg, rightLeg, body;
		private int Dx = 0; 
		private int Dy = 0;
		
		public WalkingMan(int x, int y) 
		{
			this.setLocation(x,y);
			this.setSize(35, 42);
			
			head = new Ellipse2D.Double(7,0,15,15);
			leftArm = new Rectangle(0,18,17,6);
			rightArm = new Rectangle(18,18,17,6);
			leftLeg = new Rectangle(7,27,7,15);
			rightLeg = new Rectangle(17,27,7,15);
			body = new Rectangle(12,12, 8, 20);
			
			
			
			
			
		}
		
		
		//setDx
		public void setDx(int x) 
		{
			Dx = x;
		}
		
		//setDy
		public void setDy(int y) 
		{
			Dy = y;
		}
		//update method called in the timer 
		
		public void update() 
		{
			setLocation(getX() + Dx, getY() + Dy);
		}
		
		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g;
			g2.fill(head);
			g2.fill(leftArm);
			g2.fill(rightArm);
			g2.fill(leftLeg);
			g2.fill(rightLeg);
			g2.fill(body);
			
			if (getY() <= 0) 
			{
				if (Dy < 0) 
				{
					Dy = 0;
				}
				
			}
			
			if ( getY() >= 600) 
			{
				if(Dy > 0) 
				{
					Dy = 0;
				}
				
			}
			
			if (getX() < 0) 
			{
				if (Dx < 0) 
				{
					Dx = 0;
				}
				
			}
			
			if ( getX() >= 500) 
			{
				if (Dx >= 0) 
				{
					Dx = 0;
				}
				
			}
			
			repaint();
		}
	}
	


