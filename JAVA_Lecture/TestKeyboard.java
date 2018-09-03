package exam;

import java.awt.*;
import java.awt.event.*;

public class TestKeyboard extends Frame {
	TextArea ta;
	Button[] btn = new Button[27];
	String[] key = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
			"O","P","Q","R","S","T","U","V","W","X","Y","Z","Enter"};
	TestKeyboard(){
		super("���峭 Ű����");
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
		add(ta); // Ű���� ��ܿ� ��ġ
	}
	
	void repair(){
		Suriman axr = new Suriman(ta);
		for(int i=0;i<key.length;i++)
			btn[i].addActionListener(axr);
		addWindowListener(
			new WindowAdapter(){ // �͸� Ŭ������ ��ü
				public void windowClosing(WindowEvent e){
						System.exit(0);
				}
			}
		);
		System.out.println("���� ��");
		setTitle("������ Ű����");
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
