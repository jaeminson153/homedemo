package ncs.test09;

public class PlaneTest {
	public static void main(String[] args) {
        // Airplane 과 Cargoplane 객체 생성   
        // 생성된 객체의 정보 출력   
        // Airplane 과 Cargoplane 객체에 100 씩 운항   
        // 100 운항 후 객체 정보 출력   
        //Airplane 과 Cargoplane 객체에 200 씩 주유  
        // 200 주유 후 객체 정보 출력 
		
		Airplane airPlane = new Airplane("L747", 1000);
		Cargoplane cargoPlane = new Cargoplane("C40",1000);
		
		System.out.println("Plane      fuleSize");
		System.out.println("-------------------------");
		System.out.printf("%-10s %8d\n",airPlane.getPlaneName(), airPlane.getFuelSize());
		System.out.printf("%-10s %8d\n",cargoPlane.getPlaneName(), cargoPlane.getFuelSize());
		System.out.println("100 운항");
		airPlane.flight(100);
		cargoPlane.flight(100);
		System.out.println("Plane      fuleSize");
		System.out.println("-------------------------");
		System.out.printf("%-10s %8d\n",airPlane.getPlaneName(), airPlane.getFuelSize());
		System.out.printf("%-10s %8d\n",cargoPlane.getPlaneName(), cargoPlane.getFuelSize());
		System.out.println("200 주유");
		airPlane.refuel(200);
		cargoPlane.refuel(200);
		System.out.println("Plane      fuleSize");
		System.out.println("-------------------------");
		System.out.printf("%-10s %8d\n",airPlane.getPlaneName(), airPlane.getFuelSize());
		System.out.printf("%-10s %8d\n",cargoPlane.getPlaneName(), cargoPlane.getFuelSize());		
		
	}
}
