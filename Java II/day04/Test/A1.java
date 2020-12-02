import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A1 extends JFrame{
	class A1Handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			b.setText("버튼 클릭됨!");
		}
	}

	JButton b;
	void init(){
		b = new JButton("버튼");
		add(b);
		ActionListener listener = new A1Handler();
		b.addActionListener(listener);
		

		setUI();
	}

	void setUI(){
		setTitle("UI 만들기");
		setSize(200, 200);
		setVisible(true);
		setLocation(200, 200);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	
	public static void main(String[] args){
		A1 a1 = new A1();
		a1.init();
	}
}