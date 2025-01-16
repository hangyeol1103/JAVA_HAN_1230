package homework_;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.Data;

public class Homework {

	/* KBS 일자별 주간 프로그램 편성표
	 * 1. 프로그램 추가
	 * 2. 프로그램 수정
	 * 3. 프로그램 삭제
	 * 4. 프로그램 조회
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 
	 * */
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Program> list = new ArrayList<Program>();
	public static void main(String[] args) {
		
		int menu;
		
		do {
			printMenu();
			
			menu = scan.nextInt();
			
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu != 5);
		
		
	}
	
	private static void printMenu() {
		System.out.print("--------------------------\r\n"
				+ "KBS 일자별 주간 프로그램 편성표\r\n"
				+ "1. 프로그램 추가\r\n"
				+ "2. 프로그램 수정\r\n"
				+ "3. 프로그램 삭제\r\n"
				+ "4. 프로그램 조회\r\n"
				+ "5. 프로그램 종료\r\n"
				+ "--------------------------\r\n"
				+ "메뉴 선택 : ");
	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertProgram();
			break;
		case 2:
			updateProgram();
			break;
		case 3:
			deleteProgram();
			break;
		case 4:
			searchProgram();
			break;
		case 5:
			System.out.println("프로그램이 종료됐습니다.");
			break;
		default:
			System.out.println("올바른 메뉴 선택이 아닙니다.");
			
		}
		
		
	}
	
	private static void insertProgram() {
		System.out.print("일자 : ");
		String day = scan.nextLine();
		System.out.print("시간 : ");
		String time = scan.nextLine();
		System.out.print("프로그램명 : ");
		String name = scan.nextLine();
		System.out.print("설명 : ");
		String explane = scan.nextLine();
		
		//pro라는 객체에 값 입력 받음
		Program pro = new Program(day, time, name, explane);
		list.add(pro);
		System.out.println(pro + " 프로그램이 등록되었습니다.");
		
		
	}
	
	private static void updateProgram() {
		for(int i = 0; i<list.size(); i++) {
			System.out.println(i+1 + ". " + list.get(i));
		}
		
		System.out.println("수정할 프로그램 번호 입력 : ");
		int index = scan.nextInt() - 1;
		
		if(list.size() == 0 || index < 0) {
			System.out.println("등록된 프로그램이 없습니다.");
		}
	}
	
	private static void deleteProgram() {
		//입력 받은 리스트들을 출력
		for(int i = 0; i<list.size(); i++) {
			System.out.println(i+1 + ". " + list.get(i));
		}
		System.out.println("삭제할 프로그램 번호 입력 : ");
		int index = scan.nextInt() - 1;
		
		if(index >= list.size() || index < 0) {
			System.out.println("잘못된 번호를 입력했습니다.");
		}
		list.remove(index);
	}
	
	private static boolean searchProgram() {
		if(list.size() == 0) {
			System.out.println("등록된 프로그램이 없습니다.");
			return false;
		}
		for(int i = 0; i<list.size(); i++) {
			System.out.println(i+1 + ". " + list.get(i));
		}
		return true;
	}
}

@Data
class Program{

	String day, time, name, explane;
	
	
	public Program(String day, String time, String name, String explane) {
		this.day = day;
		this.time = time;
		this.name = name;
		this.explane = explane;
	}


	@Override
	public String toString() {
		return day + "/" + time + "/" + name + "/" + explane;
	}
	
	
}