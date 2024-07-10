package sub6;

class Pet {
	public void makeSound(){
	}
}

class Dog extends Pet {
	@Override
	public void makeSound() {
		System.out.println("멍멍");
	}
}

class Cat extends Pet {
	@Override
	public void makeSound() {
		System.out.println("야옹");
	}
}

public class Quiz {
	
	public static void main(String[] args) {
		Pet dog = new Dog();
		Pet cat = new Cat();
		
		printSound(dog);
		printSound(cat);
	}
	public static void printSound(Pet pet) {
		pet.makeSound();
	}
}
