package day01;

public class Ex03_VariableNumber {

	public static void main(String[] args) {
		byte num1 = 1;
		//num1 = 12345; // -127 ~ 127 사이이기에 byte가 저장할 수 있는 범위를 넘었기에 에러가 발생함.
		System.out.println(num1);
		int num2 = 123456789;
		//num2 = 123456789012; //int도 byte와 마찬가지로 int가 저장할 수 있는 범위를 넘어가면 에러가 발생함.
		System.out.println(num2);
		long num3 = 123456789012L; //접미사 L(l)을 안붙히면 기본int형이지만 int에는 담지 못하기 때문에 L(l) 붙여야됨.
		System.out.println(num3);
		
		float num4 = 3.14F; //그냥 3.14는 double형이기 때문에 float에 저장할 수 없음. 따라서 접미서 F(f) 써야함.
		//소수점 9자리까지 확인.
		System.out.printf("%.9f\n",num4);
		
		double num5 = 3.14;
		//소수점 20자리까지 확인.
		System.out.printf("%.20f.\n",num5);
		
		//10진수 표현이 아닌 값을 정수에 저장하는 예제
		int num6 = 0x10; //0x붙는 것은 16\진수 => 16진수 10 = 16임
		System.out.println(num6);
		
		int num7 = 010; // 8진수 10 = 8
		System.out.println(num7);
		
		int num8 = 0b10; // 2진수 10 = 2
		System.out.println(num8);
		
		int num9 = 'A'; //'A'의 해당하는 저장값(0041)이 저장 => 65
		System.out.println(num9);
		
		double num10 = 1e3; //1*10^3 => 1000
		System.out.println(num10);
	}

}
