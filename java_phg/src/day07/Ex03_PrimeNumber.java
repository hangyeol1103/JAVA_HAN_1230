package day07;

public class Ex03_PrimeNumber {

	public static void main(String[] args) {
		
		/* 정수 num가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 
		 * */
		int num = 10;
		int i;
		
		for(i = 2; i < num; i++) {
			//i가 num의 약수이면 반복문 종료
			if(num % i == 0) {
				break;
			}
		}
		//소수일 때 i는 num, 소수가 아닐때는 i는 num보다 작음
		if(i == num) {
			System.out.println(num + "은 소수");
		}else {
			System.out.println(num + "은 소수가 아님");
		}
		
		if(isPrimeNumber(num)) {
			System.out.println(num + "은 소수");
		}else {
			System.out.println(num + "은 소수가 아님");
		}
		
		/* 100이하의 소수를 판별하기 위해 배열을 활용해서 작성하세요.
		 * */
		//i가 소수이면 i번지에 true를 i가 소수가 아니면 i번지에 false를 저장하는 배열
		boolean primeArray [] = new boolean[101]; //배열 선언시 기본 디폴트 값은 false로 선언 되었기에 else가 필요로 하지 않음.
		for(i = 1; i<= 100; i++) {
			//i가 소수이면 true를 i번지에 저장
			if(isPrimeNumber(i)) {
				primeArray[i] = true;
			}
			//아니면 false를 i번지에 저장
			else {
				primeArray[i] = false;
			}
			primeArray[i] = isPrimeNumber(i);
		}
		//primeArray를 이용하여 소수들만 출력하는 코드를 작성하세요.
		for(i = 1; i<=100; i++) {
			if(primeArray[i]) {
				System.out.print(i + " ");
			}
		}
		
	}
	//소수인지 아닌지를 '알려주는' 메소드이기에 boolean //'출력하는'이면 void로 선언.
	public static boolean isPrimeNumber(int num) {
		for(int i = 2; i < num; i++) {
			//i가 num의 약수이면 반복문 종료
			if(num % i == 0) {
				return false;
			}
		}
		return num == 1 ? false : true;
	}

}
