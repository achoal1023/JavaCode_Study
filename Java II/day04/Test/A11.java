import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A11 extends JFrame{
	class A11Handler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			b.setText("버튼클릭됨!");
		}
	}
	
	JButton b;
	void init(){
		b = new JButton("버튼");
		add(b);
		ActionListener listener = new A11Handler();
		b.addActionListener(listener);

		setUI();

		
	}

	void setUI(){
		setTitle("Java UI Test");
		setSize(200, 200);
		setVisible(true);
		setLocation(500, 500);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		A11 a11 = new A11();
		a11.init();
	}
}