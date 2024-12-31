package day02;

public class Ex04_IfEvenNumber {

	public static void main(String[] args) {
		/* if문을 이용한 홀짝 판별 예제
		 * */
		int num = 53;
		
		/* num가 짝수라면 짝수라고 출력
		 * */
		
		/* 
		 * if (num가 짝수이다) {
		 * 	  짝수라고 출력;        //모르겠다면 이런식으로라도 해보자. ~라면 앞은 조건문 그 뒤는 실행문 
		 * }
		 * */
		
		if (num % 2 == 0)
		{
			System.out.println("짝수");
		}
		
		
		/* num가 홀수라면 홀수라고 출력
		 * */
		
		if (num % 2 != 0) {
			System.out.println("홀수");
		}
		
		
	}

}
