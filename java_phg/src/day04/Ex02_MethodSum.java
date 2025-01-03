package day04;

public class Ex02_MethodSum {

	public static void main(String[] args) {
		int num1 = 1, num2 =2;
		int sum = sum(1,2);
		System.out.println(sum); //리턴값을 저장해서 활용
		System.out.println(sum(1,2)); //바로 활용하는 것. 리턴값이 있을 때 가능
		System.out.println(sum(num1, num2));
	}

	
	/* 기능 : 두 정수가 주어지면 두 정수의 합을 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 두 정수의 합 => 정수 => int
	 * 메소드명 : sum 
	 * */
	public static int sum(int num1, int num2) {
		int sum = num1 + num2;
		return sum;
	}
	
	
}
