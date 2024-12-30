package day01;

public class Ex06_VariableString {

	public static void main(String[] args) {
		String str1 = "Hello world!";
		
		String str2 = "";
		
		String str3 = "A";
		
		String str4 = null;
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4); //null이라는 문자열이 출력된 것이 아님. 비어있다는 null이 출력됐을 뿐 실제로 str4에 null이 저장된 것 아님.
		
		
		char ch1 = '1';
		char operator = '+';
		char ch2 = '2';
		
		System.out.println(ch1 + operator + ch2 + "");
		
		System.out.println("" + ch1 + operator + ch2);
		
	}

}
