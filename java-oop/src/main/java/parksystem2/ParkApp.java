package parksystem2;

public class ParkApp {
	public static void main (String[] args) {
		Car c = new SportsCar();
		c.park();
		
		c = new Bus();
		c.park();
		
		c = new Taxi();
		c.park();

		//���������� �������� �� �־ �������̽� ���
//		c = new Airplane();
//		c.park();
	}
}


// ���
// ��Ӱ� �������̵��� ���� ��ü���� �����Ģ�� ������
// SOLID ��Ģ�� OPEN���� Ȯ�强�� ����
// �θ� reference�ؾ� ��


