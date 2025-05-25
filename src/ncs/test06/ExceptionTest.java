package ncs.test06;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("2부터 5까지의 정수를 입력해 주세요:");
		int i = sc.nextInt();
		int sum=0;
		try {
			sum = (int)Calculator.getSum(i);
		} catch (InvalidException e) {
			e.printStackTrace();
			return;
		}
		System.out.printf("%d 까지 합계는 %d 입니다.",i, sum);
	}

}
