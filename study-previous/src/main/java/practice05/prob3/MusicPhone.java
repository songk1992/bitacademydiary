package prob3;

public class MusicPhone extends Phone {
	
	@Override
	public void execute ( String function ) {
		if (function.equals("����") ) {
			playMusic();
			return;
		}
		
		super.execute( function );
	}

	private void playMusic(){
		System.out.println("MP3 �÷��̾�� �������");
	}
}
