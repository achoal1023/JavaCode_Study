import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class C extends JFrame{
	JButton b1, b2, b3, b4;
	Container cp;

	void init(){
		b1 = new JButton("Button1");
		b2 = new JButton("Button2");
		b3 = new JButton("Button3");
		b4 = new JButton("Button4");
		CHandler h = new CHandler(this);
		b1.addActionListener(h);
		b2.addActionListener(h);
		

		setLayout(new GridLayout(2, 3));
		cp = getContentPane();
		cp.add(b1);cp.add(b2);cp.add(b3);cp.add(b4);
		cp.add(new JButton("Button5"));

		setUI();
	}

	void setUI(){
		setTitle("c ui");
		setSize(400,300);
		setVisible(true);
		setLocation(300, 300);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public static void main(String[] args){
		C c = new C();
		c.init();	
	}
}





class CHandler implements ActionListener{
	C c;
	CHandler(C c){
		this.c = c;
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		JButton b = (JButton)obj;
		if(obj == c.b1){
			c.b1.setText("1click");
			System.out.println("1´­¸²¤»");
		}else{
			c.b2.setText("2click");
		}
	}
}