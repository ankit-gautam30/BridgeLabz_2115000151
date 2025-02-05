import java.util.ArrayList;
import java.util.List;

// Course class
class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public String getCourseName() {
        return courseName;
    }

    public void listCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("  Taught by: " + professor.getName());
        }
        System.out.println("  Enrolled Students:");
        for (Student student : students) {
            System.out.println("    " + student.getName());
        }
    }
}

// Professor class
class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void enrollCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public String getName() {
        return name;
    }

    public void listEnrolledCourses() {
        System.out.println("Student: " + name);
        for (Course course : courses) {
            System.out.println("  Enrolled in: " + course.getCourseName());
        }
    }
}

// University class
class University {
    private String name;
    private List<Course> courses;
    private List<Professor> professors;
    private List<Student> students;

    public University(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void listUniversityDetails() {
        System.out.println("University: " + name);
        System.out.println("Courses Offered:");
        for (Course course : courses) {
            course.listCourseDetails();
        }
    }
}

// Main class to demonstrate relationships
public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Creating university
        University university = new University("Global University");

        // Creating professors
        Professor profSmith = new Professor("Dr. Smith");
        Professor profJohnson = new Professor("Dr. Johnson");
        university.addProfessor(profSmith);
        university.addProfessor(profJohnson);

        // Creating courses
        Course math = new Course("Mathematics");
        Course cs = new Course("Computer Science");
        math.assignProfessor(profSmith);
        cs.assignProfessor(profJohnson);
        university.addCourse(math);
        university.addCourse(cs);

        // Creating students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        university.addStudent(alice);
        university.addStudent(bob);

        // Enrolling students in courses
        alice.enrollCourse(math);
        alice.enrollCourse(cs);
        bob.enrollCourse(cs);

        // Displaying university details
        university.listUniversityDetails();
        System.out.println();

        // Displaying student enrollments
        alice.listEnrolledCourses();
        bob.listEnrolledCourses();
    }
}

