import java.util.ArrayList;
import java.util.List;

// Abstract class for Course Types
abstract class CourseType {
    public abstract String getEvaluationType();
}

// Exam-based Course
class ExamCourse extends CourseType {
    @Override
    public String getEvaluationType() {
        return "Exam-Based";
    }
}

// Assignment-based Course
class AssignmentCourse extends CourseType {
    @Override
    public String getEvaluationType() {
        return "Assignment-Based";
    }
}

// Research-based Course
class ResearchCourse extends CourseType {
    @Override
    public String getEvaluationType() {
        return "Research-Based";
    }
}

// Generic Course Class
class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseType=" + courseType.getEvaluationType() +
                '}';
    }
}

// Course Management System
class CourseManagementSystem {
    private List<? extends CourseType> courses;

    public CourseManagementSystem(List<? extends CourseType> courses) {
        this.courses = courses;
    }

    public void displayCourses() {
        for (CourseType course : courses) {
            System.out.println(course.getEvaluationType());
        }
    }
}

// Main Class to Demonstrate Functionality
public class MultiLevel_University_Course_Management_System {
    public static void main(String[] args) {
        // Creating specific courses
        Course<ExamCourse> examCourse = new Course<>("Mathematics", new ExamCourse());
        Course<AssignmentCourse> assignmentCourse = new Course<>("Computer Science", new AssignmentCourse());
        Course<ResearchCourse> researchCourse = new Course<>("Artificial Intelligence", new ResearchCourse());

        // Creating a list of courses
        List<CourseType> courseList = new ArrayList<>();
        courseList.add(examCourse.getCourseType());
        courseList.add(assignmentCourse.getCourseType());
        courseList.add(researchCourse.getCourseType());

        // Course Management System
        CourseManagementSystem cms = new CourseManagementSystem(courseList);
        cms.displayCourses();
    }
}
