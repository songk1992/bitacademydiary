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


// ���
// ��Ӱ� �������̵��� ���� ��ü���� �����Ģ�� ������
// SOLID ��Ģ�� OPEN���� Ȯ�强�� ����
// �θ� reference�ؾ� ��


