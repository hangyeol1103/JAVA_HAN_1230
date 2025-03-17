package day17;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Server {
	
	private Socket socket;
	private List<Record> list;
	
	public void run() {
		Thread t = new Thread(()->{
			try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			System.out.println("[연결 성공!]");
			
			while(true) {
				
				//메뉴를 입력받음(클라이언트에게)
				int menu = ois.readInt();
				//메뉴에 따라 기능을 실행
				runMenu(menu, ois, oos);
				//
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	});
	t.start();
	}
	
	private void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch(menu) {
		case 1:
			insertRecord(ois, oos);
			break;
		case 2:
			recordView(ois,oos);
			break;
		}
	}

	private void insertRecord(ObjectInputStream ois, ObjectOutputStream oos) {
		//기록을 수신(클라이언트)
		try {
			Record r = (Record)ois.readObject();
			//기록을 추가
			boolean res = list.add(r);
			
			//기록을 정렬
			Collections.sort(list, (o1, o2) ->{
				Record r1 = (Record)o1; //형 변환 위한 작업
				Record r2 = (Record)o2; //형 변환 위한 작업
				if(r1.getCount() != r2.getCount()) {
					return r1.getCount() - r2.getCount();
				}
				if(r1.getDate().equals(r2.getDate())) {
					return r1.getDate().compareTo(r2.getDate());
				}
				return r1.getNickName().compareTo(r2.getNickName());
			});
			
			//클라이언트에게 결과를 전달
			oos.writeBoolean(res);
			oos.flush();
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		
	}

	private void recordView(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			//클라이언트에게 기록 리스트를 전송(최대 5개)
			List<Record> tmpList = list.subList(0, Math.min(5, list.size())); //Math.min(v1, v2)는 v1, v2중에 더 작은 값을 갖음.
			List<Record> sendList = new ArrayList<Record>();
			sendList.addAll(tmpList);
			oos.writeObject(sendList);
			oos.flush();
		}catch(Exception e) {
			System.out.println("[기록 조회 시 예외 발생]");
		}
	}
}
