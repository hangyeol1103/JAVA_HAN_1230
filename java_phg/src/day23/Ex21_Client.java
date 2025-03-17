package day23;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ex21_Client {

	public static void main(String[] args) {
		int port = 3000;
		String serverIP = "192.168.20.34";
		
		try {
			
			Socket socket = new Socket(serverIP, port);
			
			System.out.println("연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
