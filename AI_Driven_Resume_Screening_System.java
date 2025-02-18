import java.util.ArrayList;
import java.util.List;

// Abstract class for Job Roles
abstract class JobRole {
    public abstract String getRoleName();
}

// Software Engineer Job Role
class SoftwareEngineer extends JobRole {
    @Override
    public String getRoleName() {
        return "Software Engineer";
    }
}

// Data Scientist Job Role
class DataScientist extends JobRole {
    @Override
    public String getRoleName() {
        return "Data Scientist";
    }
}

// Product Manager Job Role
class ProductManager extends JobRole {
    @Override
    public String getRoleName() {
        return "Product Manager";
    }
}

// Generic Resume Class
class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "candidateName='" + candidateName + '\'' +
                ", jobRole=" + jobRole.getRoleName() +
                '}';
    }
}

// Resume Screening System
class ResumeScreeningSystem {
    public static void screenResumes(List<? extends JobRole> jobRoles, List<Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            if (jobRoles.contains(resume.getJobRole())) {
                System.out.println("Screening Resume: " + resume);
            } else {
                System.out.println("Resume " + resume.getCandidateName() + " does not match any job role.");
            }
        }
    }
}

// Main Class to Demonstrate Functionality
public class AI_Driven_Resume_Screening_System {
    public static void main(String[] args) {
        // Creating job roles
        JobRole softwareEngineer = new SoftwareEngineer();
        JobRole dataScientist = new DataScientist();
        JobRole productManager = new ProductManager();

        // Creating a list of job roles
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(softwareEngineer);
        jobRoles.add(dataScientist);
        jobRoles.add(productManager);

        // Creating resumes
        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> resume2 = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> resume3 = new Resume<>("Charlie", new ProductManager());
        Resume<SoftwareEngineer> resume4 = new Resume<>("David", new SoftwareEngineer());

        // Creating a list of resumes
        List<Resume<? extends JobRole>> resumes = new ArrayList<>();
        resumes.add(resume1);
        resumes.add(resume2);
        resumes.add(resume3);
        resumes.add(resume4);

        // Screening resumes
        ResumeScreeningSystem.screenResumes(jobRoles, resumes);
    }
}
