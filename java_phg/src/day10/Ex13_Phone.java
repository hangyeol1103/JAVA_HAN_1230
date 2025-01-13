package day10;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex13_Phone {

	/* 전화번호를 관리하는 프로그램을 작성하세요.
	 * 1. 전화번호 추가
	 *  - 이름과 전화번호를 입력받아 추가
	 *  - 동명이인이 있을 수 있기 때문에 중복되도 추가
	 * 2. 전화번호 수정
	 *  - 이름을 입력
	 *  - 이름과 일치하는 목록을 출력
	 *  - 수정하려는 전화번호를 선택 -> 1. 이름 , 전화번호가 출력되는 형태 2. ~
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
	static HashMap<String, String> list = new HashMap<String, String>();
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
		System.out.println("이름 : ");
		String name = scan.nextLine();
		
		System.out.println("전화번호 : ");
		String phoneNumber = scan.nextLine();
		
		list.put(name,phoneNumber);
		System.out.println(list);
	}
	private static void updateNum() {
		// TODO Auto-generated method stub
		
	}
	private static void deleteNum() {
		// TODO Auto-generated method stub
		
	}
	private static void searchNum() {
		System.out.println("이름 : ");
		String name = scan.nextLine();
		
		if(list.get(name) == name) {
			System.out.println(list);
		}else {
			System.out.println("등록되지 않은 이름입니다.");
		}
	}

}

@Data
@AllArgsConstructor
class Num {
	private String name, phoneNumber;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Num other = (Num) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name + " : " + phoneNumber;
	}
	
}
