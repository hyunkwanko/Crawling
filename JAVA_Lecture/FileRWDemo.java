package exam;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileRWDemo extends Frame implements ActionListener{
	TextArea tarea;
	Button loadbtn, savebtn;
	FileDialog fdialog;
	
	public FileRWDemo(){
		Panel panel = new Panel();
		loadbtn = new Button("Load");
		loadbtn.addActionListener(this);
		panel.add(loadbtn);
		
		savebtn = new Button("Save");
		savebtn.addActionListener(this);
		panel.add(savebtn);
		
		tarea = new TextArea("", 10, 50);
		add("North", panel);
		add("Center", tarea);
		addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
					}
				}
			);
		setSize(300,400);
		setVisible(true);
	}
	public static void main(String[] args){
		new FileRWDemo();
	}
	public void actionPerformed(ActionEvent e){
		if((Button)e.getSource() == loadbtn){
			fdialog = new FileDialog(this, "읽기", FileDialog.LOAD);
			fdialog.setVisible(true);
			String pname = fdialog.getDirectory(); // 경로
			String fname = fdialog.getFile(); // 파일 이름
			try{
				File f = new File(pname, fname);
				BufferedReader br = new BufferedReader(new FileReader(f));
				String lineBuffer;
				while((lineBuffer = br.readLine())!=null)
					tarea.append(lineBuffer + "\n");
				br.close();
			}catch(IOException ex){System.exit(0);}
		}
		else{
			fdialog = new FileDialog(this, "쓰기", FileDialog.SAVE);
			fdialog.setVisible(true);
			String pname = fdialog.getDirectory(); // 경로
			String fname = fdialog.getFile(); // 파일 이름
			try{
				File f = new File(pname, fname);
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write(tarea.getText());
				bw.flush();
				bw.close();
			}catch(IOException ex){System.exit(0);}
		}
	}
}
