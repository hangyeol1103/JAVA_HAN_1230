package day18;

public enum Bank { //열거형
	신한, 국민, 우리;
	
	public static void printBanks() {
		Bank [] list = Bank.values(); //열거형.values 하면 해당하는 열거형에 있는 값들을 객체로 각각 반환해줌. 그럼 3개짜리 객체가 나옴.
		
		for(int i = 0; i<list.length; i++) {
			System.out.print((i == 0 ? "" : ",") +list[i]);
		}
		System.out.println();
	}
	
	public static boolean check(String str) { //입력된 문자열이 bank로 바꿀 수 있는지 없는지 체크하는 메소드
		try {
			return Bank.valueOf(str) != null;
		}catch (Exception e) {
			return false;
		}
	}
}
