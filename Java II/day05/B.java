import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.border.*;

class B extends JFrame {
	Container cp;
	ImageIcon ii;
	JLabel laImg;
	JLabel laFont;
	B(){
		laImg = new JLabel();
		laFont = new JLabel();
	}
	void init(){
		loadImg();
		setLaImg();
		cp = getContentPane();
		cp.add(laImg);

		laFont.setText("코코볼 먹고싶다");
		cp.add(laFont, BorderLayout.NORTH);

	    setUI();
	}

	void setLaImg(){
		//(1) Icon 셋팅
		laImg.setIcon(ii);
		//(2) Font 셋팅
		laFont.setFont(new Font("굴림체", Font.BOLD, 40));
		laFont.setHorizontalAlignment(JLabel.CENTER); 
		//(3) Border 셋팅
		Border oBorder = laFont.getBorder();
		Border eBorder = new EmptyBorder(20, 10, 10, 10); //12기준 반시계방향 위 왼 밑 오
		CompoundBorder cBorder = new CompoundBorder(oBorder, eBorder);
		laFont.setBorder(cBorder);
	}

	void loadImg(){
		//방법1
		/*try{
			File f = new File("imgs/dance.gif");
			BufferedImage bi = ImageIO.read(f);
			ii = new ImageIcon(bi);
		}catch(IOException ie){
		}*/

        //방법2
		ii = new ImageIcon(getClass().getResource("cocoball.gif")); 
	}
	void setUI(){
		setTitle("Cocoball");
		pack();
		setVisible(true);
		//setLocation(300, 100);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new B().init();
	}
}
