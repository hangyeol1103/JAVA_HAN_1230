package day06;

public class Ex01_Swap {

	public static void main(String[] args) {
		/* 두 정수의 값을 바꾸는 코드를 작성하세요.*/
		int num1 = 10, num2 = 20;
		//int num3;
		//num1에 20이, num2에 10이 저장되도록 코드를 작성하고, 출력해서 확인
		
		//num3 = num1;
		//num1 = num2;
		//num2 = num3;
		
		System.out.println("num1 : " + num1 + ", " + "num2 : " + num2);
		
		int tmp =num1;
		num1 = num2;
		num2 = tmp;
		
		System.out.println("num1 : " + num1 + ", " + "num2 : " + num2);
	}

}
