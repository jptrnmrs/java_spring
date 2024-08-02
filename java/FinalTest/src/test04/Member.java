package test04;

public class Member {

	private String name;
	private String memberId;
	private Book borrowBook;
	public Member(String name, String memberId) {
		this.name = name;
		this.memberId = memberId;
		borrowBook = null;
	}
	
	public void borrowBook(Book book) {
		if(!book.isBorrowd())borrowBook = book;
		book.borrowBook();
	}
	public void returnBook(Book book) {
		if(book.isBorrowd())borrowBook = null;
		book.returnBook();
	}
	public void getMemberInfo() {
		System.out.println("회원명 : " + name);
		System.out.println("아이디 : " + memberId);
		System.out.printf("대출한 도서 : %s\n", borrowBook==null?"없음":borrowBook.getTitle());
	}
	
}
