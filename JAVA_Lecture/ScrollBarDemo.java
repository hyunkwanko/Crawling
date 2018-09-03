package exam;

import java.awt.*;
import java.awt.event.*;
public class ScrollBarDemo extends Frame implements AdjustmentListener {
	int value = 70;
	Scrollbar hsb;
	TextField tf;
	Label ltop;
	
	ScrollBarDemo(){
		setLayout(new BorderLayout(5,5));
		hsb = new Scrollbar(Scrollbar.HORIZONTAL,70,25,0,225);
		hsb.addAdjustmentListener(this);
		add("North", (ltop = new Label("스크롤데모", Label.CENTER)));
		add("West", new Label("0"));
		add("Center", hsb);
		add("East", new Label("200"));
		tf = new TextField(20);
		tf.setEditable(false); // 수정불가
		add("South", tf);
		tf.setText("Min/Max = "+ hsb.getMinimum() + "/" + hsb.getMaximum() + ", value = " + hsb.getValue() +
				", bubble size = " + hsb.getVisibleAmount());
		addWindowListener(
				new WindowAdapter(){ // 익명 클래스의 객체
					public void windowClosing(WindowEvent e){
							System.exit(0);
					}
				}
			);
		setSize(300,100);
		setVisible(true);
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e){
		value = e.getValue();
		ltop.setBackground(new Color(value+55,value+55,0));
		tf.setText("Value = " + e.getValue());
	}
	
	public static void main(String[] args){
		new ScrollBarDemo();
	}
}
