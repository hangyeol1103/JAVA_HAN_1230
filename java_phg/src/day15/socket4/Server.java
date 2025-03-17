package day15.socket4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Server {

	//클라이언트들에게 메세지를 보내기 위한 리스트
	
	private Socket socket;
	private List<ObjectOutputStream> list = new ArrayList<ObjectOutputStream>();
	
	private final static String EXIT = "EXIT";
	
	//클라이언트 중 한명이 메세지를 보내면 모든 클라이언트들에게 메세지를 전송
	public void receive() {
		Thread t = new Thread(()->{
			String id = "";
			try {
				//list에 연결된 클라이언트를 추가
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				list.add(oos);
				
				//무한루프로 반복
				while(true) {
					id = ois.readUTF();
					String chat = ois.readUTF();
					
					System.out.println(id + " : " + chat); //확인용
					boolean flag = false;
					synchronized (list) {
						for(ObjectOutputStream client : list) {
							//메세지를 쓴 클라이언트에겐 메세지를 보내지 않음
							if(client != oos && !chat.equals(EXIT)) {
								send(client, id, chat);
							}
							//연결된 클라이언트가 EXIT를 입력했을 때
							else if(client == oos && chat.equals(EXIT)) {
								//클라이언트의 receive()에 있는 쓰레드를 종료하기 위해서
								send(client, id, chat);
								flag = true;
							}
						}						
					}
					if(flag) {
						list.remove(oos);						
					}
				}
				
			}catch(IOException e) {
				System.out.println(id + "님이 나갔습니다.");
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		t.start();
	}
	
	private void send(ObjectOutputStream client, String id, String chat) {
		if(client == null || id == null || chat == null) {
			return;
		}
		
		try {
			/* synchronized
			 * 하나의 클라이언트에 여러 메세지를 동시에 보내려고 하면 순서가 꼬이거나 예상치 못한 문제가 발생할 수 있다
			 * 이 때 동기화를 통해 먼저 들어온 작업부터 실행되도록 해줌 
			 * 같이 보내는 경우에 먼저 작업하는 애가 끝나면 그다음 사람이 실행하게 해주는 동기화 기능을 함 */
			synchronized(client) { 
				client.writeUTF(id);
				client.writeUTF(chat);
				client.flush();
			}
			
		}catch(Exception e) {
			list.remove(client); //전송하는 중에 예외가 발생하면 client에 문제가 생긴 것이기 때문에 list에서 remove 한다.
			e.printStackTrace();
		}
	}

	public void send() {
		
	}
	
}
