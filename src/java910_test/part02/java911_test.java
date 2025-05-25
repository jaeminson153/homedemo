package java910_test.part02;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/*
 * 1. 삭제, 수정시 식당번호 오입력에 대한 처리  ==> 완료
 * 2. 입력시 식당번호 중복 제거 		==> 완료 
 * 3. 입력시 필수값 미입력 제거 및 식당번호 번호값 검증
 * 4. 식당평점 검증 (다른 값들은 검증은 하지 않는다.)
 * 4. 파일 입출력 처리.
 */
public class java911_test {

	public static void main(String[] args) {
		String csvFile = "resList.csv"; 
		printMain();
	
		Scanner scanner = new Scanner(System.in);
		ArrayList<Restaurant> rList = new ArrayList<>();
		
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int iLine=0;
			while ((line = br.readLine()) != null) {
                iLine++;
				String[] resInfo = line.split(",");
                
	        	if(iLine != 1) {
	        		Restaurant res = new Restaurant(resInfo[0], resInfo[1], resInfo[2], resInfo[3], resInfo[4], resInfo[5] );
	        		rList.add(res);
	        	}	
            }
            
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }		
		
		while(true) {
			printMenu();
			
			System.out.print("메뉴번호를 입력하세요: ");
	        String menu = scanner.nextLine();
	        int menuNo;
	        String sMenuNo;		// 입력 받는 메뉴번호
	        String resNo;		// 입력 또는 수정시 식당번호
	        String resName;		// 입력 또는 수정시 식당명 
	        String cType;		// 입력 또는 수정시 식당타입
	        String pay;			// 입력 또는 수정시 금액대
	        String distance;	// 입력 또는 수정시 식당과거리
	        String point;		// 입력 또는 수정시 평점
	        boolean chk;		// 삭제 또는 수정시 식당존재 여부 확인
	        
	        try {
	        	menuNo = Integer.parseInt(menu);
	        } catch (NumberFormatException e) {
	        	System.out.println("유효하지 않은 메뉴번호입니다: " + menu);
	        	continue;
	        }
	        if(menuNo == 1) {
	        	/* 식당명 식당분류(1:뷔페, 2:한식, 3:분식, 4:중식, 5:기타) 금액, 거리, 평점 */	     
	        	resNo = "";
	        	resName = "";
	        	cType = "";
	        	pay = "";
	        	distance = "";
	        	point = "";
	        	do {
		        	System.out.print("식당번호를 입력하세요:");
		        	resNo = scanner.nextLine();
		        	chk = true;
		        	try {
		        		Integer.parseInt(resNo);
		        	}catch(Exception e){
		        		chk = false;
	        			System.out.println("식당번호는 숫자로 입력해 주세요");	        			
		        	}
		        	
		        	for(int i = 0 ; i<rList.size() ; i++) {
		        		if(rList.get(i).getNo().equals(resNo)) { 
		        			chk = false;
		        			System.out.println("식당번호가 중복되었습니다.");
		        			break;
		        		}	
		        	}
	        	}while(!chk);
	        	
	        	do {
	        		chk = true;
	        		System.out.print("식당명을 입력하세요:");
	        		resName = scanner.nextLine();
	        		if(resName.equals("")) {
	        			chk = false;
	        			System.out.println("식당명은 필수 입력입니다.");
	        		}
	        	}while(!chk);
	        	System.out.print("식당분류를 입력하세요(1:뷔페, 2:한식, 3:분식, 4:중식, 5:기타):");
	        	cType = scanner.nextLine();
	        	System.out.print("금액대를 입력하세요(단위 원):");
	        	pay = scanner.nextLine();
	        	System.out.print("식당까지 거리를 입력하세요(단위 M):");
	        	distance = scanner.nextLine();
	        	do {
	        		chk = true;
	        		System.out.print("식당평점을 입력하세요(5점 만점):");
	        		point = scanner.nextLine();	 
	        		
		        	try {
		        		if( 0 > Integer.parseInt(point) || Integer.parseInt(point) > 5) {
		        			System.out.println("식당평점은 0점 부터 5점 사이값으로 입력해주세요.");
		        			chk = false;
		        		}
		        			
		        	}catch(Exception e){
		        		chk = false;
	        			System.out.println("평점은 숫자로 입력해 주세요");	        			
		        	}	        		
	        		
	        	}while(!chk);
	        	
	        	Restaurant res = new Restaurant(resNo, resName, cType, pay, distance, point );
	        	rList.add(res);
				System.out.printf("%s 식당이 입력되었습니다.\n",resName);
				clearConsole();
	        	
	        }else if(menuNo == 2) {	        	
	        	printTitle();
	        	for(int i = 0 ; i < rList.size() ; i++) {
	        		System.out.println(rList.get(i).toString());
	        	}
	        	printEnd();
	        	clearConsole();
	        	
	        }else if(menuNo == 3) {
	        	// 수정할 번호를 받아서 리스트 에서 해당 클래스를 받아 수정후 다시 셋팅한다.
	        	int resSeq = 0;
	        	
	        	resNo = "";
	        	resName = "";
	        	cType = "";
	        	pay = "";
	        	distance = "";
	        	point = "";	        	
	        	chk = false;
	        	
	        	System.out.print("수정할 식당번호를 입력해주세요 => ");
	        	sMenuNo = scanner.nextLine();
	        	Restaurant resMod = new Restaurant();
	        	for(int i = 0 ; i<rList.size() ; i++) {
	        		if(rList.get(i).getNo().equals(sMenuNo)) { 
	        			resMod = rList.get(i);
	        			resSeq = i;
	        			chk = true;
	        			break;
	        		}	
	        	}	
	        	
	        	if(!chk) {
	        		System.out.println("해당 식당변호가 존재하지 않습니다.확인후 다시 입력해 주세요.");
		        	System.out.print("아무키나 눌러주세요...");
		        	scanner.nextLine();
		        	clearConsole();
		        	continue;
	        	}
	        	
	        	resName="";
	        	cType = "";
	        	pay = "";
	        	distance = "";
	        	point = "";
	        	System.out.println("<<수정이 필요없는 항목은 엔터키를 입력하세요.>>");
	        	System.out.print("수정할 식당명을 입력하세요:");
	        	resName = scanner.nextLine();
	        	System.out.print("수정할 식당분류를 입력하세요(1:뷔페, 2:한식, 3:분식, 4:중식, 5:기타):");
	        	cType = scanner.nextLine();
	        	System.out.print("수정할 금액대를 입력하세요(단위 원):");
	        	pay = scanner.nextLine();
	        	System.out.print("수정할 식당까지 거리를 입력하세요(단위 M):");
	        	distance = scanner.nextLine();
	        	System.out.print("수정할 식당평점을 입력하세요(5점 만점):");
	        	point = scanner.nextLine();		
	        	
	        	if(!resName.equals(""))
	        		resMod.setName(resName);
	        	
	        	if(!cType.equals(""))
	        		resMod.setcType(cType);
	        	
	        	if(!pay.equals(""))
	        		resMod.setPay(pay);
	        	
	        	if(!distance.equals(""))
	        		resMod.setDistance(distance);
	        	
	        	if(!point.equals(""))
	        		resMod.setPoint(point);	  
	        	
	        	rList.set(resSeq, resMod);	        	
				System.out.printf("식당번호 %s 인 식당이 수정되었습니다.\n",sMenuNo);
				clearConsole();	        	
	        	
	        }else if(menuNo == 4) {
	        	System.out.print("삭제할 식당번호를 입력해주세요 => ");
	        	sMenuNo = scanner.nextLine();
	        	String tmpName="";
	        	chk = false;
	        	for(int i = 0 ; i<rList.size() ; i++) {
	        		if(rList.get(i).getNo().equals(sMenuNo)) { 
	        			tmpName = rList.get(i).getName();
	        			System.out.printf("%s번 %s이 삭제됩니다.:\n",rList.get(i).getNo(),rList.get(i).getName());
	        			rList.remove(i);	
	        			chk = true;
	        			break;
	        		}	
	        	}
	        	
	        	if(!chk) {
	        		System.out.println("해당 식당변호가 존재하지 않습니다.확인후 다시 입력해 주세요.");
		        	System.out.print("아무키나 눌러주세요...");
		        	scanner.nextLine();
		        	clearConsole();
		        	continue;
	        	}
	        	
				System.out.printf("식당번호 %s 인 %s 식당이 삭제되었습니다.\n",sMenuNo,tmpName);
				clearConsole();
	        	
	        }else if(menuNo == 5) {	        	
	        	System.out.println("프로그램을 종료합니다.");
	        	StringBuffer sb = new StringBuffer();
	        	try {
	        		FileWriter writer = new FileWriter(csvFile);
	        		writer.append("식당번호,식당명,음식타입,금액대,식당까지거리,평점\n");
	        		System.out.println("resList.csv 파일로 저장시작");
	        		for(int i = 0 ; i<rList.size() ; i++) {
	        			sb.setLength(0);
	        			sb.append(rList.get(i).getNo()+",");
	    	        	sb.append(rList.get(i).getName()+",");
	    	        	sb.append(rList.get(i).getcType()+",");
	    	        	sb.append(rList.get(i).getPay()+",");
	    	        	sb.append(rList.get(i).getDistance()+",");
	    	        	sb.append(rList.get(i).getPoint()+"\n");
	    	        	//System.out.println(sb.toString());
	    	        	writer.append(sb.toString());
	        		}
	        		
	        		writer.close();
	        		System.out.println("resList.csv 파일로 저장되었습니다.");
	        		
	        	}catch (IOException e) {
	        		System.out.println("CSV 저장 중 오류 발생");
	        		
	        		continue;
	        	}
	        	break;
	        }else {
	        	System.out.println("메뉴번호를 잘못입력하셨습니다.");
	        }	
			
		}
		
		System.out.println("프로그램이 종료되었습니다.");		
		scanner.close();
	}
	
	public static void printMain() {
		System.out.println("┌───────────────────────────────────────┐");
		System.out.println("│            구디역 맛집 리스트 관리		│");
		System.out.println("└───────────────────────────────────────┘");
	}
	
	public static void printMenu() {
		System.out.println(" << 구디역 맛집 관리 >> ");
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("│    1.맛집 입력  2.맛집 리스트  3.맛집 수정  4.맛집 삭제  5.끝내기	│");
		System.out.println("└───────────────────────────────────────────────────────┘");
	}	
	
	public static void printTitle() {
		System.out.println(" << 구디역 맛집 리스트 >> ");
		System.out.println("┌───────────────────────────────────────────────────────────────┐");
		System.out.println("│식당번호│      식당명	│ 음식타입 │ 금액대(원) │식당까지거리(M)│    평점	│");
		System.out.println("└───────────────────────────────────────────────────────────────┘");
	}	
	
	public static void printEnd() {
		System.out.println("└───────────────────────────────────────────────────────────────┘");
	}		
	
    public static void clearConsole() {
       for(int i = 0 ; i<2 ; i++) {
    	   System.out.println();
       }
    }
}
