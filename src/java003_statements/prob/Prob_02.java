package java003_statements.prob;
/*
 * 
 * 2001부터 2012년사이에서 윤년을 구하시오 
 * 출력결과
 2004
 2008
 2012
 */

public class Prob_02 {

	public static void main(String[] args) {
		
		int year = 2000;
		
		for(int i = 0; i < 12 ; i++) {
			year++;
			if( year%4==0 && year %100 != 0 || year % 400 == 0) {
				System.out.printf("%d년은 윤년입니다.\n",year);
			}
		}
		
       
	}//end main()

}//end class













