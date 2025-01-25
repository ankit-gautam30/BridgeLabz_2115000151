import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        if (numStudents <= 0) {
            System.out.println("Error: Number of students must be a positive integer.");
            return;
        }

        double[][] marks = new double[numStudents][3]; // [physics, chemistry, maths]
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];
        String[] remarks = new String[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";

                while (true) {
                    System.out.print(subject + ": ");
                    marks[i][j] = scanner.nextDouble();
                    if (marks[i][j] < 0 || marks[i][j] > 100) {
                        System.out.println("Error: Marks must be between 0 and 100. Please re-enter.");
                    } else {
                        break;
                    }
                }
            }

            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            if (percentages[i] >= 80) {
                grades[i] = "A";
                remarks[i] = "above agency-normalized standards";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
                remarks[i] = "at agency-normalized standards";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
                remarks[i] = "below but approaching agency-normalized standards";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
                remarks[i] = "Level-1, well below agency-normalized standards";
            } else if (percentages[i] >= 40) {
                grades[i] = "E";
                remarks[i] = "Level-1, too below agency-normalized standards";
            } else {
                grades[i] = "R";
                remarks[i] = "Remedial standards";
            }
        }

        System.out.println("\nResults:");
        System.out.printf("%-10s %-10s %-10s %-12s %-10s %-40s\n", "Physics", "Chemistry", "Maths", "Percentage", "Grade", "Remarks");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-12.2f %-10s %-40s\n",
                    marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i], remarks[i]);
        }

        scanner.close();
    }
}

