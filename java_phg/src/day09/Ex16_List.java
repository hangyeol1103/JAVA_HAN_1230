package day09;

import java.util.ArrayList;
import java.util.Iterator;

import lombok.EqualsAndHashCode;
import lombok.ToString;

public class Ex16_List {

	public static void main(String[] args) {
		
		/* List : 인터페이스
		 * ArrayList, LinkedList, Vector : List를 구현한 구현 클래스
		 * List 특징
		 * 	- 순서 보장, 중복을 허용
		 * */
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(20);
		System.out.println(list);
		
		list.set(1, 20); //값을 20으로 변경
		
		System.out.println(list);
		
		list.remove((Integer)20); //20이 두개가 있다면 앞에꺼부터 지움.
		//Integer을 붙힌 이유는 collection 프레임워크에서 지원하는 remove(int)와 
		//list에서 지원하는 remove(integer)가 차이가 있어서
		
		System.out.println(list);
		
		System.out.println("현재 저장된 개수 : " + list.size());
		
		ArrayList<Point> list2 = new ArrayList<Point>();
		
		list2.add(new Point(1,1));
		list2.add(new Point(10,10));
		
		System.out.println(list2);
		
		/* boolean remove(Object o)
		 * - 이 remove는 같다를 Objects.equals를 이용하여 판단
		 * - Objects.equals(Object o1, Object o2)
		 * - o1과 o2가 다른 클래스이면 false를 리턴
		 * - o1과 o2가 같은 클래스이면 o1.equals를 이용하여 비교
		 * * */
		
		list2.remove(new Point(1,1));
		System.out.println(list2);
		list2.add(new Point(10,10));
		list2.add(new Point(-1,-1));
		System.out.println(list2);
		
		//Iterator를 이용한 반복문 예제
		Iterator<Point> it = list2.iterator();
		System.out.println("---------------");
		while(it.hasNext()) {
			Point tmp = it.next();
			System.out.println(tmp);
		}
		
		//indexOf(객체) : 객체가 몇번지에 있는지 알려줌
		//Objects.equals를 이용하여 같은 객체를 찾아서 번지를. 과제 시 -> 반환 Point클래스 정상적으로 오버라이딩 해야 원하는 결과 나옴.
		int index = list2.indexOf(new Point(10,10));
		System.out.println(index);
		
		boolean res = list2.contains(new Point(1,3));
		System.out.println(res);
		
		System.out.println("---------------");
		//1번지에 있는 좌표 정보를 가져와서 2,3으로 수정하는 작업
		Point p = list2.get(1);
		p.x=2;
		p.y=3;
		System.out.println(list2);
		
	}

}

@ToString
@EqualsAndHashCode //기본적으로 모든 값을 비교함.	
class Point{
	int x,y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
