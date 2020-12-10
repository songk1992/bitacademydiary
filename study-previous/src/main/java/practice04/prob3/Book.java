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
		this.stateCode = 0;
		System.out.println( title + " 이(가) 대여 됐습니다.");
	}
	
	public void print() {
		
		System.out.print( "책 제목 :" + title );
		System.out.print( ", 장르:" + genre );
		System.out.print( ", 대여 유무:");
		if(stateCode==1) {
			System.out.println("재고있음");
		}
		else {
			System.out.println("재고없음");
		}
	}


	public int getBookNum() {
		return bookNum;
	}


	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}

	


}
