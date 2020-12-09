package practice02;

public class Member {
//	ȸ��(Member) Ŭ������ ȸ�� ���̵� ��Ÿ���� id(���ڿ�)�� ȸ�� �̸��� ��Ÿ���� name(���ڿ�), ȸ���� point�� ��Ÿ���� point(����) �ʵ带 ������ �ִ�. 
//
//	�޼ҵ�� ȸ���� �̸� ���� setName�޼ҵ�� �̸��� ��ȯ�ϴ� getName, ����Ʈ�� �����ϴ� setPoint�� ����Ʈ�� ��ȯ�ϴ� getPoint, ȸ�����̵� �����ϴ� setId, ��ȯ�ϴ� getId �޼ҵ带 ������ �ִ�. 
//
//	��� �ʵ�� �ܺο��� ���� �����Ͽ� ���� �����ϰų� ���� ���ϵ��� private�� ���� ������ ����, �޼ҵ�� ���� ���� ��� ȣ���� �� �ִ� ���� �����ڸ� ����Ѵ�. 

private String id;

private String name;

private int point;

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getPoint() {
	return point;
}

public void setPoint(int point) {
	this.point = point;
}


	
}
