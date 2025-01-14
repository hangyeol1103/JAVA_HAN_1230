package day10;

import java.util.Scanner;

public class Chulseok {

	public static void main(String[] args) {
		
		int notcom; //결석 late:지각 runout:조퇴
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("지각 횟수 : ");
		int late = scan.nextInt();
		System.out.println("조퇴 횟수 : ");
		int runout = scan.nextInt();
		
		if((late + runout) >= 3) {
			notcom = (late + runout)/3;
		}else {
			notcom = 0;
		}
		System.out.println("결석횟수는? : " + notcom);
	}

}
