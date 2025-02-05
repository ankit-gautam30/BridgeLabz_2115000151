import java.util.ArrayList;
import java.util.List;

// Faculty class
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Department class (Composition - exists only within University)
class Department {
    private String name;
    private List<Faculty> facultyMembers;

    public Department(String name) {
        this.name = name;
        this.facultyMembers = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public String getName() {
        return name;
    }

    public void listFacultyMembers() {
        System.out.println("Department: " + name);
        for (Faculty faculty : facultyMembers) {
            System.out.println("  Faculty: " + faculty.getName());
        }
    }
}

// University class (Composition - owns departments)
class University {
    private String name;
    private List<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addFacultyToDepartment(String departmentName, Faculty faculty) {
        for (Department dept : departments) {
            if (dept.getName().equals(departmentName)) {
                dept.addFaculty(faculty);
            }
        }
    }

    public void listUniversityStructure() {
        System.out.println("University: " + name);
        for (Department dept : departments) {
            dept.listFacultyMembers();
        }
    }
}

// Main class to demonstrate composition and aggregation
public class UniversitySystem {
    public static void main(String[] args) {
        // Creating a university
        University university = new University("Tech University");

        // Adding departments
        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        // Creating faculty members
        Faculty faculty1 = new Faculty("Dr. Smith");
        Faculty faculty2 = new Faculty("Prof. Johnson");

        // Assigning faculty to departments
        university.addFacultyToDepartment("Computer Science", faculty1);
        university.addFacultyToDepartment("Mechanical Engineering", faculty2);

        // Displaying university structure
        university.listUniversityStructure();
    }
}
