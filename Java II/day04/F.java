import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIo;
import javax.swing.*;
import java.io.*;

class E extends JFrame implements ActionListener{
	Container cp;
	JButton b;
	ImageIcon ii;
	ImageIcon ii2;
	
	void init(){
		cp = getContentPane();
		loadImg();
		b = new JButton(ii);
		b.addActionListener(this);
		cp.add(b);

		setUI();
	}

	void loadImg(){
		try{
			File f = new File("ii.jpg");
			BufferedImage bi = ImageIO.read(f);
			ii = new ImageIcon(bi);
			
			ii2 = new ImageIcon(ImageIO.read(new File("ii2.jpg")));
		
		}catch(IOException ie){
		}
	}

	void setUI(){
		setTitle("E.ui");
		//setSize(500, 500);
		pack(); // 넣은 이미지 아이콘 크기에 맞게 사이즈 맞춰줌
		setVisible(true);
		setLocation(300, 300);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e){
		int answer = JOptionPane.showConfirmDialog(null, "눌러봐", "ㅋ",
			JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			ii2)
	}

	public static void main(String[] args){
		E e = new E();
		e.init();
	
	}
}
