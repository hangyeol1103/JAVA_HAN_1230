package day02;

public class Ex13_SwitchSeason {

	public static void main(String[] args) {
		/* 월이 주어졌을 때 월에 맞는 계절을 출력하세요.
		 * 봄: 3,4,5
		 * 여름: 6,7,8
		 * 가을: 9,10,11
		 * 겨울: 12,1,2
		 * 잘못된 월: 그 외
		 * */
		
		int month = 0;
		
		switch(month) {
		case 3,4,5:
			System.out.println(month + "는 봄입니다.");
			break;
		case 6,7,8:
			System.out.println(month + "는 여름입니다.");
			break;
		case 9,10,11:
			System.out.println(month + "는 가을입니다.");
			break;
		case 12,1,2:
			System.out.println(month + "는 겨울입니다.");
			break;
		default:
			System.out.println(month + "는 잘못된 월입니다.");
		}
		
	}

}
