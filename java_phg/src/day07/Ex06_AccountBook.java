package day07;

import java.util.Scanner;

public class Ex06_AccountBook {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* 가계부에 필요한 클래스를 선언하세요.
		 * 메뉴
		 * 1. 가계부 등록
		 * 2. 가계부 수정
		 * 3. 가계부 삭제
		 * 4. 가계부 조회
		 * 5. 종료
		 * 메뉴 선택 : 1
		 * -----------------------
		 * 수입/지출 : 수입
		 * 분류 : 월급
		 * 내용 : 1월 월급
		 * 금액 : 1000000
		 * 일시 : 2025-01-08
		 * -----------------------
		 * 가계부 등록이 완료됐습니다.
		 * -----------------------
		 * 메뉴
		 * 1. 가계부 등록
		 * 2. 가계부 수정
		 * 3. 가계부 삭제
		 * 4. 가계부 조회
		 * 5. 종료
		 * 메뉴 선택 : 2
		 * -----------------------
		 * 1. 수입/월급/1월 월급/1000000/2025-01-08
		 * 수정할 내역의 번호를 선택하세요 : 1
		 * 금액 : 2000000
		 * -----------------------
		 * 수정이 완료됐습니다.
		 * -----------------------
		 * 메뉴
		 * 1. 가계부 등록
		 * 2. 가계부 수정
		 * 3. 가계부 삭제
		 * 4. 가계부 조회
		 * 5. 종료
		 * 메뉴 선택 : 4
		 * -----------------------
		 * 1. 수입/월급/1월 월급/2000000/2025-01-08
		 * -----------------------
		 * 메뉴
		 * 1. 가계부 등록
		 * 2. 가계부 수정
		 * 3. 가계부 삭제
		 * 4. 가계부 조회
		 * 5. 종료
		 * 메뉴 선택 : 3
		 * -----------------------
		 * 1. 수입/월급/1월 월급/1000000/2025-01-08
		 * 삭제할 내역의 번호를 선택하세요 : 1
		 * -----------------------
		 * 삭제가 완료됐습니다.
		 * -----------------------
		 * 메뉴
		 * 1. 가계부 등록
		 * 2. 가계부 수정
		 * 3. 가계부 삭제
		 * 4. 가계부 조회
		 * 5. 종료
		 * 메뉴 선택 : 5
		 * -----------------------
		 * 프로그램을 종료합니다.
		 * -----------------------
		 * */
		int menu, count = 0;
		Item [] list = new Item[10];
		
		list[count++] = new Item("수입", "월급", "1월 월급", 1000000, "2025-01-08");
		//배열도 위에 선언된 배열이기에 또 앞에 Item [] list = ~ 의 형태가 아닌
		//앞의 Item을 떼고 list[] = ~ 로 새로운 객체와 생성자를 불러오는 것이다.
		
		//반복 : 종료를 선택하기 전까지
		do {
			//메뉴 출력
			System.out.println("------------------");
			System.out.println("메뉴");
			System.out.println("1. 가계부 등록");
			System.out.println("2. 가계부 수정");
			System.out.println("3. 가계부 삭제");
			System.out.println("4. 가계부 조회");
			System.out.println("5. 종료");
			System.out.println("메뉴 선택 : ");
			//메뉴 선택
			menu = scan.nextInt();
			//선택한 메뉴에 따른 기능 실행
			System.out.println("------------------");
			switch(menu) {
			case 1:
				//내역 정보들을 입력
				System.out.print("수입/지출 : ");
				String income = scan.next();
				System.out.print("분류 : ");
				String type = scan.next();
				System.out.print("내용 : ");
				scan.nextLine();//next()에서 입력한 엔터를 처리
				String content = scan.nextLine();
				System.out.print("금액 : ");
				int money = scan.nextInt();
				System.out.print("일시 : ");
				String data= scan.next();
				//내역 리스트에 추가
				list[count] = new Item(income, type, content, money, data);
				count++;
				break;
			case 2:
				//내역들을 출력
				for(int i = 0; i < count; i++) {
					list[i].print(i+1);
				}
				//수정할 내역의 숫자를 입력
				System.out.println("수정할 내역의 번호를 선택하세요 : ");
				int num = scan.nextInt();
				//금액을 입력
				System.out.println(" 금액 :");
				money = scan.nextInt();
				//입력받은 숫자 -1번지에 있는 금액을 수정
				int index = 0;
				for(int i = 0; i<count; i++) {
						list[i] = list[count-1];
					}
				break;
			case 3:
				//내역들을 출력
				
				//삭제할 내역의 숫자를 입력
				
				//입력받은 숫자 번지부터 앞으로 한칸씩 당김
				
				//개수를 1감소
				
				break;
			case 4:
				//반복문을 이용하여 저장된 내역들을 숫자와 함께 출력. 숫자는 1부터 시작
				for(int i = 0; i <count; i++) {
					list[i].print(i+1);
				}
				
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("올바른 메뉴를 선택하세요.");
			}
			System.out.print("------------------");
		}while(menu != 5);
	}

}

class Item{
	
	String income;
	String type;
	String content;
	int money;
	String date;
	
	
	public void print() {
		//수입/월급/1월 월급/2000000/2025-01-08
		System.out.println(income + "/" + type + "/" + content + "/" + money + "/" + date);
	}
	
	public void print(int num) {
		System.out.println(num + ". ");
		print();
	}
	
	public void setMoney(int money) {
		this.money = money;
	}

	public Item(String income, String type, String content, int money, String date) {
		this.income = income;
		this.type = type;
		this.content = content;
		this.money = money;
		this.date = date;
	}
	
	
}
