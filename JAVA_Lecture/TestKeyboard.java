package exam;

import java.awt.*;
import java.awt.event.*;

public class TestKeyboard extends Frame {
	TextArea ta;
	Button[] btn = new Button[27];
	String[] key = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
			"O","P","Q","R","S","T","U","V","W","X","Y","Z","Enter"};
	TestKeyboard(){
		super("고장난 키보드");
		setLayout(new FlowLayout());
		
		upgrade();
		for(int i=0;i<key.length;i++)
			add(btn[i] = new Button(key[i]));
		repair();
		
		setSize(290, 130+100);
		setVisible(true);
	}
	
	void upgrade(){
		ta = new TextArea(5,35);
		add(ta); // 키보드 상단에 위치
	}
	
	void repair(){
		Suriman axr = new Suriman(ta);
		for(int i=0;i<key.length;i++)
			btn[i].addActionListener(axr);
		addWindowListener(
			new WindowAdapter(){ // 익명 클래스의 객체
				public void windowClosing(WindowEvent e){
						System.exit(0);
				}
			}
		);
		System.out.println("수리 끝");
		setTitle("수리된 키보드");
	}
	
	
	public static void main(String[] args){
		TestKeyboard kb = new TestKeyboard();
	}

}

class Suriman implements ActionListener{
	TextArea ta;
	Suriman(TextArea ta){
		this.ta = ta;
	}
	
	public void actionPerformed(ActionEvent e){
		Button bx = (Button) e.getSource();
		System.out.print(bx.getActionCommand());
		ta.append(bx.getActionCommand());
	}
}
