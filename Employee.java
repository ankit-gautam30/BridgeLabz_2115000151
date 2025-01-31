class Employee{
	private String name;
	private int id;
	private double salary;

	public Employee(String name,int id,double salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public void displayDetails() {
		System.out.println("Employee details: ");
		System.out.println("Name:" + name);
		System.out.println("Id:" + id);
		System.out.println("Salary:" + salary);
	}

	public static void main(String[] args) {
		Employee employee = new Employee("Sahil", 34, 71000.50);
		employee.displayDetails();
	}
}
