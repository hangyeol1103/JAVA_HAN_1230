package day15.socket3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

//Client 클래스를 이용하여 서버와 클라이언트가 문자열을 주고 받는 예제
//Client 클래스를 이용한 1대1 채팅
@AllArgsConstructor
public class Client {
	
	private Socket socket;
	
	private final static String EXIT = "EXIT";
	
	//연결된 소켓으로 데이터를 받아오는 기능
	public void receive() {
		Thread t2 = new Thread(()->{
		
			try {
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				while(true) {
					String str = ois.readUTF();
					System.out.println("수신 : " + str);
					if(str.equals(EXIT)) {
						break;
					}
				}
				System.out.println("[수신 기능을 종료합니다.]");
			} catch (Exception e) {

				e.printStackTrace();
			}
		});
		t2.start();
	}
	
	//연결된 소켓으로 데이터를 전송하는 기능
	public void send() {
		Thread t1 = new Thread(()->{
			Scanner scan = new Scanner(System.in);
			
			try {
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

				while(true) {
					System.out.print("입력(종료 : " + EXIT + ") ");
					String str = scan.nextLine();
					oos.writeUTF(str);
					oos.flush(); //버퍼가 다 차지 않아도 전송하게 하는 역할
					if(str.equals(EXIT)) {
						break;
					}
				}
				System.out.println("[전송 기능을 종료합니다.]");
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		t1.start();
	}
}
