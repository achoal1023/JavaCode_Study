import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class A1 extends JFrame { //Container
	class A1Handler implements ActionListener {		// ActionListener 기능 사용을 위해 상속!!! import도 해줘야함!!
		public void actionPerformed(ActionEvent e){        // e는 근본적인 주체
			//System.out.println("이벤트 발생 감지!");					  // 이거는 실행기에 뜨는 텍스트임
			b.setText("버튼 클릭됨!!( by 유명내부클래스 )");				  // 이거는 내가 눌렀을 때 보이는 ui에서 뜨는 텍스트임  <1번방법>

			//JButton bb = (JButton)e.getSource(); // 주체?? 이해 필요함											 <2번방법>
			//bb.setText("버튼 클릭됨!!( by 유명내부클래스 )");
		}
	}
	JButton b;  //버튼 생성 기능 초기화  (UI Component)
	
	void init(){
		b = new JButton("자바의 버튼"); //버튼에 초기값 부여
		add(b); //이게 있어야 기능 추가인듯?
		ActionListener listener = new A1Handler();  // 위에서 상속받아 추가한 기능을 여기서 사용 할 수 있게 여기서 선언
		b.addActionListener(listener);	//버튼을 눌렀을 때 기능 액션 생성    ui는 api참고 해야함 > 여기선 (listener) 기능 넣어줌

		setUI();
	}
	void setUI(){
		setTitle("GUI Test Ver 1.0");	//UI 타이틀명
		setSize(300, 200);				//UI 가로 세로 사이즈   ***모든 사이즈 기준은 !!왼쪽 상단기준!!
		setVisible(true);				//화면에 출력 (false)시 출력x
		setLocation(200, 100);			//UI 띄우는 좌표 *** !!왼쪽 상단기준 !!
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]){
		A1 a1 = new A1();
		a1.init();
	}
}