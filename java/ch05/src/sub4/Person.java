package sub4;

public class Person {
	
	protected String name;
	protected int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	void work() {
		System.out.println("Person is working");
	}
	
	void introduce() {
		System.out.printf("제 이름은 %s이고 나이는 %d세 입니다.\n",name,age);
	}
	

}
