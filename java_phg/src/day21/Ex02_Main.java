package day21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex02_Main {

	/* 단어장 프로그램을 구현하세요.
	 * - 관리자
	 *  - 단어 등록
	 *  - 단어 수정
	 *  - 단어 삭제
	 * - 사용자
	 *  - 단어 검색
	 *  - 내 검색 단어 보기
	 *  
	 *  - 주의사항
	 *   - 중복된 단어 허용
	 *   - 단어는 단어, 품사, 뜻으로 구성
	 *   - 사용자는 아이디로만 구분. 중복된 아이디는 없음
	 *   - 사용자는 회원가입을 따로 하지 않음
	 *   - 관리자는 admin으로 고정
	 *   - 저장과 불러오기 필수
	 *   
	 * 시작전
	 * 아이디 : admin
	 * 관리자 메뉴 출력
	 * 메뉴 선택 :
	 * 
	 * 아이디 : abc
	 * 사용자 메뉴 출력
	 * 메뉴 선택 :
	 * 
	 * */
	private static Scanner scan = new Scanner(System.in);
	private static List<Word> list = new ArrayList<Word>();
	
	public static void main(String[] args) {
		
		String id;
		System.out.print("아이디 : ");
		id = scan.next();
		
		switch(id) {
		case "admin":
			managerMenu();
			break;
		default:
			userMenu();
		}
		
	}

	private static void managerMenu() {
		int menu;
		do {
			managerPrintMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			managerRunMenu(menu);
		}while(menu != 4);
	}

	private static void managerPrintMenu() {
		System.out.println("1.단어 등록");
		System.out.println("2.단어 수정");
		System.out.println("3.단어 삭제");
		System.out.println("4.종료");
		System.out.print("메뉴 선택 : ");
	}

	private static void managerRunMenu(int menu) {
		switch(menu) {
		case 1:
			insertWord();
			break;
		case 2:
			updateWord();
			break;
		case 3:
			deleteWord();
			break;
		case 4:
			System.out.println("[관리자님, 성공적으로 단어 기능을 완료하였습니다.]");
			break;
		default:
			System.out.println("[올바른 메뉴를 선택하세요.]");
		}
	}

	private static void insertWord() {
		System.out.print("단어 : ");
		String word = scan.nextLine();
		
		System.out.print("품사 : ");
		String type = scan.next();
		scan.nextLine();
		
		System.out.print("뜻 : ");
		String mean = scan.nextLine();
		
		Word w = new Word(word, type, mean);
		list.add(w);
		System.out.println(w);
		
	}

	private static void updateWord() {
		String word;
		do {
			System.out.print("단어 : ");
			word = scan.nextLine();
			
			if(!list.contains(word)) {
				System.out.println("[등록되지 않은 단어 입니다.]");
			}
			
		}while(list.contains(word));
		
		System.out.print("품사 : ");
		String type = scan.next();
		scan.nextLine();
		
		System.out.print("뜻 : ");
		String mean = scan.nextLine();
		
		Word nw = new Word("",type, "");
		Word nw2 = new Word("", "", mean);
		list.set(1, nw);
		list.set(2, nw2);
		
		System.out.println(list);
		
	}

	private static void deleteWord() {
		// TODO Auto-generated method stub
		
	}

	private static void userMenu() {
		int menu;
		do {
			userPrintMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			userRunMenu(menu);
		}while(menu != 3);
		
	}

	private static void userPrintMenu() {
		System.out.println("1.단어 검색");
		System.out.println("2.내 검색 단어 보기");
		System.out.println("3.종료");
		System.out.print("메뉴 선택 : ");
	}

	private static void userRunMenu(int menu) {
		switch(menu) {
		case 1:
			searchWord();
			break;
		case 2:
			seeWord();
			break;
		case 3:
			System.out.println("[사용자님, 성공적으로 단어 검색 기능을 완료했습니다.]");
			break;
		default:
			System.out.println("[올바른 메뉴를 선택하세요.]");
		}
	}

	private static void searchWord() {
		// TODO Auto-generated method stub
		
	}

	private static void seeWord() {
		// TODO Auto-generated method stub
		
	}

}
