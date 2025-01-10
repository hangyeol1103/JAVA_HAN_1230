package day09;

public class Ex11_TryCatch {

	public static void main(String[] args) {
		//대표적인 RuntimeException클래스의 자식 클래스들
		
		try {
			//System.out.println(1/0);
			int [] arr = new int[10];
			arr[10] = 10;
			
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(RuntimeException e) {
			System.out.println("실행 예외가 발생했습니다.");
		}catch(Exception e){
			System.out.println("예외가 발생했습니다.");
		}
		System.out.println("프로그램을 종료합니다.");
		System.out.println("----------");
		print();
	}

	public static void print() {
		try {
			System.out.println(1/0);
		}catch(Exception e) {
			System.out.println("예외 발생");		//return 입력 시에 finally가 없으면 메소드 종료는 출력이 안됨
			return;								
		}finally { //return 입력 시에 return을 보고 바로 메소드 탈출하는 것이 아닌 밑에 finally가 있다면 finally까지 실행을 하고 메소드를 탈출 함.
			System.out.println("메소드 종료");
		}
	}
	
}
