import java.io.*;
import java.net.*;
import java.util.*;

class AServer extends Thread {
	ServerSocket ss;
	Socket s;
	int port = 2020; //0 ~ 65535 // Well-Known Port : 0~1023
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	InputStream is; //Node 
	DataInputStream dis;//Filter 
	OutputStream os;
	PrintStream ps = System.out; //Node : Monitor 
	DataOutputStream dos;

	ArrayList<Socket> list = new ArrayList<Socket>();

    AServer(){
		try{
			ss = new ServerSocket(port);
			pln("서버가 "+port+"번 포트에서 대기중...");
			
			while(true){
				s = ss.accept();
				pln("Client("+s.getInetAddress().getHostAddress()+") 연결 성공");
				list.add(s);


				readyIO();
				start();
				listen();
			}
        }catch(IOException ie){
			pln("ie: " + ie);
		}
	}
	public void run(){
		speak();
	}
	void readyIO(){
		try{
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			is = s.getInputStream();
			dis = new DataInputStream(is);
		}catch(IOException ie){}
	}
	void listen(){ //Socket -> Moniter
		try{
			String line = null;
			while((line=dis.readUTF()) != null){
				ps.println("클라이언트>> " + line);
			}
		}catch(IOException ie){
		}
	}
	void speak(){ //Keyboard -> Socket 
		try{
			String name = null;
			String line = null;
			boolean identify = false;

			while((line=br.readLine()) != null){
				if(!identify){
					name = line;
					identify = true;
					pln(name + "님이 접속하셨습니다.");
					continue;	
				}
				for(int i = 0; i<list.size(); i++){
					
					dos.writeUTF(name + " : " + line);
					dos.flush();
				}
			}
			pln("서버에 메세지 전송 완료");
		}catch(IOException ie){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new AServer();
		
	}
}
