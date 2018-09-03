package exam;

import java.awt.*;
import java.awt.event.*;

public class ListDemo extends Frame implements ItemListener, ActionListener{
	public ListDemo(){
		Panel panel = new Panel();
		List list = new List(3,false); // 숫자는 보이는 개수, false 는 다중선택 안한다.
		String msg[] = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
		for(int i=0;i<msg.length;i++)
			list.add(msg[i]);
		list.select(3);
		list.addItemListener(this);
		list.addActionListener(this);
		panel.add(list);
		add(panel);
		setSize(150,200);
		setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent e){
		int i = ((List)e.getSource()).getSelectedIndex();
		String s = ((List)e.getSource()).getSelectedItem();
		System.out.println("I-Selection" + i + " == " + s);
	}
	public void actionPerformed(ActionEvent e){
			//((List)e.getSource().getSelectedItem());
	}
	
	public static void main(String[] args){
		ListDemo list = new ListDemo();
	}
}
