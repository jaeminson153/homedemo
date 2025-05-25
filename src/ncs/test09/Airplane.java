package ncs.test09;

public class Airplane extends Plane{
	

	public Airplane() {
	
	}
	
	public Airplane(String planeName,int fuelSize ) {
		super(planeName, fuelSize);
	}
	
	
	@Override
	void flight(int distance) {
		setFuelSize(getFuelSize() - (distance * 3)); 		
	}

}
