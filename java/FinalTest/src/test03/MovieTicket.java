package test03;

public class MovieTicket {
	private String movieTitle;
	private String screenTime;
	private String seatNumber;
	private boolean isBooked;
	public MovieTicket(String movieTitle, String screenTime, String seatNumber) {
		this.movieTitle = movieTitle;
		this.screenTime = screenTime;
		this.seatNumber = seatNumber;
		isBooked=false;
	}
	public void bookTicket() {
		if(isBooked) {
			System.out.println("이미 예매된 좌석입니다.");
		}else {
			System.out.println(movieTitle+", "+screenTime+", "+seatNumber+" 예매 완료");
			isBooked=true;
		}
	}
	public void cancelBooking() {

		if(isBooked) {
			isBooked=false;
			System.out.println(movieTitle+", "+screenTime+", "+seatNumber+" 취소 완료");
		}else {
			System.out.println("예매되지 않은 좌석입니다.");
		}
	}
	public void printTicketInfo() {
		System.out.println("영화제목 : "+movieTitle);
		System.out.println("상영시간 : "+screenTime);
		System.out.println("좌석번호 : "+seatNumber);
		System.out.printf("예매여부 : %s\n", isBooked ? "Yes":"No");
	}
	
}
