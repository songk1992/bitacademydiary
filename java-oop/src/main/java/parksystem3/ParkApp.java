package parksystem3;

public class ParkApp {
	public static void main (String[] args) {
		
		IParkable parkable = new Bus();
		ParkSystem3.park(parkable);
		
		ParkSystem3.park(parkable);
		
		parkable = new Bus();
		ParkSystem3.park(parkable);
		
		parkable = new Taxi();
		ParkSystem3.park(parkable);

		parkable = new Airplane();
		ParkSystem3.park(parkable);
		
	}
}


// 상속
// 상속과 오버라이딩을 통해 객체지향 설계원칙을 따르며
// SOLID 원칙의 OPEN에서 확장성을 실현
// 부모를 reference해야 함


