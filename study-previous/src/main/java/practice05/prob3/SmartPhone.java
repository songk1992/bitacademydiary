package practice05.prob3;

public class SmartPhone extends MusicPhone {

	@Override
	public void execute(String function) {
	      if (function.equals("앱") ) {
	          ExecuteApp();
	          return;
	      }

		super.execute(function);
	}
	
	  private void ExecuteApp(){
		    System.out.print("앱실행");
		  }


}
