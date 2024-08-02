package test01;

public class StudentScore {
	protected String studentName;
	protected String studentId;
	protected String subject;
	protected double score;
	public StudentScore(String studentName, String studentId, String subject, double score) {
		this.studentName = studentName;
		this.studentId = studentId;
		this.subject = subject;
		this.score = score;
	}
	public double getScore() {
		return score;
	}
	public void updateScore(double score) {
		if(score>100||score<0)	System.out.println("잘못된 점수 입력");
		else {
			this.score = score;
			System.out.println("점수 수정 완료");
		}
	}
	public void printStudentInfo() {
		System.out.println("학생이름 : "+studentName);
		System.out.println("학생ID : "+studentId);
		System.out.println("과목 : "+subject);
		System.out.println("점수 : "+score);
	}
	
}
