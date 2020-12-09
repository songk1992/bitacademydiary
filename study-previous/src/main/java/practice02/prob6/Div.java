package practice02.prob6;

public class Div implements Calc {

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
		
		if(b!= 0) {
			return a/b;
		}
		
		else {
			System.out.println("0으로 나눌수 없습니다");
			return 0;
		}
	}

}
