package ncs.test10;

public class Company {

	public static void main(String[] args) {
		Employee[] employees = new Employee[2];
		
		// 1번의 사용 데이터를 기반으로 객체를 생성하여 배열에 넣는다 .
		// 모든 객체의 기본 정보를 출력한다 (for 문을 이용하여 출력한다.)
		// 모든 객체에 인센티브 100 씩 지급한 급여를 계산하고 다시 객체의 salary에 넣는다 .
		// 모든 객체의 정보와 세금을 출력한다 (for 문을 이용하여 출력한다.)
		
		employees[0] = new Secretary("Hilery",1,"secretary",800);
		employees[1] = new Sales("Clinten",2,"sales",1200);
		
		System.out.println("name      department   salary");
		System.out.println("-------------------------------");
		for(Employee data : employees) {
			System.out.printf("%-9s %-11s  %5d\n",data.getName(), data.getDepartment(), data.getSalary());			
		}		
		
		System.out.println();
		System.out.println("인센티브 100 지급");
		for(Employee data : employees) {
			if(data.getDepartment().equals("secretary"))
				((Secretary)data).incentive(100);
			else if(data.getDepartment().equals("sales"))
				((Sales)data).incentive(100);
		}
		
		System.out.println("name      department   salary    tax");
		System.out.println("---------------------------------------");	
		for(Employee data : employees) {
			System.out.printf("%-9s %-12s %5d %7.1f\n",data.getName(), data.getDepartment(), data.getSalary(), data.getDepartment().equals("sales") ? ((Sales)data).tax(): ((Secretary)data).tax());			
		}

	}

}
