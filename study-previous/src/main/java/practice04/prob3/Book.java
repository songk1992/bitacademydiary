package practice04.prob3;

public class Book {
	private int bookNum;
	private String title;
	private String genre;
	private int stateCode;
	
	public Book(int bookNum, String title, String genre) {
		this.bookNum = bookNum;
		this.title = title;
		this.genre = genre;
		this.stateCode = 1;
	}
	
	
	public void rent() {
		System.out.println("_______이(가) 대여 됐습니다.");
	}
	
	public void print() {
		
	}
	
	


}
