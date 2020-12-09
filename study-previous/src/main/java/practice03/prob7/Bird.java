package practice03.prob7;

public class Bird {
	private String name;
	private int legs;
	private int length;
	
	public void fly() {
	}
	
	public void sing() {
		System.out.println("소리내어 웁니다.");
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "이름은 " + name + " 입니다";
	}
	
	
	
}
