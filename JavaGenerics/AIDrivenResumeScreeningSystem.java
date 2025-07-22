package JavaGenerics;

import java.util.List;

abstract class JobRole {}

class SoftwareEngineer extends JobRole {}
class DataScientist extends JobRole {}
class ProductManager extends JobRole {}

class Resume<T extends JobRole> {
    private T jobRole;
    private String candidateName;
    public Resume(T jobRole, String candidateName) {
        this.jobRole = jobRole;
        this.candidateName = candidateName;
    }
    public T getJobRole() { return jobRole; }
    public String getCandidateName() { return candidateName; }
}

class ResumeUtils {
    public static void screenResumes(List<? extends JobRole> jobRoles) {
        for (JobRole role : jobRoles) {
            System.out.println("Screening for role: " + role.getClass().getSimpleName());
        }
    }
}
