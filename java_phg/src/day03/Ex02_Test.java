package day03;

import java.util.Scanner;

public class Ex02_Test {

	public static void main(String[] args) {
		/* 월을 입력받고 월의 마지막 일을 출력하는 코드를 작성하세요.
		 * 31 : 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2
		 * 잘못된 월입니다. : 1~12가 아닌 월.
		 * */
		
		Scanner scan = new Scanner(System.in);
		System.out.print("월을 입력하시오 : ");
		int month;
		month = scan.nextInt();
		
		switch(month){
		case 1,3,5,7,8,10,12:
			System.out.println(month + "의 마지막 일은 31일 입니다.");
			break;
		case 4,6,9,11:
			System.out.println(month + "의 마지막 일은 30일 입니다.");
			break;
		case 2:
			System.out.println(month + "의 마지막 일은 28일 입니다.");
			break;
			default:
				System.out.println(month + "는 잘못된 월입니다.");
				
		
		}
		
	}

}
