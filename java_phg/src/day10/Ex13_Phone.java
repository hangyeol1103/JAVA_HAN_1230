package day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
	static ArrayList<PhoneNumber> list = new ArrayList<PhoneNumber>();
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
		System.out.print("메뉴 입력 : ");
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
		//이름과 전화번호를 입력받아 추가
		System.out.println("이름 : ");
		String name = scan.nextLine();
		System.out.println("전화번호(예:010-1234-5678) : ");
		String phoneNumber = scan.nextLine();
		
		//정규표현식 체크 : 000-0000-0000
		String regex = "^\\d{2,3}(-\\d{4}){2}$";
		if(!Pattern.matches(regex, phoneNumber)) {
			System.out.println("올바른 전화번호가 아닙니다.");
			return;
		}
		
		PhoneNumber pn = new PhoneNumber(name,phoneNumber);
		list.add(pn);
		System.out.println("전화번호를 등록했습니다.");
	}
	private static void updateNum() {
		//이름을 입력 받음
		System.out.print("이름 : ");	
		String name = scan.nextLine();
		//이름과 일치하는 전화번호 목록을 숫자와 함께 출력
		//이름과 일치하는 전화번호 리스트를 가져옴
		ArrayList<PhoneNumber> tmpList = searchPhoneNumberList(name); 
		//tmpList는 list의 일부이며 객체는 서로 공유하되, 공유하는 목록이 서로 다른 것.
		
		if(!printPhoneNumberList(tmpList, true)) {
			return;
		}
		
		/*//새로 만든 리스트를 이용하여 출력
		for (int i = 0; i<tmpList.size(); i++) { //1. ~
			System.out.println(i+1 + ". " + tmpList.get(i));
		}*/
		
		//수정할 번호를 입력
		System.out.println("수정할 번호 선택 : ");
		int index = scan.nextInt() - 1; //번지로 접근하기 위해 뒤에 -1을 하는 것.
		scan.nextLine();
		//선택한 전화번호를 삭제
		//선택한 번호-1번지에 있는 객체를 새로운 리스트에서 가져옴
		PhoneNumber pn = tmpList.get(index);
		
		//새 이름과 번호를 입력
		System.out.println("이름 : ");
		String newName = scan.nextLine();
		System.out.println("전화번호(예:010-1234-5678) : ");
		String phoneNumber = scan.nextLine();
		
		pn.update(newName, phoneNumber);
		System.out.println("수정이 완료됐습니다.");
		
	}
	
	private static void deleteNum() {
		//이름을 입력 받음
		System.out.print("이름 : ");
		String name = scan.nextLine();
		//이름과 일치하는 전화번호 목록을 숫자와 함께 출력
		//이름과 일치하는 전화번호 리스트를 가져옴
		ArrayList<PhoneNumber> tmpList = searchPhoneNumberList(name); //tmpList는 list의 일부이며 객체는 서로 공유하되, 공유하는 목록이 서로 다른 것.
		
		if(!printPhoneNumberList(tmpList, true)) {
			return;
		}
		/*//새로 만든 리스트를 이용하여 출력
		for (int i = 0; i<tmpList.size(); i++) { //1. ~
			System.out.println(i+1 + ". " + tmpList.get(i));
		}*/
		
		//삭제할 번호를 입력
		System.out.println("삭제할 번호 선택 : ");
		int index = scan.nextInt() - 1; //번지로 접근하기 위해 뒤에 -1을 하는 것.
		//선택한 전화번호를 삭제
		//선택한 번호-1번지에 있는 객체를 새로운 리스트에서 가져옴
		PhoneNumber pn = tmpList.get(index);
		//가져온 객체를 기존 리스트에서 제거
		list.remove(pn);//Objects.equals() => Object.equals
		System.out.println("전화번호가 삭제 되었습니다.");
	}
	private static ArrayList<PhoneNumber> searchPhoneNumberList(String name) {
		
		ArrayList<PhoneNumber> tmpList = new ArrayList<PhoneNumber>();
		
		for(PhoneNumber pn : list) {
			if(pn.getName().contains(name)) {
				tmpList.add(pn);
			}
		}
		return tmpList;
	}
	private static void searchNum() {
		System.out.println("이름 : ");
		String name = scan.nextLine();
		
		ArrayList<PhoneNumber> pList = searchPhoneNumberList(name);
		printPhoneNumberList(pList, false);
		/*for(PhoneNumber pn : list) {
			if(pn.getName().contains(name)) {
				System.out.println(pn);
			}
		}*/
	}
	private static boolean printPhoneNumberList(ArrayList<PhoneNumber> pList, boolean isNumber) {
		if(pList == null || pList.size() == 0) {
			System.out.println("결과가 없습니다.");
			return false;
		}
		for(int i = 0; i<pList.size(); i++) {
			if(isNumber) {
				System.out.print(i+1+". ");
			}
			System.out.println(pList.get(i));
		}
		return true;
	}

}
@Getter
@Setter
@Data
@AllArgsConstructor //모든 멤버변수를 필요로하는 생성자를 생성함? AllArgsConstructor 쓰는 경우 멤버변수 순서 중요
class PhoneNumber {
	private String name;
	private String phoneNumber;
//equals 오버라이드를 하는 이유 => list에있는 contains나 indexOf를 equals를 필요로하기 때문에 필요로 했지만
//이건 중복을 허용하기 때문에 필요 없다.

	@Override
	public String toString() {
		return name + " : " + phoneNumber;
	}
	public void update(String newName, String phoneNumber) {
		this.name = newName;
		this.phoneNumber = phoneNumber;
	}	
	
}
