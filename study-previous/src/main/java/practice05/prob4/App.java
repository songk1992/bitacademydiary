package practice05.prob4;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Unit unit = new Tank();
		
		unit.move(3, 2);
		
		unit.stop();
		
		unit.changeMode();
		
		unit = new Marine();
		
		unit.move(3, 2);
		
		unit.stop();
		
		unit.stimPack();
	}

}
