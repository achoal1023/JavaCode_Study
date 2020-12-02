import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A4 extends JFrame { //Container 
	JButton b; //UI Component
	void init(){
		b = new JButton("자바의 버튼");
		add(b);
        ActionListener listener = new A4Handler(this);
        b.addActionListener(listener);

		setUI();
	}
	void setUI(){
		setTitle("GUI Test Ver 1.0");
		setSize(300, 200);
		setVisible(true);
		setLocation(200, 100);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		A4 a4 = new A4();
		a4.init();
	}
}
class A4Handler implements ActionListener {
	A4 a4;
	JButton b;
	A4Handler(A4 a4){
		this.a4 = a4;
	}
	public void actionPerformed(ActionEvent e){
		a4.b.setText("버튼 클릭됨!!( by 제3클래스 )");

	}
}