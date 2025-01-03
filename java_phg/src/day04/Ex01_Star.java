package day04;

public class Ex01_Star {

	public static void main(String[] args) {
		/*     *  i=1, ,공백=4, *=1
		 * 	  **  i=2, ,공백=3, *=2
		 *   ***  i=3, ,공백=2, *=3
		 *  ****  i=4, ,공백=1, *=4
		 * *****  i=5, ,공백=0, *=5
		 * 		       공백=5-i *=i
		 * */
		
		int num = 5;
		
		for (int i = 1; i<=num; i++)
		{
			for(int j = 1;j<=5-i;j++)
			{
				System.out.print(" "); //공백을 찍고 나서 별을 찍음.
			}
			for(int j = 1; j<=i ; j++)
			{
				System.out.print('*');
			}
			System.out.println();
		}
		
		
		/*     *       i=1, ,공백=4, *=1 
		 *    ***      i=2, ,공백=3, *=3 
		 *   *****     i=3, ,공백=2, *=5
		 *  *******    i=4, ,공백=1, *=7
		 * *********   i=5, ,공백=0, *=9
		 * 					공백=5-i  *=2*i-1 //2,4,6,8,10 이면 *=2*i
		 * */
		
		for (int i = 1; i<=num; i++)
		{
			for(int j = 1;j<=5-i;j++)
			{
				System.out.print(" ");
			}
			for(int j = 1; j<=2*i-1 ; j++)
			{
				System.out.print('*');
			}
			System.out.println();
		}
		
		
		
		
		
		/*     *       i=1, *=0
		 *    ** *	   i=2, *=1
		 *   *** **	   i=3, *=2
		 *  **** ***   i=4, *=3
		 * ***** ****  i=5, *=4
		 * 			   => *=i-1
		 * */
		
		for (int i = 1; i<=num; i++)
		{
			//공백 출력
			for(int j = 1;j<=5-i;j++)
			{
				System.out.print(" "); //공백을 찍고 나서 별을 찍음.
			}
			//*출력
			for(int j = 1; j<=i ; j++)
			{
				System.out.print('*');
			}
			//엔터
			System.out.print(" ");
			//추가된 *출력
			for(int j = 1; j<=i-1 ; j++)
			{
				System.out.print('*');
			}
			//엔터
			System.out.println();
		}
		
	}

}
