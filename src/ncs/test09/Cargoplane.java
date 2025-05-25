package ncs.test09;

public class Cargoplane extends Plane{
	
	public Cargoplane() {
	
	}
	
	public Cargoplane(String planeName,int fuelSize ) {
		super(planeName, fuelSize);
	}
		
		
	@Override
	void flight(int distance) {
		setFuelSize(getFuelSize() - (distance * 5));		
	}

}
