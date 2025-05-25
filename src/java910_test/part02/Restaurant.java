package java910_test.part02;

public class Restaurant {
	private String no;
	private String name;
	private String cType;
	private String pay;
	private String distance;
	private String point;
	
	public Restaurant() {
	
	}
	
	public Restaurant(String no,String name, String cType, String pay, String distance, String point) {
		this.no = no;		
		this.name = name;
		this.cType = cType;
		this.pay = pay;
		this.distance = distance;
		this.point = point;
	}	
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	@Override
	public String toString() {
		String sType = cType.equals("1")?"뷔페":cType.equals("2")?"한식":cType.equals("3")?"분식":cType.equals("4")?"중식":"기타";
		return String.format("│%5s│%10s	│ %4s  │ %6s │  %6s  │  %3s	│",no, name,sType,pay,distance,point);
	}

		
}
