package practice03.prob7;

public class Prob7 {
	public static void main(String[] args) {
		Duck d = new Duck();
		d.name = "꽥꽥이";
		
		d.fly();
		d.sing();
		System.out.println( d );
		
		Sparrow s = new Sparrow();
		s.name = "짹짹";
		s.fly();
		s.sing();
		System.out.println( s );
	}
}
