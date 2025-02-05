import java.util.ArrayList;
import java.util.List;

// Course class
class Course {
    private String name;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.addCourse(this);
        }
    }

    public String getName() {
        return name;
    }

    public void listEnrolledStudents() {
        System.out.println("Course: " + name);
        for (Student student : students) {
            System.out.println("  Student: " + student.getName());
        }
    }
}

// Student class
class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public String getName() {
        return name;
    }

    public void listEnrolledCourses() {
        System.out.println("Student: " + name);
        for (Course course : courses) {
            System.out.println("  Enrolled in: " + course.getName());
        }
    }
}

// School class
class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void listStudents() {
        System.out.println("School: " + name);
        for (Student student : students) {
            System.out.println("  Student: " + student.getName());
        }
    }
}

// Main class to demonstrate association and aggregation
public class SchoolSystem {
    public static void main(String[] args) {
        // Creating a school
        School school = new School("Greenwood High");

        // Creating students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Adding students to the school
        school.addStudent(student1);
        school.addStudent(student2);

        // Creating courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Enrolling students in courses
        math.enrollStudent(student1);
        math.enrollStudent(student2);
        science.enrollStudent(student1);

        // Displaying school students
        school.listStudents();
        System.out.println();

        // Displaying student courses
        student1.listEnrolledCourses();
        student2.listEnrolledCourses();
        System.out.println();

        // Displaying enrolled students in courses
        math.listEnrolledStudents();
        science.listEnrolledStudents();
    }
}
