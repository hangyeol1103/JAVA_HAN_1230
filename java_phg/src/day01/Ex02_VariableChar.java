package day01;

public class Ex02_VariableChar {

	public static void main(String[] args) {
		
		char ch1; //문자 변수 ch1을 선언. 사용 X
		//The local variable ch1 may not have been initialized : 내가 변수를 초기화 하지 않았을 때 발생하는 오류
		//System.out.println(ch1); //에러 발생.
		ch1 = '1'; //저장 O 그리고 0~9까지는 지정되어 있지만 11은 안됨. 문자 2개로 판단됨. ' ' 안에는 한글자만 쓸 수 있음.
		System.out.println(ch1); //에러 발생하지 않음. 저장해서 초기화가 됨
		
		char ch2 = '한'; //선언과 동시에 초기화 했기에 사용 O
		System.out.println(ch2);
		
		char ch3 = '\u0041';
		System.out.println(ch3); //유니코드 0041에 해당하는 A가 출력함.
		
		char ch4 = '\\', ch5 = '\n', ch6 = '\"';
		System.out.println(ch4); // 역슬래쉬 출력됨.
		System.out.println(ch5); // Enter임.
		System.out.println(ch6); // " 출력됨. 
		
		// shift + Enter은 커서에 상관없이 다음줄 이동. alt 화살표 위아래는 코드 이동 => 더 빠른 코딩을 위해.
		
		
	}

}
