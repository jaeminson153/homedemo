package ncs.test07;

public class Human {
	private String name;
	private int age;
	private int height;
	private int weight;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;		
	}
	
	public String toString() {
		return String.format("%4s %3d %4d %3d",name, age, height, weight);
	}
}
