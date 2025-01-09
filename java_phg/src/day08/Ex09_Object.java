package day08;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

public class Ex09_Object {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Point p = new Point();
		
		/* println은 매개변수가 클래스의 객체이면 객체의 toString을 호출해서 출력
		 * => 모든 클래스는 Object 클래스를 상속 받고 => Object 클래스에서 물려받은 toString을
		 *    가지고 있기 때문에
		 * */
		System.out.println(p);
		System.out.println(p.toString());
		
		Student std1 = new Student(1, 1, 1, "홍길동", "국어", 100);
		Student std2 = new Student(1, 1, 2, "홍길동", "국어", 100);
		Student std3 = new Student(1, 1, 1, "임꺽정", "국어", 90);
		
		System.out.println(std1.equals(std2));
		System.out.println(std1.equals(std3)); //equals를 학년 반 번호 과목이 같을 때 같다고 정의를 했기 때문에 true
		
		//Student std4 = std1; //이 코드는 복사가 아닌 공유하는 것임. 그래서 항상 new 생성자로 새로운 객체를 만들어서 이용했음.
		Student std4 = (Student)std1.clone();
		std1.score = 90;
		System.out.println(std4);
	}
	
	public void println(Object object) {
		System.out.println(object.toString());
	}
}
class Point{
	private int x, y;

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}

@AllArgsConstructor //필요한 모든 멤버변수에 대한 생성자를 만드는 명령어
@ToString
class Student implements Cloneable{
	
	int grade, classNum, num;
	String name, subject;
	int score;
	
	@Override
	public boolean equals(Object obj) { 
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num
				&& Objects.equals(subject, other.subject); //과제때도 equals를 이용하면 편할 것이다.
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}