package JavaGenerics;

import java.util.List;

abstract class CourseType {}

class ExamCourse extends CourseType {}
class AssignmentCourse extends CourseType {}
class ResearchCourse extends CourseType {}

class Course<T extends CourseType> {
    private T courseType;
    private String courseName;
    public Course(T courseType, String courseName) {
        this.courseType = courseType;
        this.courseName = courseName;
    }
    public T getCourseType() { return courseType; }
    public String getCourseName() { return courseName; }
}

class CourseUtils {
    public static void printCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            System.out.println("Course Type: " + c.getClass().getSimpleName());
        }
    }
}
