package parksystem2;

// 자바세상에서도 현실세상의 음식처럼 실제 존재 하지 않는것
public abstract class Car {
	private int accelate;
	
	public void wipe() {
		System.out.println("창문을 딱다");
	}
	
	public void brake() {
		System.out.println("브레이크 밟다");
	}
	
	public abstract void park();
}
