import java.io.*;
import java.net.*;
import java.lang.Thread;

class ZClient extends Thread  {
	Socket s;
	String ip = "192.168.0.131";
	int port = 1994;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Keyboard
	InputStream is;
	DataInputStream dis;
	OutputStream os; //Node 
	PrintStream ps = System.out; 
	DataOutputStream dos; //Filter 

	ZClient(){
		try{
			s = new Socket(ip, port);
			pln("서버와 연결 성공");

			readyIO();
			start();
			speak();
			
		}catch(UnknownHostException ne){
		}catch(IOException ie){
			pln("서버("+ip+")를 네트워크에서 찾을 수 없음");
		}
	}

	public void run(){
		listen();
	}
	void readyIO(){
		try{
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			is = s.getInputStream();
			dis = new DataInputStream(is);
		}catch(IOException ie){
		}
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
			String line = null;
			while((line=br.readLine()) != null){
				dos.writeUTF(line);
				dos.flush();
			}
			pln("서버에 메세지 전송 완료");
		}catch(IOException ie){
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) {
		new ZClient();
		
	}
}
