package practice03.prob6;

public class Depart extends Employee {
	String department;

	public Depart(String name, int salary, String department) {
		setName(name);
		setSalary(salary);
		this.department = department;
	}
	
	@Override
	public void getInformation() {
		System.out.printf("이름: %s   연봉: %d   부서:%s\n", getName(), getSalary(),department);
	}
	
}