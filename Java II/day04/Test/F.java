import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;

class F extends JFrame implements ActionListener{
	Container cp;
	JButton b;
	ImageIcon ii;
	ImageIcon ii2;
	private Image background=new ImageIcon(F.class.getResource("ii2.jpg")).getImage();
	
	public void paint(Graphics g) {//그리는 함수
		g.drawImage(background, 0, 0, null);//background를 그려줌
}
	void init(){
		cp = getContentPane();
		loadImg();
		cp.setLayout(null);
		b = new JButton(ii);
		b.addActionListener(this);
		cp.add(b);
		b.setBounds(130, 385, 100, 90);

		setUI();
	}

	void loadImg(){
		try{
			File f = new File("1.png");
			BufferedImage bi = ImageIO.read(f);
			ii = new ImageIcon(bi);
			
			ii2 = new ImageIcon(ImageIO.read(new File("turtle.png")));
		
		}catch(IOException ie){
		}
	}

	void setUI(){
		setTitle("F.ui");
		setSize(800, 800);
		//pack(); // 넣은 이미지 아이콘 크기에 맞게 사이즈 맞춰줌
		setVisible(true);
		setLocation(100, 100);

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e){
		int answer = JOptionPane.showConfirmDialog(null, "   사실 나야 ㅋ", "ㅋ",
			JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			ii2);
	}

	public static void main(String[] args){
		F f = new F();
		f.init();
	
	}
}
