package day10;

import java.util.HashMap;
import java.util.Scanner;

public class Ex13_Phone {

	/* 전화번호를 관리하는 프로그램을 작성하세요.
	 * 1. 전화번호 추가
	 *  - 이름과 전화번호를 입력받아 추가
	 *  - 동명이인이 있을 수 있기 때문에 중복되도 추가
	 * 2. 전화번호 수정
	 *  - 이름을 입력
	 *  - 이름과 일치하는 목록을 출력
	 *  - 수정하려는 전화번호를 선택
	 *  - 새 전화번호를 입력받아 수정
	 * 3. 전화번호 삭제
	 * - 이름을 입력
	 * - 이름과 일치하는 목록을 출력
	 * - 삭제하려는 전화번호를 선택
	 * - 선택한 전화번호를 삭제
	 * 4. 전화번호 조회
	 * - 이름을 입력
	 * - 이름이 포함된 전화번호를 출력
	 * */
	static Scanner scan = new Scanner(System.in);
	static HashMap<String, String> map = new HashMap<String, String>();
	public static void main(String[] args) {
		
		int menu;
		
		do {
		
			printMenu();
			
			menu = scan.nextInt();
			
			runMenu(menu);			
			
		}while(menu != 5);
		
	}
	private static void printMenu() {
		System.out.println("---------------------");
		System.out.println("1.전화번호 추가");
		System.out.println("2.전화번호 수정");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.전화번호 조회");
		System.out.println("5.종료");
		System.out.println("---------------------");
		System.out.println("메뉴 입력 : ");
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertNum();
			break;
		case 2:
			updateNum();
			break;
		case 3:
			deleteNum();
			break;
		case 4:
			searchNum();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴를 입력하세요.");
		}
	}
	private static void insertNum() {
		// TODO Auto-generated method stub
		
	}
	private static void updateNum() {
		// TODO Auto-generated method stub
		
	}
	private static void deleteNum() {
		// TODO Auto-generated method stub
		
	}
	private static void searchNum() {
		// TODO Auto-generated method stub
		
	}

	
}
