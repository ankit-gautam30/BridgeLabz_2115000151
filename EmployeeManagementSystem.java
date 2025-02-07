class Employee {
	protected String name;
	protected int id;
	protected double salary;

	public Employee (String name, int id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public void displayDetails(){
		System.out.println("Name: " + name + " Id: " + id + " Salary : Rs" + salary);
	}
}
class Manager extends Employee {
	private int teamSize;
	public Manager (String name, int id, double salary, int teamSize) {
		super(name,id,salary);
		this.teamSize = teamSize;
	}
	@Override
	public void displayDetails(){
		super.displayDetails();
		System.out.println("TeamSize: " + teamSize);
	}
}
class Developer extends Employee {
	private String programmingLanguage;
	public Developer (String name, int id, double salary, String programmingLanguage) {
	super(name,id,salary);
	this.programmingLanguage = programmingLanguage;
	}
	@Override
	public void displayDetails(){
		super.displayDetails();
		System.out.println("Programming Language: " + programmingLanguage);
	}
}
class Intern extends Employee {
	private String collegeName;
	public Intern (String name, int id, double salary, String collegeName) {
	super(name,id,salary);
	this.collegeName = collegeName;
	}
	@Override
	public void displayDetails(){
		super.displayDetails();
		System.out.println("College Name: " + collegeName);
	}
}
public class EmployeeManagementSystem {
	public static void main(String[] args) {
		Employee manager = new Manager("Jayant",121,156765.34,5);
		Employee developer = new Developer("Sparsh",1210,556234.89,"Java");
		Employee intern = new Intern("Ajay",1010,34333.55,"GLA University");
		manager.displayDetails();
		System.out.println();
		developer.displayDetails();
		System.out.println();
		intern.displayDetails();
	}
}
