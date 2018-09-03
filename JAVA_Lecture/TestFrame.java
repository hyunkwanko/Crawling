package exam;

import java.awt.*;
public class TestFrame extends Frame{
	TestFrame(String title){
		super(title);
		setBackground(Color.CYAN);
		setLayout(new FlowLayout());
		add(new Label("∑π¿Ã∫Ì"));
		Label biggerlabel = new Label("I wanna Bigger Labels");
		biggerlabel.setFont(new Font("Helvetica", Font.BOLD, 24));
		biggerlabel.setBackground(Color.WHITE);
		add(biggerlabel);
		Button btn1, btn2;
		String s1 = "OK", s2 = "No";
		btn1 = new Button(s1);
		btn2 = new Button(s2);
		add(btn1);
		add(btn2);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args){
		TestFrame f = new TestFrame("title");
		for(int i=1;i<5;i++){
			int x = (int) (Math.random()*10) + 100;
			int y = (int) (Math.random()*10) + 100;
			f.setLocation(x, y);
		}
	}
}

