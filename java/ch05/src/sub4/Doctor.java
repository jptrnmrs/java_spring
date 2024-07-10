package sub4;

public class Doctor extends Person{

	private String speciality;

	public Doctor(String name, int age, String speciality) {
		super(name, age);
		this.speciality = speciality;
	}
	
	void work() {
		super.introduce();
		System.out.printf("저는 의사이며 전공은 %s 입니다.\n",speciality);	
	}
}
