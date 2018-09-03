package exam;

import java.awt.*;
import java.awt.event.*;

public class CanvasTest extends Canvas{
	CanvasTest(){
		setSize(250, 50);
		setBackground(Color.green);
	}
	
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.drawString("ĵ����", 110, 30);
		g.drawOval(50, 10, 150, 30);
	}
	
	public static void main(String[] args){
		Frame f = new Frame("C");
		Panel p = new Panel();
		f.add(p);
		p.add(new CanvasTest());
		f.setSize(300,100);
		f.setVisible(true);
	}
}
