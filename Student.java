class Students {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Students(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostgraduateStudent extends Students {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + getCGPA());
    }
}

public class Student {
    public static void main(String[] args) {
        PostgraduateStudent pgStudent = new PostgraduateStudent(101, "John Doe", 9.5);
        pgStudent.displayDetails();
        pgStudent.setCGPA(9.8);
        System.out.println("Updated CGPA: " + pgStudent.getCGPA());
    }
}
