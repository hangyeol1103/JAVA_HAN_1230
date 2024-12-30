package day01;

public class Ex12_OperatorComparison {

	public static void main(String[] args) {
		//비교 연산자 예제 : 결과가 false 아니면 true
		int num1 = 1, num2 =2;
		System.out.println(num1 + " > " + num2 + " ? " + (num1 > num2));
		System.out.println(num1 + " >= " + num2 + " ? " + (num1 >= num2));
		System.out.println(num1 + " < " + num2 + " ? " + (num1 < num2));
		System.out.println(num1 + " <= " + num2 + " ? " + (num1 <= num2));
		System.out.println(num1 + " == " + num2 + " ? " + (num1 == num2));
		System.out.println(num1 + " != " + num2 + " ? " + (num1 != num2));
		
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		System.out.println(str1 + " == " + str2 + " ? " + (str1 == str2));
		System.out.println(str1 + " == " + str3 + " ? " + (str1 == str3));
		
		System.out.println("------------------------------------------");
		
		System.out.println(str1 + " equals " + str2 + " ? " + (str1.equals(str2)));
		System.out.println(str1 + " equals " + str3 + " ? " + (str1.equals(str3)));
		//참조형은 ==가 아닌 equals로 비교하는 것이 좋음. ==는 주소끼리 비교하게 되어 서로 다른 값으로 인식함. equals는 값 자체를 봄.
		
	}

}
