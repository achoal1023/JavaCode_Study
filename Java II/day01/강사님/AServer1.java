import java.io.*;
import java.net.*;

class AServer1{
	ServerSocket ss;
	Socket s;
	String ip = "192.168.0.131";
	int port = 1994;

	DataInputStream dis;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	InputStream is;
	OutputStream os;
	DataOutputStream dos;
	PrintStream ps = System.out;

	AServer1(){
		try{
			ss = new ServerSocket(port);
			s = new Socket(ip, port);
			pln("서버가"+port+"번 포트에서 대기중 ...");

			s = ss.accept();
			pln("Client("+s.getInetAddress().getHostAddress()+") 연결 성공");

			readyIO();
			listen();
			speak();
		}catch(IOException ie){
		}
	}

	void readyIO(){
		try{
			os = s.getOutputStream();
			dos = new DataOutputStream(os);

			is = s.getInputStream();
			dis = new DataInputStream(is);
		}catch(IOException ie){}
	}

	void speak(){
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

	void listen(){
		try{
			String line = null;
			while((line=dis.readUTF()) != null){
				ps.println("클라이언트>> " + line);
			}
		}catch(IOException ie){}
	}

	void pln(String str){
		System.out.println(str);
	}

	public static void main(String[] args){
		new AServer1();
	}
}
