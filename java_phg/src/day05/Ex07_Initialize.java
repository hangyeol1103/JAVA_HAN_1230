package day05;

public class Ex07_Initialize {

	public static void main(String[] args) {
		Point p = new Point();
		System.out.println(p.x1 + ", " + p.y1);
		System.out.println(p.x2 + ", " + p.y2);
		System.out.println(p.x3 + ", " + p.y3);
		System.out.println(p.x4 + ", " + p.y4);
		
	}

}

class Point{
	/* 1. 각 타입의 기본 값으로 초기화. 0 
	 * 2. 명시적 초기화
	 * 3. 초기화 블록
	 * 4. 생성자
	 * */
	int x1, y1; //1.
	int x2 = 1, y2 = 1; //2. 명시적 초기화는 <자료형 변수 = 값>의 형태
	int x3 = 1, y3 = 1; //3.
	int x4 = 1, y4 = 1; //4.
	//객체 변수 초기화 블록
	{
		x3 = 2;
		y3 = 2;
		x4 = 2;
		y4 = 2;
	}// 3.
	//클래스 변수 초기화 블록
	static {
		
	}// 3.
	public Point() { //4.
		y4 = 3;
		x4 = 3;
	}
}