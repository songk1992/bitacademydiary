package practice03.prob7;

public class Duck extends FlightlessBird {

	@Override
	public void fly() {
		System.out.print("오리(" + getName() + ")는 ");
		super.fly();
	}

	@Override
	public void sing() {
		System.out.print("오리(" + getName() + ")가  ");
		super.sing();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public String toString() {
		String str = "오리의" + super.toString();
		return str;
	}

}
