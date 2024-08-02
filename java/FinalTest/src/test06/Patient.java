package test06;

public class Patient {
	private String name; // 환자 이름
    private String id;   // 환자 아이디
    private int age;     // 환자 나이
    private String diagnosis; // 진단명

    // 생성자
    public Patient(String name, String id, int age, String diagnosis) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.diagnosis = diagnosis;
    }

	@Override
	public String toString() {
		return "- Patient [name=" + name + ", id=" + id + ", age=" + age + ", diagnosis=" + diagnosis + "]\n";
	}

    
}
