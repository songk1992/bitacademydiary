package parksystem2;

// �ڹټ��󿡼��� ���Ǽ����� ����ó�� ���� ���� ���� �ʴ°�
public abstract class Car {
	private int accelate;
	
	public void wipe() {
		System.out.println("â���� ����");
	}
	
	public void brake() {
		System.out.println("�극��ũ ���");
	}
	
	public abstract void park();
}
