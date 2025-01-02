package day03;

import java.util.Random;
import java.util.Scanner;

public class Ex14_UpDown {

	public static void main(String[] args) {
		/* 1에서 100사이의 랜덤한 수를 생성해서 맞추는 게임을 구현하세요.
		 * 예시
		 * 랜덤한 수 : 30
		 * 입력 : 50
		 * DOWN!
		 * 입력 : 10
		 * UP!
		 * 입력 : 30
		 * 정답!
		 * 
		 * 반복횟수 : 계속
		 * 규칙성 : 정수를 입력.
		 * 		  입력한 정수가 랜덤한 수보다 크면 DOWN이라고 출력하고
		 * 		  작으면 UP이라고 출력하고
		 * 		  같으면 정답이라고 출력 후 반복문 종료
		 * 반복문 종료 후 : 없음.
		 * */
		
		Scanner scan = new Scanner(System.in);
		int min = 1, max = 100;
		Random random = new Random();
		int r = random.nextInt(max - min + 1) + min;
		System.out.println("랜덤 수 : " + r); //랜덤 수의 값을 보는 방법
		for( ; ; ) {
			System.out.print("숫자를 입력하세요 : ");
			int enter = scan.nextInt();
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
					break;  //대신에 input != r 이라는 값으로 설정해도됨 for ( ; input != r; ) 이렇게
				}
		}	
	}
}
