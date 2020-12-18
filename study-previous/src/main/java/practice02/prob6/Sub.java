package practice02.prob6;

public class Sub implements Calc {
	
	int a;
	int b;
	
	public void setValue(int a, int b) {
		// TODO Auto-generated method stub
		this.a = a;
		this.b = b;
	}

	public int calculate() {
		return a-b;
	}

}
