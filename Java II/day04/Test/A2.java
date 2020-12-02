import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A2 extends JFrame{
	JButton b;
	void init(){
		b = new JButton("버튼");
		add(b);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b.setText("버튼 클릭됨!");
			}
		});

		setUI();
	}

	void setUI(){
		setTitle("두번째 방법 UI");
		setSize(200, 200);
		setVisible(true);
		setLocation(200, 200);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		A2 a2 = new A2();
		a2.init();
	
	}
}