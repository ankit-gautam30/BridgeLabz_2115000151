class Animal {
	protected String name;
	protected int age;

	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void makeSound() {
		System.out.println("Animal sound");
	}
}
class Dog extends Animal {
	public Dog(String name, int age) {
		super(name, age);
	}
	@Override
	public void makeSound() {
		System.out.println(name + " says: Woof Woof!");
	}
}
class Cat extends Animal {
        public Cat(String name, int age) {
                super(name, age);
        }
        @Override
        public void makeSound() {
                System.out.println(name + " says: Meo Meo!");
        }
}
class Bird extends Animal {
        public Bird(String name, int age) {
                super(name, age);
        }
        @Override
        public void makeSound() {
                System.out.println(name + " says: Chirp Chirp!");
        }
}
public class AnimalHierarchy {
	public static void main(String[] args) {
		Animal myDog = new Dog("Rocky",1);
		Animal myCat = new Cat("Jack",2);
		Animal myBird = new Bird("Hans",3);

		myDog.makeSound();
		myCat.makeSound();
		myBird.makeSound();
	}
}
