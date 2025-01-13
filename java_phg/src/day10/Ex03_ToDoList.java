package day10;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex03_ToDoList {
	
	/* 다음 기능을 갖는 프로그램을 작성하세요.
	 * 1. 할일 등록
	 * 2. 할일 삭제
	 * 3. 할일 조회
	 * 4. 종료
	 * 메뉴 선택 : 1
	 * 등원
	 * 1. 할일 등록
	 * 2. 할일 삭제
	 * 3. 할일 조회
	 * 4. 종료
	 * 메뉴 선택 : 1
	 * 수업
	 * 1. 할일 등록
	 * 2. 할일 삭제
	 * 3. 할일 조회
	 * 4. 종료
	 * 메뉴 선택 : 2
	 * 1.등원
	 * 2.수업
	 * 삭제할 할일을 선택 : 1
	 * 삭제 되었습니다.
	 * 1. 할일 등록
	 * 2. 할일 삭제
	 * 3. 할일 조회
	 * 4. 종료
	 * 메뉴 선택 :3
	 * 1. 수업
	 * 1. 할일 등록
	 * 2. 할일 삭제
	 * 3. 할일 조회
	 * 4. 종료
	 * 메뉴 선택 : 4
	 * 프로그램을 종료합니다.
	 * */
	
	static Scanner scan = new Scanner(System.in);
	
	static ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		
		int menu;
		do {
		
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine(); //위에서 입력한 엔터 처리
			
			runMenu(menu);
			
		}while(menu != 4);
		
	}


	private static void printMenu() {
		System.out.println("1.할일 등록");
		System.out.println("2.할일 삭제");
		System.out.println("3.할일 조회");
		System.out.println("4.종료");
		System.out.print("메뉴 선택 : ");
	}
	
	private static void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			insertToDo();
			break;
		case 2:
			deleteToDo();
			break;
		case 3:
			printToDoList();
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴를 선택하세요.");
		}
	}


	private static void deleteToDo() {
		//할일들을 출력하고
		if(!printToDoList()) { //삭제할 할일이 없으면 굳이 삭제할 할일 번호 선택이 뜨지 않게 하기 위해서
			return;
		}
		//삭제할 번호 입력
		System.out.print("삭제할 할일 번호 선택 : ");
		int index = scan.nextInt() - 1; //1번지가 아니라 0번지 부터 해야되기 때문에 -1
		
		if(index >= list.size() || index <0) { //등록된 번호는 1,2인데 1,2를 제외한 다른 번호를 입력한 경우의 예외 처리
			System.out.println("잘못된 번호입니다.");
			return;
		}
		
		list.remove(index); //index번지에 있는 것 삭제
		
	}


	private static boolean printToDoList() {
		//예외처리, list가 없을 때.
		if(list.size() == 0) {
			System.out.println("등록된 할일이 없습니다.");
			return false;
		}
		
		//할일들을 출력
		for(int i = 0; i<list.size(); i++) { //0부터 list 자체 사이즈 까지 1.부터 출력함 그리고 get으로 i번째를 가져와서 출력
			System.out.println(i+1 + ". " + list.get(i)); 
		}
		return true;
		
	}


	private static void insertToDo() {
		
		//안내문구 출력
		System.out.print("할일 : ");
		//할일을 입력
		String toDo = scan.nextLine();
		//할일을 할일 리스트에 추가
		list.add(toDo);
		System.out.println("할일을 등록 했습니다.");
	}

}
