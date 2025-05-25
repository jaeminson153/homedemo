package ncs.test06;

public class Calculator {
	
	public static double getSum(int data) throws InvalidException {
		double sum = 0;
		if(data < 2 || 5 < data)
			throw new InvalidException("입력 값에 오류가 있습니다.");
		else {
			for(int i = 1 ; i <= data ; i++) {
				sum += i;
			}
		}			
		
		return sum;
	}
}
