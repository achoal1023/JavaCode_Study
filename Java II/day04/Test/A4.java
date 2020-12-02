import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A4 extends JFrame {
	JButton b;
	void init(){
	b = new JButton("button");
	add(b);
	ActionListener listener = new A4Handler(this);
	b.addActionListener(listener);

	setUI();
	}

	void setUI(){
		setTitle("4 ui");
		setSize(300, 300);
		setVisible(true);
		setLocation(300, 300);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		A4 a4 = new A4();
		a4.init();
	}
}