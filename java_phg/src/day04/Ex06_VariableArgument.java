package day04;

public class Ex06_VariableArgument {

	public static void main(String[] args) {
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));
	}

	
	public static int sum(int ... nums) {
		int sum = 0;
		for(int num : nums) { //향상된 for문은 nums라는 배열의 맨 앞에서 부터 하나씩 꺼내 줌
			sum += num;
		}
		return sum;
	}
}
