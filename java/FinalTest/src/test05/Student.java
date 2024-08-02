package test05;

public class Student {
	private String name;
	private String studentId;
	private Subject[] subjects;
	private int[] score;
	private int subjectCount;
	
	public Student(String name, String studentId) {
		this.name = name;
		this.studentId = studentId;
		subjects = new Subject[10];
		score = new int[10];
		subjectCount = 0;
	}
	
	public void enrollSubject(Subject sub) {
		subjects[subjectCount] = sub;
		System.out.printf("%s - %s 과목 신청완료\n",name,sub.getSubName());
		sub.addStudent(this);
		subjectCount++;
	}
	public void setScore(Subject sub, int score) {
		for(int i =0; i<subjectCount; i++) {
			if(subjects[i]==sub) {
				this.score[i] = score;
				System.out.printf("%s - %s 점수 입력완료\n",name,sub.getSubName());
				break;
			}
		}
	}
	public void printStudentInfo() {
		System.out.println("학생명 : "+ name);
		System.out.println("아이디 : "+ studentId);
		System.out.println("성적");
		for(int i =0; i<subjectCount; i++) {
			System.out.printf(" - %s:%d\n",subjects[i].getSubName(),score[i]);
		}
	}

	public String getName() {
		return name;
	}
	
}
