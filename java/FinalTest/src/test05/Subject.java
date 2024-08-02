package test05;

public class Subject {
	private String subName;
	private Student[] students;
	private int studentCount;
	
	public Subject(String subName) {
		this.subName = subName;
		students = new Student[10];
		studentCount=0;
	}
	public void addStudent(Student std) {
		students[studentCount++] = std;
	}
	public void printSubjectInfo() {
		System.out.println("과목명 : "+subName);
		System.out.print("수강생 : ");
		for(Student std : students) {
			System.out.printf(std!=null?std.getName()+", ":"");
		}
		System.out.println();
	}
	public String getSubName() {
		return subName;
	}
	
}
