package user4;

public class User4VO {
	private String uid;
	private String name;
	private String gender;
	private int age;
	private String hp;
	private String addr;
	public User4VO() {
	}
	public User4VO(String uid, String name, String gender, int age, String hp, String addr) {
		this.uid = uid;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.hp = hp;
		this.addr = addr;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "uid=" + uid + ", name=" + name + ", gender=" + gender + ", age=" + age + ", hp=" + hp
				+ ", addr=" + addr;
	}
	
}
