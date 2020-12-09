package parksystem2;

public class ParkApp {
	public static void main (String[] args) {
		Car c = new SportsCar();
		c.park();
		
		c = new Bus();
		c.park();
		
		c = new Taxi();
		c.park();

		//개념적으로 문제있을 수 있어서 인터페이스 사용
//		c = new Airplane();
//		c.park();
	}
}


// 상속
// 상속과 오버라이딩을 통해 객체지향 설계원칙을 따르며
// SOLID 원칙의 OPEN에서 확장성을 실현
// 부모를 reference해야 함


