import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter marks for Physics: ");
        int physics = scanner.nextInt();

        System.out.print("Enter marks for Chemistry: ");
        int chemistry = scanner.nextInt();

        System.out.print("Enter marks for Maths: ");
        int maths = scanner.nextInt();

        int total = physics + chemistry + maths;
        double percentage = total / 3.0;

        String grade;
        String remarks;

        if (percentage >= 80) {
            grade = "A";
            remarks = "above agency-normalized standards";
        } else if (percentage >= 70) {
            grade = "B";
            remarks = "at agency-normalized standards";
        } else if (percentage >= 60) {
            grade = "C";
            remarks = "below but approaching agency-normalized standards";
        } else if (percentage >= 50) {
            grade = "D";
            remarks = "Level-1,well below agency-normalized standards";
        } else if (percentage >= 40) {
            grade = "E";
            remarks = "Level-1,too below agency-normalized standards";
        } else {
            grade = "R";
            remarks = "Remedial standards";
        }

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);

        scanner.close();
    }
}
