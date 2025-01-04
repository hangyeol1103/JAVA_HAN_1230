package day04;

import java.util.Random;
import java.util.Scanner;

public class Ex10_Homework {

	public static void main(String[] args) {
		/* 다음과 같이 실행되도록 프로그램을 작성하세요. (Updown 게임 참고)
		 * 
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인 //몇번 만에 맞췄는지 최고기록 하나만 저장
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * 게임을 실행한 적이 없습니다.
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 1
		 * 입력 : 50
		 * Down!
		 * 입력 : 25
		 * 정답!
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인 
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * 2회
		 * 메뉴로 가려면 엔터를 입력하세요.
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인 
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 3
		 * 프로그램을 종료합니다.
		 * */
		
		//메뉴가 반복되게 작성 => 3번을
		char menu;
		Scanner scan = new Scanner(System.in);
		int min = 1, max = 100;
		int r = (int)(Math.random() * (max - min + 1) + min);
		int enter = 0;
		
		do {
			
			System.out.println("-----------------");
			System.out.println("메뉴");
			System.out.println("1. Updown 게임 실행");
			System.out.println("2. 최고 기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.println("-----------------");
			System.out.print("메뉴 선택 : ");
			
			menu = scan.next().charAt(0);
			switch(menu) 
			{
				case '1':
					for ( ; ; ) 
					{
						System.out.print("숫자를 입력하세요 : ");
						enter = scan.nextInt();
						if(r < enter) 
						{
							System.out.println("DOWN!");
						}
						else if( r > enter) 
						{
							System.out.println("UP!");
						}
						else if( r == enter)
						{
							System.out.println("정답!");
							break;
						}
					}
					break;
				case '2':
					int TopNumber = 1, count = 0;
					TopNumber = enter;
					if (enter == (enter = scan.next().charAt(0)))
					{
						count++;
						System.out.println(TopNumber + "회");
						System.out.println("메뉴로 가려면 엔터를 입력하세요 : ");
						enter = scan.next().charAt(0);
						System.out.println();
					}else if(enter != (enter = scan.next().charAt(0))) {
						System.out.println("게임을 실행한 적 없습니다.");
					}else
					{
						break;
					}
					break;
				case '3':
					System.out.println("프로그램을 종료합니다.");
					break;
				default:
					System.out.println("잘못된 메뉴입니다.");
			}
			
			
		}while(menu != '3');
	
		
	}

}
