package day03;

public class Ex07_ForSum {

	public static void main(String[] args) {
		/* 1부터 10까지의 합을 구하는 코드를 작성하세요.
		 * 		sum = 0
		 * i=1 	sum = 0 + 1
		 * i=2 	sum = 0 + 1 + 2
		 * i=3 	sum = 0 + 1 + 2 + 3
		 * ...
		 * i=10 sum + 0 + 1 + 2 + 3 + ... + 10
		 * 반복횟수 :
		 * 규칙성 :
		 * 반복문 종료 후 :
		 * */
		int sum = 0;
		int num = 10;
		
		for(int i=1; i<=num; i++)
		{
			sum += i;
		}
		System.out.println("1부터 " + num + "까지의 합 :" + sum);
		
		
		/* 1부터 10까지의 짝수의 합 */
		sum = 0;
		for(int i=0; i<=num; i+=2)
		{
			sum += i;
		}
		System.out.println("1부터 " + num + "까지 짝수의 합 :" + sum);
		
	}

}
