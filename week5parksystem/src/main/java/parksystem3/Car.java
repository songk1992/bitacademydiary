package parksystem3;

// 자바세상에서도 현실세상의 음식처럼 실제 존재 하지 않는것
public abstract class Car implements IParkable{
	private int accelate;

	public void brake() {
		System.out.println("브레이크 밟다");
	}
	
	public abstract void park();
}
