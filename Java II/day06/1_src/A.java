package aa.bb.cc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;

class A extends JFrame implements ActionListener{
	Container cp;
	JPanel pN, pN2, pS, pC;
	JButton sLb;         // score time
	JLabel tLb, qLb;
	JButton oBtn, xBtn, pBtn;   // o x pass
	JButton mBtn, rBtn, eBtn;   // music return exit
	ImageIcon Close, Music, O, X, Re, timer, score;
	ImageIcon main0, main1, main2, main3;
	ImageIcon imageList [] = new ImageIcon[4];
	Clip clip;


	

	int i = 1;


	void init(){
		loadImg();
		setButton();
		makeMusic();
		
		setUI();
	}

	void setButton(){

		
		pN = new JPanel();
		pN2 = new JPanel();
		pS = new JPanel();
		pC = new JPanel();
		sLb = new JButton(score); // 점수
		tLb = new JLabel(timer); // 시간
		qLb = new JLabel(main0); // quiz
		oBtn = new JButton(O); // o Button
		xBtn = new JButton(X); // x Button
		pBtn = new JButton("pass"); // pass Button
		mBtn = new JButton(Music); // music Button
		rBtn = new JButton(Re); // return Button
		eBtn = new JButton(Close); // exit Button

		
		pN.setBackground(Color.WHITE);
		pN2.setBackground(Color.WHITE);
		pS.setBackground(Color.WHITE);
		pC.setBackground(Color.WHITE);
		sLb.setBackground(Color.pink);
		sLb.setBorderPainted(false);
		tLb.setBackground(Color.pink);
		//tLb.setBorderPainted(false);
		//qLb.setBackground(Color.pink);
		//qLb.setBorderPainted(false);
		oBtn.setBackground(Color.pink);
		oBtn.setBorderPainted(false);
		xBtn.setBackground(Color.pink);
		xBtn.setBorderPainted(false);
		pBtn.setBackground(Color.pink);
		pBtn.setBorderPainted(false);
		mBtn.setBackground(Color.pink);
		mBtn.setBorderPainted(false);
		rBtn.setBackground(Color.pink);
		rBtn.setBorderPainted(false);
		eBtn.setBackground(Color.pink);
		eBtn.setBorderPainted(false);



		sLb.addActionListener(this);
		//tLb.addActionListener(this);
		//qLb.addActionListener(this);
		oBtn.addActionListener(this);
		xBtn.addActionListener(this);
		pBtn.addActionListener(this);
		mBtn.addActionListener(this);
		rBtn.addActionListener(this);
		eBtn.addActionListener(this);


		
		cp = getContentPane();
		cp.setLayout(new BorderLayout());
		pS.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));

		pS.setBorder(BorderFactory.createEmptyBorder(5,20,20,20));
		pN.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
		pC.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));

		//크기조절
		oBtn.setPreferredSize(new Dimension(84, 84)); 
		xBtn.setPreferredSize(new Dimension(84, 84));
		pBtn.setPreferredSize(new Dimension(84, 84));
		tLb.setPreferredSize(new Dimension(230, 130));
		qLb.setPreferredSize(new Dimension(720, 280));

		// x y 가로 세로
		mBtn.setBounds(700, 30, 70, 70);
		cp.add(mBtn);
		rBtn.setBounds(790, 30, 70, 70);
		cp.add(rBtn);
		eBtn.setBounds(880, 30, 70, 70);
		cp.add(eBtn);
		sLb.setBounds(90, 30, 120, 60);
		cp.add(sLb);

		cp.add(pN, BorderLayout.NORTH);

		pN.add(tLb);



		cp.add(pS, BorderLayout.SOUTH);
		pS.add(oBtn);
		pS.add(pBtn);
		pS.add(xBtn);



		cp.add(pC, BorderLayout.CENTER);
		pC.add(qLb);

		//cpc.add(qLb);
		//cpc.add(pC, BorderLayout.CENTER);
		//pC.add(cpc);
	}

	

	void loadImg(){
		try{
			
			
			main0 = new ImageIcon(ImageIO.read(new File("Image/0.png")));
			main1 = new ImageIcon(ImageIO.read(new File("Image/1.png")));
			main2 = new ImageIcon(ImageIO.read(new File("Image/2.png")));
			main3 = new ImageIcon(ImageIO.read(new File("Image/3.png")));
			imageList [0] = main0;
			imageList [1] = main1;
			imageList [2] = main2;
			imageList [3] = main3;
			Close = new ImageIcon(ImageIO.read(new File("Image/remove.png")));
			Music = new ImageIcon(ImageIO.read(new File("Image/MusicIcon.png")));
			O = new ImageIcon(ImageIO.read(new File("Image/O.png")));
			Re = new ImageIcon(ImageIO.read(new File("Image/Back.png")));
			timer = new ImageIcon(getClass().getResource("Image/Timer.gif"));
			X = new ImageIcon(ImageIO.read(new File("Image/X.png")));
			score = new ImageIcon(ImageIO.read(new File("Image/score.png")));
			
			
		}catch(IOException ie){
        System.out.println("ie: " + ie);
	
		}
	}

    void setUI(){
		setTitle("Quiz");
		pack();
		setSize(1000, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


   public void actionPerformed(ActionEvent e){
      Object obj = e.getSource();
      if(obj == oBtn){
		  qLb.setIcon(imageList[i]);
		  i = i + 1;
         pln("O");
      }else if(obj == xBtn){
		  qLb.setIcon(imageList[i]);
		  i = i + 1;
         pln("X");
      }else if(obj == pBtn){
		  qLb.setIcon(imageList[i]);
		  i = i + 1;
         pln("Pass");
      }else if(obj == eBtn){
		  System.exit(-1);
      }else if(obj == rBtn){
			qLb.setIcon(imageList[0]);
			i = 1;
			timer.getImage().flush();			
			tLb.setIcon(timer);
			repaint();
         pln("다시하기");
      }else if(obj == tLb){
         pln("timer");
      }else if(obj == qLb){
         pln("Quiz");
      }else if(obj == mBtn){ // BGM 이벤트
         if(clip.isRunning()==false){//bgm이 나오고 있지 않을때 시작~
            clip.start();
      }else if (clip.isRunning()==true){//bgm이 나오고 있을때 스탑~
            clip.stop();
      }else{
         pln("점수 : ");
      }
      }
   }
   void pln(String str){
      System.out.println(str);
   }	


	void makeMusic(){
      try{

		File morlau = new File("music/maplestory.wav");
		clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(morlau));      


      }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Error");
      }
   }

	public static void main(String[] args){
		A a = new A();
		a.init();
      
    }
}


//jBtn.setBackground(Color.GREEN);
//jBtn.setBorder(BorderFactory.createCompoundBorder(
//               BorderFactory.createLineBorder(Color.CYAN, 5),
//               BorderFactory.createLineBorder(Color.BLACK, 20)));