import java.util.*;

class Employee {
    String name;
    String department;
    
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );
        
        Map<String, List<Employee>> groupedByDepartment = groupByDepartment(employees);
        System.out.println(groupedByDepartment);
    }
    
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();
        for (Employee e : employees) {
            departmentMap.computeIfAbsent(e.getDepartment(), k -> new ArrayList<>()).add(e);
        }
        return departmentMap;
    }
}
