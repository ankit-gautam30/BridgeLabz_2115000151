import java.util.ArrayList;
import java.util.List;

// Employee class
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Department class
class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    public String getName() {
        return name;
    }

    public void listEmployees() {
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            System.out.println("  Employee: " + emp.getName());
        }
    }
}

// Company class
class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addEmployeeToDepartment(String departmentName, String employeeName) {
        for (Department dept : departments) {
            if (dept.getName().equals(departmentName)) {
                dept.addEmployee(employeeName);
            }
        }
    }

    public void listCompanyStructure() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.listEmployees();
        }
    }
}

// Main class to demonstrate composition
public class CompanySystem {
    public static void main(String[] args) {
        // Creating a company
        Company company = new Company("Tech Corp");

        // Adding departments
        company.addDepartment("Engineering");
        company.addDepartment("HR");

        // Adding employees to departments
        company.addEmployeeToDepartment("Engineering", "Alice");
        company.addEmployeeToDepartment("Engineering", "Bob");
        company.addEmployeeToDepartment("HR", "Charlie");

        // Displaying company structure
        company.listCompanyStructure();
    }
}
