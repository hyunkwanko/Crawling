package exam;

import java.awt.*;
import java.awt.event.*;

public class ImageTest {
	public static void main(String[] args){
		new ImageExample();
	}
}

class ImageExample extends Frame{
	Image im=null;
	int x0=0, y0=0,w=0,h=0,dw=0,dh=0;
	public ImageExample(){
		super("ImageExample - ÇÙ½É ÀÚ¹Ù v.2");
		init();
		setSize(1200,800); setVisible(true);
		start();
	}
	public void init(){
		im = Toolkit.getDefaultToolkit().getImage("Captain.jpg");
	}
	public void start(){
		for(int i=0;i<100;i++){
			repaint();
			try{
				Thread.sleep(100);
			}catch(Exception e){}
		}
	}
	public void paint(Graphics g){
		if(w<=0){
			w=im.getWidth(this);
			h=im.getHeight(this);
			dw = w/4; dh = h/4;
			x0 = (1200-2*w)/2;
			y0 = (800-h)/2;
		}
		int dx = (int)(Math.random() * (w-dw));
		int dy = (int)(Math.random() * (h-dh));
		g.drawImage(im, x0, y0, w,h,this);
		g.drawString("Captain", x0, y0+h+20);
		g.drawImage(im, x0+w+dx, y0+dy, x0+w+dx+dw, y0+dy+dh,dx,dy,dx+dw,dy+dh,this);
	}
}
