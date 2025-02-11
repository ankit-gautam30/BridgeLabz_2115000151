class Student {
	int rollNumber;
	String name;
	int age;
	String grade;
	Student next;

	public Student(int rollNumber, String name, int age, String grade) {
		this.rollNumber = rollNumber;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.next = null;
	}
}
class StudentLinkedList {
	private Student head;
	public void addAtBeginning(int rollNumber, String name, int age, String grade) {
		Student newStudent = new Student(rollNumber, name, age, grade);
		newStudent.next = head;
		head = newStudent;
	}
	public void addAtEnd(int rollNumber, String name, int age, String grade) {
		Student newStudent = new Student(rollNumber, name, age, grade);
		if(head == null){
			head = newStudent;
			return;
		}
		Student temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = newStudent;
	}
	public void addAtPosition(int rollNumber, String name, int age, String grade, int position) {
		if (position <= 0) {
			System.out.println("Invalid position");
			return;
		}
		Student newStudent = new Student(rollNumber, name, age, grade);
		if (position == 1) {
			newStudent.next = head;
			head = newStudent;
			return;
		}
		Student temp = head;
		for (int i = 1; temp != null && i < position - 1; i++) {
			temp = temp.next;
		}
		if (temp == null) {
			System.out.println("Position out od bounds");
			return;
		}
		newStudent.next = temp.next;
		temp.next = newStudent;
	}
	public void deleteByRollNumber(int rollNumber) {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		if (head.rollNumber == rollNumber) {
			head = head.next;
			return;
		}
		Student temp = head;
		while (temp.next != null && temp.next.rollNumber != rollNumber) {
			temp = temp.next;
		}
		if (temp.next == null) {
			System.out.println("Student not found");
			return;
		}
		temp.next = temp.next.next;
	}
	public void searchByRollNumber(int rollNumber) {
		Student temp = head;
		while (temp != null) {
			if (temp.rollNumber == rollNumber) {
				System.out.println("Student Found: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Student not found");
	}
	public void updateGrade(int rollNumber, String newGrade) {
		Student temp = head;
		while (temp != null) {
			if (temp.rollNumber == rollNumber) {
				temp.grade = newGrade;
				System.out.println("Grade updated for student: " + temp.name);
				return;
			}
			temp = temp.next;
		}
		System.out.println("Student not found");
	}
	public void displayStudents() {
		if (head == null) {
			System.out.println("No records found");
			return ;
			}
		Student temp = head;
		while (temp != null) {
			System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
			temp = temp.next;
		}
	}
}
public class Q1_Student_Record_Management {
	public static void main (String[] args) {
		StudentLinkedList list = new StudentLinkedList();

        	list.addAtBeginning(101, "Aman", 20, "A");
	        list.addAtEnd(102, "Ajay", 21, "B");
        	list.addAtPosition(103, "Chetak", 22, "C", 2);

                System.out.println("Student Records:");
        	list.displayStudents();

                System.out.println("Searching for Roll Number 102:");
        	list.searchByRollNumber(102);

       	        list.updateGrade(101, "A");

       	        list.deleteByRollNumber(103);

       	        System.out.println("Updated Student Records:");
        	list.displayStudents();
	}
}
