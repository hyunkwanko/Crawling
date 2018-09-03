package exam;

import java.applet.*;
import java.util.*; 
import java.text.*;
import java.awt.*;

public class DigitalClock extends Applet{ // Applet�� ��ӹ޴´�.
	Repainter rp;
	public void start(){
		rp = new Repainter(this, 1000);
		rp.start(); // Thread�� start() ȣ��
	}
	public void paint(Graphics g){
		Calendar cal = Calendar.getInstance(); //Calendar �ν��Ͻ��� �ϳ� ���´�.
		Date date = cal.getTime(); // data�� Calendar�Լ��� getTime �Լ��� �ҷ��� �����Ѵ�. 
		DateFormat dateFormatter = DateFormat.getTimeInstance(); // �ð�
		DateFormat date2Formatter = DateFormat.getDateInstance(DateFormat.SHORT); // ��¥
		g.setFont(new Font("����", Font.BOLD, 36));
		g.drawString(date2Formatter.format(date), 30+65, 70); // ��¥
		g.drawString(dateFormatter.format(date), 30, 120); // �ð�
		setBackground(Color.cyan);
	}
	class Repainter extends Thread{
		Component comp;
		int timeInterval;
		public Repainter(Component comp, long timeInterval){
			this.comp = comp;
			this.timeInterval = (int)timeInterval; // 1000msec --> 1��
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
	
	public static void main(String[] args){ // ���ø����̼����� �ٲܶ� main�� ȣ���Ͽ� �����  
											//--> ���ø����̼����� �ٲܶ� �߰��� �͵�
		Frame f = new Frame("Digital"); //
		DigitalClock dc = new DigitalClock();
		f.add("Center", dc);//
		dc.start();
		f.setSize(300, 200);//
		f.setVisible(true);//
	}
}
