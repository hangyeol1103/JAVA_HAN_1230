package day05;

public class Ex05_static2 {

	public static void main(String[] args) {
		System.out.println(sum1(1,2));
		
		Ex05_static2 s = new Ex05_static2(); //이 과정이 없다면 sum2를 print하는 과정에서 오류가 생김.
		System.out.println(s.sum2(1,2));
		
		Ex01_Day04_Homework.main(args); //Ex01_Day04_Homework의 예제를 형식에 맞게 입력하면 여기서 동작 가능.
		
	}
	public static int sum1(int num1, int num2) {
		return num1 + num2;
	}
	
	public int sum2(int num1, int num2) {
		return num1 + num2;
	}
	
}

class StaticTest{
	
	int a;
	static int sa;
	
	public void printA() { //static이 안붙으면 객체 메소드
		a = 10;
		sa = 10;
	}
	
	public static void printSa() { //static이 붙으면 클래스 메소드, 정적 메소드
		//a = 10; 객체 변수는 정적 메소드에서 사용할 수 없음
		StaticTest st = new StaticTest();
		st.a = 10;//객체 변수 사용을 위해 객체를 생성한 후 사용하면 가능
		sa = 10;
	}
	
	public void test() {
		printA();
		printSa();
	}
	public static void staticTest() {
		//printA();//객체 메소드는 정적 메소드에서 사용할 수 없음.
		StaticTest st = new StaticTest();
		st.printA();//객체 메소드를 사용하기 위해 객체를 생성한 후 사용하면 가능
		printSa();
	}
	
}