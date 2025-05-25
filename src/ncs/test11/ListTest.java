package ncs.test11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(); 
		//명시한 사용 데이터를 list 에 기록한다. 
		// list 의 데이터를 내림차순 정렬한다. 
		// display() 메소드를 호출한다. 		
		
		Random random = new Random();
		
		for(int i = 0 ; i< 10 ; i++) {
			list.add(random.nextInt(100)+1);
		}	
		
		display(list);

	}
	
	//display() 메소드를 구현한다. 
	public static void display(List<Integer> list) {
		
		System.out.print("정렬전 : ");
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.printf("%d ",list.get(i));
			if(i == list.size()-1)
				System.out.println();
			else 
				System.out.print(" ");
		}
		
		Collections.sort(list, new Decending());
		
		System.out.print("정렬후 : ");
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.printf("%d ",list.get(i));
			if(i == list.size()-1)
				System.out.println();
			else 
				System.out.print(" ");
		}
	}

}
