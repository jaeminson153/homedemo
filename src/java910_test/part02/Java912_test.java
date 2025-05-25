package java910_test.part02;

public class Java912_test {

    public static void clearConsole() {
        try {
            // cmd /c cls 명령 실행
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
            pb.inheritIO(); // 현재 콘솔과 입출력 연결
            Process process = pb.start();
            process.waitFor(); // 명령 실행이 끝날 때까지 대기
        } catch (Exception e) {
            System.out.println("콘솔 지우기 실패: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("콘솔을 지우기 전입니다.");
        try {
            Thread.sleep(2000); // 2초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clearConsole(); // 콘솔 클리어

        System.out.println("콘솔이 지워졌습니다.");
    }
    
	public static void strBox(int order, int len, int padding) {
		
		int boxLen = padding*2+len;
		for(int i = 0; i < boxLen ; i++) {
			if(i < padding)
				System.out.print(" ");
			else if(i == padding) {
				if(order == 1)
					System.out.print("┌");
				else 
					System.out.print("└");
			}	
			else if(i == boxLen-1) {
				if(order == 1)
					System.out.print("┐");
				else
					System.out.print("┘");
			}	
			else
				System.out.print("─");  	
		}
		
		System.out.println();
		
	}    
}
