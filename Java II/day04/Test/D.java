import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class D extends JFrame implements ActionListener{
	
	String labels[] = {"Button1", "Button2", "Button3", "Button4", "Button5","Button6"};
	JButton bs[];
	Container cp;

	D(){
		bs = new JButton[labels.length];
	}
	void init(){
		setLayout(new FlowLayout());
		//setLayout(new CardLayout());
		cp = getContentPane();
		for(int i=0; i<bs.length; i++){
			bs[i] = new JButton(labels[i]);
			bs[i].addActionListener(this);
			cp.add(bs[i]);
		}

		setUI();
	}

	void setUI(){
		setTitle("D ui");
		setSize(300, 200);
		setVisible(true);
		setLocation(300, 300);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		cp.remove((JButton)obj);

		revalidate();
		repaint();
	}


	public static void main(String[] args){
		D d = new D();
		d.init();
	}
}