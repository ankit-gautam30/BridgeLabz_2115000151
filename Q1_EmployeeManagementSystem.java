abstract class Employee {
	private int employeeId;
	private String name;
	private double baseSalary;

	public Employee(int employeeId, String name, double baseSalary) {
		this.employeeId = employeeId;
		this.name = name;
		this.baseSalary = baseSalary;
	}
	public int getEmployeeId(){
		return employeeId;
	}
	public String getName(){
		return name;
	}
	public double getBaseSalary(){
		return baseSalary;
	}

	public abstract double calculateSalary();

	public void displayDetails() {
		System.out.println("ID of employee is: " + employeeId);
		System.out.println("Name of employee is: " + name);
		System.out.println("BaseSalary of employee is: " + baseSalary);
	}
}
interface Department {
	void assignDepartment(String deptName);
	String getDepartmentDetails();
}
class FullTimeEmployee extends Employee implements Department {
	private String department;
	public FullTimeEmployee(int employeeId, String name, double baseSalary) {
		super(employeeId, name, baseSalary);
	}
	@Override
	public double calculateSalary() {
		return getBaseSalary();
	}
	@Override
	public void assignDepartment(String deptName) {
		this.department = deptName;
	}
	@Override
	public String getDepartmentDetails() {
		return "Department: " + department;
	}
}
class PartTimeEmployee extends Employee implements Department {
	private int hoursWorked;
	private double hourlyRate;
	private String department;

	public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
		super(employeeId,name,0);
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}
	@Override
	public double calculateSalary() {
		return hoursWorked * hourlyRate;
	}
	@Override
    	public void assignDepartment(String deptName) {
        	this.department = deptName;
    	}
	@Override
    	public String getDepartmentDetails() {
        	return "Department: " + department;
    	}
}
public class Q1_EmployeeManagementSystem {
	public static void main(String[] args) {
		Employee[] employees = new Employee[2];

		FullTimeEmployee emp1 = new FullTimeEmployee(999,"Amit",50000);
		emp1.assignDepartment("IT");

		PartTimeEmployee emp2 = new PartTimeEmployee(123,"Prince",20,100);
		emp2.assignDepartment("Accounts");

		employees[0] = emp1;
		employees[1] = emp2;

		for (Employee emp : employees) {
			emp.displayDetails();
			if (emp instanceof Department) {
				System.out.println(((Department) emp).getDepartmentDetails());
			}
			System.out.println("----------------");
		}
	}
}
