package test04;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private boolean isBorrowd;
	public Book(String title, String author, String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		isBorrowd = false;
	}
	public void borrowBook() {
		if(isBorrowd) {
			System.out.println(this.getTitle()+" 이미 대출된 도서입니다.");
		}else {
			System.out.println("도서대출 : "+this.getTitle());
			isBorrowd = true;
		}
	}
	public void returnBook() {
		if(!isBorrowd) {
			System.out.println(this.getTitle()+" 빌린 기록이 없습니다.");
		}else {
			System.out.println("도서반납 : "+this.getTitle());
			isBorrowd = false;
		}
	}
	public void getBookInfo() {
		System.out.println("도서명 : " + title);
		System.out.println("저자 : " + author);
		System.out.println("ISBN : " + isbn);
		System.out.printf("대출여부 : %s\n",isBorrowd? "불가능":"가능");
	}
	public String getTitle() {
		return title;
	}
	public boolean isBorrowd() {
		return isBorrowd;
	}
	
	
}
