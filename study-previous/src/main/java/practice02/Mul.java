package practice02;

public class Mul implements Calc {

	int a;
	int b;
	
	@Override
	public void setValue(int a, int b) {
		// TODO Auto-generated method stub
		this.a = a;
		this.b = b;
	}

	@Override
	public int calculate() {
		return a*b;
	}

}
