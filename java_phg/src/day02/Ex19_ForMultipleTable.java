package day02;

public class Ex19_ForMultipleTable {

	public static void main(String[] args) {
		/* 2단을 출력하는 코드를 작성하세요.
		 * 2 X 1 = 2
		 * 2 X 2 = 4
		 * ...
		 * 2 X 9 = 18
		 * 반복횟수: i가 1부터 9까지 1씩 증가하는 형태
		 * 규칙성: 2 * i 형태의 규칙으로 곱해져야 함.
		 * 반복문 종료 후: 없음
		 * */
		int i;
		int num = 2;
		
		for(i=1; i<=9;i++) {
			System.out.println(num + " X " + i + " = " + num*i);
		}
	
	}

}
