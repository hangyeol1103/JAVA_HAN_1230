package homework.ex2;

import java.util.Scanner;

public class StudentMain {

	static Scanner scan = new Scanner(System.in);
	
	/* 학생 성적 관리 프로그램을 작성하세요.
	 * 1. 학생 등록
	 * 	- 학년, 반, 번호, 이름을 입력받아 등록
	 * 	- 이미 등록된 학생 정보(학년, 반, 번호가 같은 경우)라면 등록하지 않음
	 * 2. 학생 수정
	 * 	- 학년, 반, 번호를 입력받아 학생이 있는지 찾고, 있으면 수정
	 * 	- 수정하는 정보는 학년, 반, 번호 이름을 수정
	 * 	- 이미 등록된 학생 정보로 수정하려고 하면 수정하지 않음 
	 * 3. 학생 삭제
	 * 	- 학년, 반, 번호를 입력받아 학생이 있는지 찾고 있으면 삭제
	 * 4. 과목 등록
	 * 	- 학년, 학기, 과목명을 입력받아 없으면 등록
	 * 5. 과목 수정
	 * 	- 학년, 학기, 과목명을 입력받아 있으면 학년, 학기, 과목을 입력받아 수정
	 * 	- 수정하려는 과목이 이미 등록된 과목이라면 수정하지 않음
	 * 6. 과목 삭제
	 * 	- 학년, 학기, 과목을 입력받아 있으면 삭제
	 * 7. 성적 등록
	 * 	- 학년, 반, 번호를 입력받아 학생을 찾음
	 * 	- 있으면 과목을 출력
	 * 	- 과목을 선택
	 * 	- 성적을 입력해서 학생 성적을 등록
	 * 8. 성적 수정
	 * 	- 학년, 반, 번호를 입력받아 학생을 찾음
	 * 	- 있으면 학년, 학기, 과목명을 입력받고 있으면 성적을 입력받아 수정
	 * 9. 성적 삭제
	 * 	- 학년, 반, 번호를 입력받아 학생을 찾음
	 * 	- 있으면 학년, 학기, 과목명을 입력받고 있으면 삭제
	 * 10. 학생 조회
	 * 	- 학년, 반을 입력하면 학생들을 조회
	 * 11. 과목 조회
	 * 	- 등록된 과목 전체를 조회
	 * 12. 성적 조회
	 * 	- 학년, 반, 번호를 입력하면 학생 있으면 학생 성적을 조회
	 * */
	public static void main(String[] args) {
		
		Student [] stdList;
		Subject [] subjectList; //등록된 과목들
		int stdCount = 0;
		int subjectCount = 0;
		Student tmp = new Student();
		System.out.println(tmp);
		
		
		
		int menu = 0;
		
		do {
			//메뉴 출력
			printMenu();
			//메뉴 입력
			menu = scan.nextInt();
			//
			
			
		}while(menu !=13);
		
		
		
		
	}
	
	static public void printMenu() {
		System.out.println("-------------------");
		System.out.println("1.학생 등록");
		System.out.println("2.학생 수정");
		System.out.println("3.학생 삭제");
		System.out.println("4.과목 등록");
		System.out.println("5.과목 수정");
		System.out.println("6.과목 삭제");
		System.out.println("7.성적 등록");
		System.out.println("8.성적 수정");
		System.out.println("9.성적 삭제");
		System.out.println("10.학생 조회");
		System.out.println("11.과목 조회");
		System.out.println("12.성적 조회");
		System.out.println("-------------------");
		System.out.println("메뉴 입력 : ");
		System.out.println("-------------------");
	}

}
