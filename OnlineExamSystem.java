import java.util.*;

enum DifficultyLevel {
    EASY, MEDIUM, HARD
}

class Question<T> {
    private String questionText;
    private DifficultyLevel difficultyLevel;
    private Map<Character, String> options;
    private T correctAnswer;

    public Question(String questionText, DifficultyLevel difficultyLevel, Map<Character, String> options, T correctAnswer) {
        this.questionText = questionText;
        this.difficultyLevel = difficultyLevel;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public Map<Character, String> getOptions() {
        return options;
    }

    public T getCorrectAnswer() {
        return correctAnswer;
    }
}

class Subject {
    private String name;
    private List<Question<?>> questions;

    public Subject(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Question<?>> getQuestions() {
        return questions;
    }

    public void addQuestion(Question<?> question) {
        questions.add(question);
    }
}

class Student {
    private String name;
    private String rollNumber;
    private Map<Subject, Map<Question<?>, Object>> submittedAnswers;

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.submittedAnswers = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void submitAnswer(Subject subject, Question<?> question, Object answer) {
        submittedAnswers.putIfAbsent(subject, new HashMap<>());
        submittedAnswers.get(subject).put(question, answer);
    }

    public Map<Subject, Map<Question<?>, Object>> getSubmittedAnswers() {
        return submittedAnswers;
    }
}

public class OnlineExamSystem {
    private List<Subject> subjects;

    public OnlineExamSystem() {
        subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public Subject getSubjectByName(String name) {
        for (Subject subject : subjects) {
            if (subject.getName().equalsIgnoreCase(name)) {
                return subject;
            }
        }
        return null;
    }

    public int calculateScore(Student student, Subject subject) {
        int score = 0;
        Map<Question<?>, Object> answers = student.getSubmittedAnswers().get(subject);
        if (answers == null) return 0;

        for (Question<?> question : subject.getQuestions()) {
            Object submittedAnswer = answers.get(question);
            if (submittedAnswer != null && submittedAnswer.equals(question.getCorrectAnswer())) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        OnlineExamSystem system = new OnlineExamSystem();

        Subject java = new Subject("Java");
        Subject dbms = new Subject("DBMS");

        Map<Character, String> options1 = new HashMap<>();
        options1.put('A', "Java Virtual Machine");
        options1.put('B', "Just Virtual Machine");
        options1.put('C', "Java Vendor Machine");
        options1.put('D', "None of the above");
        Question<String> q1 = new Question<>("What does JVM stand for?", DifficultyLevel.EASY, options1, "A");
        java.addQuestion(q1);

        Map<Character, String> options2 = new HashMap<>();
        options2.put('A', "1");
        options2.put('B', "2");
        options2.put('C', "3");
        options2.put('D', "4");
        Question<Integer> q2 = new Question<>("How many normal forms are there?", DifficultyLevel.MEDIUM, options2, 3);
        dbms.addQuestion(q2);

        system.addSubject(java);
        system.addSubject(dbms);

        Student student = new Student("Alice", "R001");

        student.submitAnswer(java, q1, "A");

        student.submitAnswer(dbms, q2, 3);

        int javaScore = system.calculateScore(student, java);
        int dbmsScore = system.calculateScore(student, dbms);

        System.out.println("Score in Java: " + javaScore + "/" + java.getQuestions().size());
        System.out.println("Score in DBMS: " + dbmsScore + "/" + dbms.getQuestions().size());
    }
}
