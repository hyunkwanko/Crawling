package exam;

import java.applet.*;
import java.util.*; 
import java.text.*;
import java.awt.*;

public class DigitalClock extends Applet{ // Applet을 상속받는다.
	Repainter rp;
	public void start(){
		rp = new Repainter(this, 1000);
		rp.start(); // Thread의 start() 호출
	}
	public void paint(Graphics g){
		Calendar cal = Calendar.getInstance(); //Calendar 인스턴스를 하나 얻어온다.
		Date date = cal.getTime(); // data에 Calendar함수의 getTime 함수를 불러와 저정한다. 
		DateFormat dateFormatter = DateFormat.getTimeInstance(); // 시간
		DateFormat date2Formatter = DateFormat.getDateInstance(DateFormat.SHORT); // 날짜
		g.setFont(new Font("굴림", Font.BOLD, 36));
		g.drawString(date2Formatter.format(date), 30+65, 70); // 날짜
		g.drawString(dateFormatter.format(date), 30, 120); // 시간
		setBackground(Color.cyan);
	}
	class Repainter extends Thread{
		Component comp;
		int timeInterval;
		public Repainter(Component comp, long timeInterval){
			this.comp = comp;
			this.timeInterval = (int)timeInterval; // 1000msec --> 1초
		}
		public void run(){ // overriding Thread's run()
			while(true){
				try{
					comp.repaint();
					sleep(timeInterval);
				}catch(Exception e){}
			}
		}
	}
	
	public static void main(String[] args){ // 애플리케이션으로 바꿀때 main문 호출하여 만든다  
											//--> 애플리케이션으로 바꿀때 추가할 것들
		Frame f = new Frame("Digital"); //
		DigitalClock dc = new DigitalClock();
		f.add("Center", dc);//
		dc.start();
		f.setSize(300, 200);//
		f.setVisible(true);//
	}
}
