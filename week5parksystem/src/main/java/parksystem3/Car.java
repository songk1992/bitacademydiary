package parksystem3;

// �ڹټ��󿡼��� ���Ǽ����� ����ó�� ���� ���� ���� �ʴ°�
public abstract class Car implements IParkable{
	private int accelate;

	public void brake() {
		System.out.println("�극��ũ ���");
	}
	
	public abstract void park();
}
