package day06;

public class Ex04_ArrayCopy2 {

	public static void main(String[] args) {
		//깊은 복사와 얕은 복사를 비교하는 예제
		Point [] points = new Point[5]; //클래스로 만든 배열은 기본값이 null로 초기화 됨.
		for(int i = 0; i<points.length; i++) {
			points[i] = new Point(i,i);
		}
		
		print(points);
		
		//System.arraycopy의 얕은 복사를 보여주는 예제
		Point [] points2 = new Point[points.length];
		System.arraycopy(points, 0, points2, 0, points.length);
		
		System.out.println("----------------------------");
		points[0] = new Point(10, 10);
		points[0].x = 100;
		print(points2);
		
		//반복문을 이용하여 깊은 복사를 보여주는 예제
		Point [] points3 = new Point[points2.length];
		for(int i = 0; i<points2.length; i++) {
			points3[i] = new Point(points2[i]); //깊은 복사는 값이 바뀌지 않고 얕은 복사는 값이 바뀜.
		}
		points2[0].x = 100;
		
		System.out.println("----------------------------");
		print(points3);
		
	}
	public static void print(Point[] points) {
		for(int i =0; i<points.length; i++) {
			points[i].print();
		}
	}

}

class Point{
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this(p.x, p.y);
		//x = p.x;
		//y = p.y; 이거 두줄을 this(p.x, p.y);로 표현가능. 
	}
	
	public void print() {
		System.out.println("(" + x + "," + y + ")");
	}
}