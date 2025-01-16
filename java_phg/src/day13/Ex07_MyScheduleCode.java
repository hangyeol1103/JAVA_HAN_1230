package day13;

import java.util.ArrayList;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex07_MyScheduleCode {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<Schedule> list = new ArrayList<Schedule>();
	public static void main(String[] args) {
		
		/* 다음 기능을 실행하는 프로그램을 작성하세요.
		 * 
		 * 1. 스케쥴 등록
		 *  - 날짜, 시작시간, 할일을 입력하여 등록
		 * 2. 스케쥴 수정
		 *  - 날짜를 입력
		 *  - 해당 날짜에 등록된 스케쥴을 출력
		 *  - 수정할 스케쥴을 선택
		 *  - 날짜, 시작시간, 할일을 입력하여 수정
		 * 3. 스케쥴 삭제
		 *  - 날짜를 입력
		 *  - 해당 날짜에 등록된 스케쥴을 출력
		 *  - 삭제할 스케쥴을 선택하여 삭제
		 * 4. 스케쥴 조회
		 *  - 월 조회
		 *  	- 년과 월을 입력받아 스케쥴을 조회
		 *  - 일 조회
		 *  	- 년, 월, 일을 입력받아 스케쥴을 조회
		 * */
		
		int menu;
		
		do {
			printMenu();
			
			menu = scan.nextInt();
			scan.nextLine();
			
			runMenu(menu);
			
		}while(menu != 5);
	}
	private static void printMenu() {
		System.out.println("===================");
		System.out.println("1.스케쥴 등록 : ");
		System.out.println("2.스케쥴 수정 : ");
		System.out.println("3.스케쥴 삭제 : ");
		System.out.println("4.스케쥴 조회 : ");
		System.out.println("5.종료");
		System.out.println("===================");
		System.out.print("메뉴 선택 : ");
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertSchedule();
			break;
		case 2:
			updateSchedule();
			break;
		case 3:
			deleteSchedule();
			break;
		case 4:
			searchSchedule();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴를 선택하세요.");
		}
	}
	private static void insertSchedule() {
		System.out.println("년 : ");
		int year = scan.nextInt();
		System.out.println("월 : ");
		int month = scan.nextInt();
		System.out.println("일 : ");
		int day = scan.nextInt();
		
		System.out.println("시작시간 : ");
		String startTime = scan.nextLine();
		
		System.out.println("할 일 : ");
		String toDo = scan.nextLine();
		
		Schedule sde = new Scheduled(year, month ,day, startTime, toDo);
		list.add(sde);
		System.out.println(list);
		
	}
	private static void updateSchedule() {
		// TODO Auto-generated method stub
		
	}
	private static void deleteSchedule() {
		// TODO Auto-generated method stub
		
	}
	private static void searchSchedule(int r) {
		switch(r) {
		case 1:
			System.out.println("1.월 조회");
			searchMonth();
			break;
		case 2:
			System.out.println("2.일 조회");
			searchDay();
			break;
		default:
			System.out.println("잘못된 조회입니다.");
		}
	}
	private static void searchMonth() {
		System.out.println("년도 : ");
		int year = scan.nextInt();
				
		System.out.println("월 : ");
		int month = scan.nextInt();
		
		for(Schedule sde : list) {
			if(sde.getYear() && sde.getMonth()) {
				System.out.println(sde);
			}
		}
	}
	private static void searchDay() {
		// TODO Auto-generated method stub
		
	}
}

@Data
@AllArgsConstructor
class Scheduled {
	int year, month, day;
	String startTime;
	String toDo;
	
	
	@Override
	public String toString() {
		return year + "년 " + month + "일 " + day + "일 "+ "시작시간: " + startTime + "할 일:" + toDo;
	}
	
	
}
