import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A3 extends JFrame implements ActionListener {
	JButton b;
	void init(){
		b = new JButton("¹öÆ°");
		add(b);
		b.addActionListener(this);

		setUI();
	}

	void setUI(){
		setTitle("3.UI");
		setSize(300, 300);
		setVisible(true);
		setLocation(300, 300);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		b.setText("click");
	}
	public static void main(String[] args){
		A3 a3 = new A3();
		a3.init();
	
	}
}