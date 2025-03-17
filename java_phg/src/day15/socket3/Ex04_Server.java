package day15.socket3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ex04_Server {

	public static void main(String[] args) {
		
		int port = 5001;
		
		try{
			//서버 소켓 생성
			ServerSocket serverSocket = new ServerSocket(port);
			
			System.out.println("[연결 대기 중...]");
			
			//연결 대기, 요청 수락 후 소켓 객체 생성
			Socket socket = serverSocket.accept();
			
			System.out.println("[연결 성공!]");
			
			Client c = new Client(socket);
			c.send();
			c.receive(); //쓰레드로 동작하기 때문에 send와 receive 순서는 중요하지 않음.
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
