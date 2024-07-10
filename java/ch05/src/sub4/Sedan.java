package sub4;

public class Sedan {
	
	private String name;
	private String color;
	private int speed;
	private int cc;
	
	public Sedan(String name, String color, int speed, int cc) {
		super();
		this.name = name;
		this.color = color;
		this.speed = speed;
		this.cc = cc;
	}
	
	public void speedUp(int speed) {
		this.speed += speed;
	}
	
	public void speedDown(int speed) {
		this.speed -= speed;
	}
	
	public void show() {
		System.out.println("차량명 : " + this.name);
		System.out.println("차량색 : " + this.color);
		System.out.println("차량속도 : " + this.speed);
		System.out.println("배기량 : " + cc);
	}
}
