import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A21 extends JFrame {
	JButton b;
	void init(){
		b = new JButton("¹öÆ°");
		add(b);
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				b.setText("Å¬¸¯µÊ ¤»");
			}
		});

		setUI();
	}
	void setUI(){
		setTitle("2. UI");
		setSize(200, 200);
		setVisible(true);
		setLocation(200, 200);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		A21 a21 = new A21();
		a21.init();
	
	}
}