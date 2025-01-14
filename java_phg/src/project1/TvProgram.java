package project1;

import java.util.Scanner;

public class TvProgram {

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		int menu;
		
		do {
			
			printMenu();
			
			menu = scan.nextInt();
			
			runMenu(menu);
			
		}while(menu != 4);
	}
	
	private static void printMenu() {
		System.out.println("------------------");
		System.out.println("KBS 주간 프로그램 편성표");
		System.out.println("1. 프로그램 추가");
		System.out.println("2. 프로그램 수정");
		System.out.println("3. 프로그램 삭제");
		System.out.println("4. 프로그램 조회");
		System.out.println("5. 프로그램 종료");
		System.out.println("------------------");
		System.out.println("메뉴 선택 : ");
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
			serach();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴를 선택하세요.");
		}
	}

}
