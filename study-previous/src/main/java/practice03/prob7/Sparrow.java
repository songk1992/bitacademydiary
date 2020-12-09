package practice03.prob7;

public class Sparrow extends FlyingBird {

	@Override
	public void fly() {
		System.out.print("제비(" + getName() + ")가 ");
		super.fly();
	}

	@Override
	public void sing() {
		System.out.print("제비(" + getName() + ")가  ");
		super.sing();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public String toString() {
		String str = "제비의" + super.toString();
		return str;
	}

}
