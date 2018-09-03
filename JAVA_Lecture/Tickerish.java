package exam;

import java.applet.*;
import java.util.*; 
import java.text.*;
import java.awt.*;

public class Tickerish implements Runnable{
	DigitalClock dc;
	int x=10, y=40, dx=10;
	Tickerish(){
		Frame bigben = new Frame("Tickerish");
		dc = new DigitalClock();
		bigben.add("Center", dc);
		dc.start(); // it's a thread! Start it!
		bigben.setSize(300, 200);
		bigben.setVisible(true);
	}
	public static void main(String[] args){
		Tickerish tsh = new Tickerish();
		for(int i=0;i<10;i++){
			Thread t = new Thread(tsh);
			t.start(); // ->start 가 run을 호출한다.
		}
	}
	
	public void run(){
		int x = 5 + (int)(Math.random()*275);
		int y = 5 + (int)(Math.random()*160);
		int dx = (int)(7.5 + Math.random()*5);
		int n = (int)(2+Math.random()*3);
		int t=0;
		while(true){ 
			System.out.println("Tick" + ++t);
			Graphics g = dc.getGraphics();
			if(x>=dc.getWidth()-20 || x<=5)
				dx = -dx;
			x+=dx;
			if(g!=null){
				g.setColor(Color.yellow);
				if(dx>0) g.drawString("--*-", x, y);
				else g.drawString("-*--", x, y);
			}
			
			
			
			
			try{Thread.sleep(1000/n);}
			catch(Exception e){}
		}
	}
}
