package Day5_Inheritance;

class EducationalCourse {
    protected String courseName;
    protected int duration;

    public EducationalCourse(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends EducationalCourse {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: " + fee);
        System.out.println("Discount: " + discount + "%");
    }

    public static void main(String[] args) {
        EducationalCourse basic = new EducationalCourse("Mathematics", 8);
        OnlineCourse online = new OnlineCourse("Java Programming", 10, "Coursera", true);
        PaidOnlineCourse paid = new PaidOnlineCourse("Data Science", 12, "Udemy", false, 5000, 20);

        System.out.println("=== Basic Course ===");
        basic.displayInfo();
        System.out.println("\n=== Online Course ===");
        online.displayInfo();
        System.out.println("\n=== Paid Online Course ===");
        paid.displayInfo();
    }
}